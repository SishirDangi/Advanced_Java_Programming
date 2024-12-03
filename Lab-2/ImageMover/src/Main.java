import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class ImageMover extends JFrame {

    private int x = 200; // Initial x position
    private int y = 200; // Initial y position
    private final int STEP = 10; // Step size for movement

    private ImageIcon imageIcon;

    public ImageMover() {
        // Set up the frame
        setTitle("Move Image with Arrow Keys");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load an image (replace "path_to_image.png" with your image path)
        imageIcon = new ImageIcon("free-nature-images.jpg");

        // Add a KeyListener to handle arrow key presses
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        y -= STEP; // Move up
                        break;
                    case KeyEvent.VK_DOWN:
                        y += STEP; // Move down
                        break;
                    case KeyEvent.VK_LEFT:
                        x -= STEP; // Move left
                        break;
                    case KeyEvent.VK_RIGHT:
                        x += STEP; // Move right
                        break;
                }
                repaint(); // Repaint the frame to update the image position
            }
        });

        // Ensure the frame is focusable for key events
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Clear the previous frame
        g.drawImage(imageIcon.getImage(), x, y, null); // Draw the image at the current position
    }

    public static void main(String[] args) {
        // Create and display the frame
        ImageMover frame = new ImageMover();
        frame.setVisible(true);
    }
}
