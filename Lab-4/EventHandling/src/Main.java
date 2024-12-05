import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Event handler in another class
class ExternalEventHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Button clicked (External Event Handler)");
    }
}

class EventHandling extends JFrame {
    private JButton sameClassButton;
    private JButton innerClassButton;
    private JButton anonymousClassButton;
    private JButton externalClassButton;

    public EventHandling() {
        // Frame settings
        setTitle("Swing Event Handling Demo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Buttons
        sameClassButton = new JButton("Same Class");
        innerClassButton = new JButton("Inner Class");
        anonymousClassButton = new JButton("Anonymous Class");
        externalClassButton = new JButton("External Class");

        // Adding buttons to frame
        add(sameClassButton);
        add(innerClassButton);
        add(anonymousClassButton);
        add(externalClassButton);

        // Event handling
        sameClassButton.addActionListener(this::sameClassHandler);
        innerClassButton.addActionListener(new InnerClassHandler());
        anonymousClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Button clicked (Anonymous Inner Class)");
            }
        });
        externalClassButton.addActionListener(new ExternalEventHandler());
    }

    // Event handling in the same class
    private void sameClassHandler(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Button clicked (Same Class)");
    }

    // Inner class for event handling
    private class InnerClassHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Button clicked (Inner Class)");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EventHandling frame = new EventHandling();
            frame.setVisible(true);
        });
    }
}
