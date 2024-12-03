import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class DialogBoxDemo extends JFrame {

    public DialogBoxDemo() {
        // Set up the frame
        setTitle("Dialog Box Demo");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 1, 10, 10)); // 7 rows for 7 buttons

        // Buttons for each dialog type
        JButton infoButton = new JButton("Information Dialog");
        JButton questionButton = new JButton("Question Dialog");
        JButton errorButton = new JButton("Error Dialog");
        JButton warningButton = new JButton("Warning Dialog");
        JButton confirmButton = new JButton("Confirm Dialog");
        JButton inputButton = new JButton("Input Dialog");
        JButton optionButton = new JButton("Option Dialog");

        // Add action listeners to each button
        infoButton.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "This is an information message.",
                "Information",
                JOptionPane.INFORMATION_MESSAGE
        ));

        questionButton.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "Do you have any questions?",
                "Question",
                JOptionPane.QUESTION_MESSAGE
        ));

        errorButton.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "An error has occurred!",
                "Error",
                JOptionPane.ERROR_MESSAGE
        ));

        warningButton.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "This is a warning message.",
                "Warning",
                JOptionPane.WARNING_MESSAGE
        ));

        confirmButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to continue?",
                    "Confirm",
                    JOptionPane.YES_NO_CANCEL_OPTION
            );
            switch (result) {
                case JOptionPane.YES_OPTION:
                    JOptionPane.showMessageDialog(this, "You selected Yes.");
                    break;
                case JOptionPane.NO_OPTION:
                    JOptionPane.showMessageDialog(this, "You selected No.");
                    break;
                case JOptionPane.CANCEL_OPTION:
                    JOptionPane.showMessageDialog(this, "You selected Cancel.");
                    break;
            }
        });

        inputButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(
                    this,
                    "Enter your name:",
                    "Input Dialog",
                    JOptionPane.PLAIN_MESSAGE
            );
            if (input != null) {
                JOptionPane.showMessageDialog(this, "Hello, " + input + "!");
            }
        });

        optionButton.addActionListener(e -> {
            String[] options = {"Option 1", "Option 2", "Option 3"};
            int choice = JOptionPane.showOptionDialog(
                    this,
                    "Choose an option:",
                    "Option Dialog",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]
            );
            if (choice != -1) {
                JOptionPane.showMessageDialog(this, "You selected: " + options[choice]);
            }
        });

        // Add buttons to the frame
        add(infoButton);
        add(questionButton);
        add(errorButton);
        add(warningButton);
        add(confirmButton);
        add(inputButton);
        add(optionButton);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DialogBoxDemo::new);
    }
}
