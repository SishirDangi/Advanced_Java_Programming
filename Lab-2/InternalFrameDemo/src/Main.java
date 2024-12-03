import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class InternalFrameDemo extends JFrame {

    public InternalFrameDemo() {
        // Set up the main frame
        setTitle("Internal Frame Demo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a desktop pane to manage internal frames
        JDesktopPane desktopPane = new JDesktopPane();

        // Add a toolbar with a button to create internal frames
        JToolBar toolBar = new JToolBar();
        JButton addFrameButton = new JButton("Add Internal Frame");
        toolBar.add(addFrameButton);

        // Action listener to add a new internal frame
        addFrameButton.addActionListener(new ActionListener() {
            private int frameCount = 0; // Counter for internal frames

            @Override
            public void actionPerformed(ActionEvent e) {
                frameCount++;
                JInternalFrame internalFrame = new JInternalFrame(
                        "Internal Frame " + frameCount,
                        true, // Resizable
                        true, // Closable
                        true, // Maximizable
                        true  // Iconifiable
                );
                internalFrame.setSize(300, 200);
                internalFrame.setVisible(true);

                // Add some content to the internal frame
                JLabel label = new JLabel("Content of Internal Frame " + frameCount, SwingConstants.CENTER);
                internalFrame.add(label, BorderLayout.CENTER);

                desktopPane.add(internalFrame);
                try {
                    internalFrame.setSelected(true); // Bring the frame to the front
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Add components to the main frame
        add(toolBar, BorderLayout.NORTH);
        add(desktopPane, BorderLayout.CENTER);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InternalFrameDemo::new);
    }
}
