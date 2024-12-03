import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalculatorApp {

    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("Simple Calculator");
        frame.setSize(450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create components
        JLabel num1Label = new JLabel("Number 1:");
        num1Label.setBounds(50, 30, 80, 30);
        JTextField num1Field = new JTextField();
        num1Field.setBounds(150, 30, 200, 30);

        JLabel num2Label = new JLabel("Number 2:");
        num2Label.setBounds(50, 80, 80, 30);
        JTextField num2Field = new JTextField();
        num2Field.setBounds(150, 80, 200, 30);

        // Buttons and Labels
        JButton addButton = new JButton(new ImageIcon("path_to_add_icon.png")); // Replace with your add icon path
        addButton.setToolTipText("Add");
        addButton.setBounds(50, 140, 80, 50);

        JLabel addLabel = new JLabel("Add");
        addLabel.setBounds(60, 190, 50, 20);
        addLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton subtractButton = new JButton(new ImageIcon("path_to_subtract_icon.png")); // Replace with your subtract icon path
        subtractButton.setToolTipText("Subtract");
        subtractButton.setBounds(170, 140, 80, 50);

        JLabel subtractLabel = new JLabel("Subtract");
        subtractLabel.setBounds(170, 190, 80, 20);
        subtractLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton multiplyButton = new JButton(new ImageIcon("path_to_multiply_icon.png")); // Replace with your multiply icon path
        multiplyButton.setToolTipText("Multiply");
        multiplyButton.setBounds(290, 140, 80, 50);

        JLabel multiplyLabel = new JLabel("Multiply");
        multiplyLabel.setBounds(290, 190, 80, 20);
        multiplyLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(50, 250, 300, 30);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));

        // Add components to frame
        frame.add(num1Label);
        frame.add(num1Field);
        frame.add(num2Label);
        frame.add(num2Field);
        frame.add(addButton);
        frame.add(addLabel);
        frame.add(subtractButton);
        frame.add(subtractLabel);
        frame.add(multiplyButton);
        frame.add(multiplyLabel);
        frame.add(resultLabel);

        // Add Action Listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = num1 + num2;
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = num1 - num2;
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    double result = num1 * num2;
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Enter valid numbers!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Make frame visible
        frame.setVisible(true);
    }
}
