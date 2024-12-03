import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

 class CRUDApplication {
    // Database connection details
    static final String DB_URL = "jdbc:mysql://localhost:3306/sishir_database";
    static final String USER = "root";
    static final String PASSWORD = "";

    // UI Components
    private JFrame frame;
    private JTextField idField, nameField;
    private JRadioButton maleButton, femaleButton;
    private JComboBox<String> roleComboBox;
    private JButton createButton, readButton, updateButton, deleteButton;

    public CRUDApplication() {
        // Initialize UI components
        frame = new JFrame("CRUD Application");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2));

        // ID
        frame.add(new JLabel("ID:"));
        idField = new JTextField();
        frame.add(idField);

        // Name
        frame.add(new JLabel("Name:"));
        nameField = new JTextField();
        frame.add(nameField);

        // Gender
        frame.add(new JLabel("Gender:"));
        JPanel genderPanel = new JPanel();
        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        frame.add(genderPanel);

        // Role
        frame.add(new JLabel("Role:"));
        String[] roles = {"Admin", "User", "Guest"};
        roleComboBox = new JComboBox<>(roles);
        frame.add(roleComboBox);

        // Buttons
        createButton = new JButton("Create");
        readButton = new JButton("Read");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        frame.add(createButton);
        frame.add(readButton);
        frame.add(updateButton);
        frame.add(deleteButton);

        // Button actions
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createUser();
            }
        });

        readButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readUser();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateUser();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteUser();
            }
        });

        frame.setVisible(true);
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    private void createUser() {
        String name = nameField.getText();
        String gender = maleButton.isSelected() ? "Male" : "Female";
        String role = (String) roleComboBox.getSelectedItem();

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO users (name, gender, role) VALUES (?, ?, ?)")) {
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, role);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(frame, "User created successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error creating user!");
        }
    }

    private void readUser() {
        int id = Integer.parseInt(idField.getText());
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nameField.setText(rs.getString("name"));
                if (rs.getString("gender").equals("Male")) {
                    maleButton.setSelected(true);
                } else {
                    femaleButton.setSelected(true);
                }
                roleComboBox.setSelectedItem(rs.getString("role"));
            } else {
                JOptionPane.showMessageDialog(frame, "User not found!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error reading user!");
        }
    }

    private void updateUser() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String gender = maleButton.isSelected() ? "Male" : "Female";
        String role = (String) roleComboBox.getSelectedItem();

        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement("UPDATE users SET name = ?, gender = ?, role = ? WHERE id = ?")) {
            ps.setString(1, name);
            ps.setString(2, gender);
            ps.setString(3, role);
            ps.setInt(4, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(frame, "User updated successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error updating user!");
        }
    }

    private void deleteUser() {
        int id = Integer.parseInt(idField.getText());
        try (Connection conn = connect();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM users WHERE id = ?")) {
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(frame, "User deleted successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error deleting user!");
        }
    }

    public static void main(String[] args) {
        new CRUDApplication();
    }
}
