import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EventHandlingDemo extends JFrame {

    public EventHandlingDemo() {
        // Set up the frame
        setTitle("Event Handling Demo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Components
        JTextField focusTextField = new JTextField(20);
        JCheckBox itemCheckBox = new JCheckBox("Enable feature");
        JLabel mouseLabel = new JLabel("Mouse Event Area", SwingConstants.CENTER);
        mouseLabel.setPreferredSize(new Dimension(200, 50));
        JTextArea keyTextArea = new JTextArea(5, 30);
        JScrollPane scrollPane = new JScrollPane(keyTextArea);

        // Add components to the frame
        add(new JLabel("Focus Text Field:"));
        add(focusTextField);
        add(itemCheckBox);
        add(mouseLabel);
        add(new JLabel("Type here (Key Event Demo):"));
        add(scrollPane);

        // Window Event Handling
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window is closing.");
            }

            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("Window opened.");
            }
        });

        // Item Event Handling
        itemCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JOptionPane.showMessageDialog(EventHandlingDemo.this, "Checkbox Selected");
                } else {
                    JOptionPane.showMessageDialog(EventHandlingDemo.this, "Checkbox Deselected");
                }
            }
        });

        // Focus Event Handling
        focusTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                focusTextField.setBackground(Color.YELLOW);
                System.out.println("Focus gained on text field.");
            }

            @Override
            public void focusLost(FocusEvent e) {
                focusTextField.setBackground(Color.WHITE);
                System.out.println("Focus lost from text field.");
            }
        });

        // Mouse Event Handling using Adapter
        mouseLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(EventHandlingDemo.this, "Mouse Clicked!");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                mouseLabel.setBackground(Color.LIGHT_GRAY);
                mouseLabel.setOpaque(true);
                System.out.println("Mouse Entered the label.");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseLabel.setBackground(null);
                System.out.println("Mouse Exited the label.");
            }
        });

        // Key Event Handling
        keyTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Key Typed: " + e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key Pressed: " + e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Key Released: " + e.getKeyCode());
            }
        });

        // Make frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        new EventHandlingDemo();
    }
}
