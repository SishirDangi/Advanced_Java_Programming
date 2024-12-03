import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GUI_using_swing {

    public static void main(String[] args) {
        // Create JFrame with title
        JFrame frame = new JFrame("Swing GUI Example");
        frame.setSize(600, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set a custom logo icon for the JFrame
        ImageIcon logoIcon = new ImageIcon("logo.png"); // Replace with the actual path
        frame.setIconImage(logoIcon.getImage());

        // Create a JPanel for the content
        JPanel panel = new JPanel();
        panel.setLayout(null); // Using absolute layout for custom positioning

        // Label with an icon
        JLabel iconLabel = new JLabel(new ImageIcon("logo.png")); // Replace with your image path
        iconLabel.setBounds(20, 20, 100, 100);
        panel.add(iconLabel);

        // Label displaying your name
        JLabel nameLabel = new JLabel("Sishir Dangi");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setBounds(140, 20, 200, 30);
        panel.add(nameLabel);

        // Label for Text Field
        JLabel textFieldLabel = new JLabel("Enter Text:");
        textFieldLabel.setBounds(20, 80, 100, 30);
        panel.add(textFieldLabel);

        // Text field with colorful border and tooltip
        JTextField textField = new JTextField();
        textField.setBounds(140, 80, 300, 30);
        textField.setToolTipText("Enter your text here");
        textField.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        panel.add(textField);

        // Label for Text Area
        JLabel textAreaLabel = new JLabel("Enter Comments:");
        textAreaLabel.setBounds(20, 140, 100, 30);
        panel.add(textAreaLabel);

        // Text area with scroll bars
        JTextArea textArea = new JTextArea();
        JScrollPane textScrollPane = new JScrollPane(textArea);
        textScrollPane.setBounds(140, 140, 300, 100);
        textScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        panel.add(textScrollPane);

        // Label for Checkboxes
        JLabel checkBoxLabel = new JLabel("Select Options:");
        checkBoxLabel.setBounds(20, 260, 100, 30);
        panel.add(checkBoxLabel);

        // Checkboxes
        JCheckBox checkBox1 = new JCheckBox("Option 1");
        JCheckBox checkBox2 = new JCheckBox("Option 2");
        checkBox1.setBounds(140, 260, 100, 30);
        checkBox2.setBounds(250, 260, 100, 30);
        panel.add(checkBox1);
        panel.add(checkBox2);

        // Label for Password Field
        JLabel passwordLabel = new JLabel("Enter Password:");
        passwordLabel.setBounds(20, 310, 120, 30);
        panel.add(passwordLabel);

        // Password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(140, 310, 300, 30);
        passwordField.setToolTipText("Enter your password");
        panel.add(passwordField);

        // Label for Radio Buttons
        JLabel genderLabel = new JLabel("Select Gender:");
        genderLabel.setBounds(20, 360, 120, 30);
        panel.add(genderLabel);

        // Radio buttons with a ButtonGroup
        JRadioButton radioButton1 = new JRadioButton("Male");
        JRadioButton radioButton2 = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(radioButton1);
        genderGroup.add(radioButton2);
        radioButton1.setBounds(140, 360, 100, 30);
        radioButton2.setBounds(250, 360, 100, 30);
        panel.add(radioButton1);
        panel.add(radioButton2);

        // Label for Combo Box
        JLabel comboBoxLabel = new JLabel("Choose Option:");
        comboBoxLabel.setBounds(20, 410, 120, 30);
        panel.add(comboBoxLabel);

        // Combo box
        String[] comboBoxOptions = {"Option 1", "Option 2", "Option 3"};
        JComboBox<String> comboBox = new JComboBox<>(comboBoxOptions);
        comboBox.setBounds(140, 410, 300, 30);
        panel.add(comboBox);

        // Push button
        JButton button = new JButton("Submit");
        button.setBounds(140, 470, 300, 30);
        panel.add(button);

        // Add an action listener for the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = "Button Clicked!\n";
                message += "Text Field: " + textField.getText() + "\n";
                message += "Text Area: " + textArea.getText() + "\n";
                message += "Password: " + new String(passwordField.getPassword()) + "\n";
                message += "Selected Gender: " +
                        (radioButton1.isSelected() ? "Male" : (radioButton2.isSelected() ? "Female" : "None")) + "\n";
                message += "Selected Combo Box Option: " + comboBox.getSelectedItem();
                JOptionPane.showMessageDialog(frame, message, "Input Summary", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
