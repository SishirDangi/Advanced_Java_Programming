import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AdvancedMenuDemo extends JFrame {

    public AdvancedMenuDemo() {
        // Set up the frame
        setTitle("Advanced Menu Demo");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic('F'); // Alt+F

        JMenuItem newItem = new JMenuItem("New");
        newItem.setMnemonic('N'); // Alt+N
        newItem.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
        newItem.setIcon(new ImageIcon("path_to_new_icon.png")); // Replace with your icon path
        newItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "New File Created"));

        JMenuItem openItem = new JMenuItem("Open");
        openItem.setMnemonic('O'); // Alt+O
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        openItem.setIcon(new ImageIcon("path_to_open_icon.png")); // Replace with your icon path

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('E'); // Alt+E
        exitItem.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
        exitItem.addActionListener(e -> System.exit(0));

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator(); // Adds a separator line
        fileMenu.add(exitItem);

        // Edit Menu with Checkable Items
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic('E'); // Alt+E

        JCheckBoxMenuItem cutItem = new JCheckBoxMenuItem("Cut");
        cutItem.setMnemonic('C'); // Alt+C
        cutItem.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));

        JCheckBoxMenuItem copyItem = new JCheckBoxMenuItem("Copy");
        copyItem.setMnemonic('P'); // Alt+P
        copyItem.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));

        JCheckBoxMenuItem pasteItem = new JCheckBoxMenuItem("Paste");
        pasteItem.setMnemonic('T'); // Alt+T
        pasteItem.setAccelerator(KeyStroke.getKeyStroke("ctrl V"));

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // View Menu with Radio Buttons
        JMenu viewMenu = new JMenu("View");
        viewMenu.setMnemonic('V'); // Alt+V

        ButtonGroup themeGroup = new ButtonGroup();
        JRadioButtonMenuItem lightTheme = new JRadioButtonMenuItem("Light Theme");
        JRadioButtonMenuItem darkTheme = new JRadioButtonMenuItem("Dark Theme");
        lightTheme.setSelected(true); // Default selection

        themeGroup.add(lightTheme);
        themeGroup.add(darkTheme);

        viewMenu.add(lightTheme);
        viewMenu.add(darkTheme);

        // Help Menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H'); // Alt+H

        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.setMnemonic('A'); // Alt+A
        aboutItem.setAccelerator(KeyStroke.getKeyStroke("ctrl H"));
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(this, "This is a demo application"));

        helpMenu.add(aboutItem);

        // Submenu in File Menu
        JMenu exportMenu = new JMenu("Export");
        exportMenu.setMnemonic('X'); // Alt+X

        JMenuItem pdfItem = new JMenuItem("Export as PDF");
        pdfItem.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));
        exportMenu.add(pdfItem);

        JMenuItem docItem = new JMenuItem("Export as DOC");
        docItem.setAccelerator(KeyStroke.getKeyStroke("ctrl D"));
        exportMenu.add(docItem);

        fileMenu.add(exportMenu);

        // Disable a menu item after action
        newItem.addActionListener(e -> openItem.setEnabled(false)); // Disables 'Open' after 'New'

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);

        // Set the menu bar to the frame
        setJMenuBar(menuBar);

        // Set frame visibility
        setVisible(true);
    }

    public static void main(String[] args) {
        new AdvancedMenuDemo();
    }
}
