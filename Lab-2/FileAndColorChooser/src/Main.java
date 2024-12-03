import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class FileAndColorChooser extends JFrame {

    public FileAndColorChooser() {
        // Set up the frame
        setTitle("File and Color Chooser Demo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create buttons
        JButton fileChooserButton = new JButton("File Chooser");
        JButton colorChooserButton = new JButton("Color Chooser");

        // Add action listener for the "File Chooser" button
        fileChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open file chooser dialog
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(FileAndColorChooser.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    JOptionPane.showMessageDialog(FileAndColorChooser.this, "Selected File: " + selectedFile.getAbsolutePath());
                }
            }
        });

        // Add action listener for the "Color Chooser" button
        colorChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open color chooser dialog
                Color selectedColor = JColorChooser.showDialog(FileAndColorChooser.this, "Choose a Color", Color.WHITE);
                if (selectedColor != null) {
                    getContentPane().setBackground(selectedColor); // Set background color to selected color
                    JOptionPane.showMessageDialog(FileAndColorChooser.this, "Selected Color: " + selectedColor);
                }
            }
        });

        // Add buttons to the frame
        add(fileChooserButton);
        add(colorChooserButton);

        // Make frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FileAndColorChooser::new);
    }
}
