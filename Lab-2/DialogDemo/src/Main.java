import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DialogDemo extends JFrame {

    public DialogDemo() {
        // Set up the frame
        setTitle("Dialog Box Demo");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a toolbar
        JToolBar toolBar = new JToolBar();
        JButton modalButton = new JButton("Modal Dialog");
        JButton modelessButton = new JButton("Modeless Dialog");

        toolBar.add(modalButton);
        toolBar.add(modelessButton);
        add(toolBar, BorderLayout.NORTH);

        // Add action listener for the "Modal Dialog" button
        modalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and display a modal dialog
                JDialog modalDialog = new JDialog(DialogDemo.this, "Modal Dialog", true); // true makes it modal
                modalDialog.setSize(300, 150);
                modalDialog.setLayout(new BorderLayout());
                modalDialog.add(new JLabel("This is a Modal Dialog", SwingConstants.CENTER), BorderLayout.CENTER);
                JButton closeButton = new JButton("Close");
                closeButton.addActionListener(e1 -> modalDialog.dispose());
                modalDialog.add(closeButton, BorderLayout.SOUTH);
                modalDialog.setLocationRelativeTo(DialogDemo.this);
                modalDialog.setVisible(true);
            }
        });

        // Add action listener for the "Modeless Dialog" button
        modelessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Create and display a modeless dialog
                JDialog modelessDialog = new JDialog(DialogDemo.this, "Modeless Dialog", false); // false makes it modeless
                modelessDialog.setSize(300, 150);
                modelessDialog.setLayout(new BorderLayout());
                modelessDialog.add(new JLabel("This is a Modeless Dialog", SwingConstants.CENTER), BorderLayout.CENTER);
                JButton closeButton = new JButton("Close");
                closeButton.addActionListener(e1 -> modelessDialog.dispose());
                modelessDialog.add(closeButton, BorderLayout.SOUTH);
                modelessDialog.setLocationRelativeTo(DialogDemo.this);
                modelessDialog.setVisible(true);
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DialogDemo::new);
    }
}
