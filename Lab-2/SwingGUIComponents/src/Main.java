import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

class SwingGUIComponents extends JFrame {

    public SwingGUIComponents() {
        // Set up the frame
        setTitle("Swing GUI Components Demo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for Slider and Progress Bar
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 2, 10, 10));

        // Slider with change event handling
        JLabel sliderLabel = new JLabel("Slider Value: 50", SwingConstants.CENTER);
        JSlider slider = new JSlider(0, 100, 50);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(e -> {
            int value = slider.getValue();
            sliderLabel.setText("Slider Value: " + value);
        });

        // Progress Bar
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(50);
        progressBar.setStringPainted(true);

        topPanel.add(sliderLabel);
        topPanel.add(slider);
        topPanel.add(new JLabel("Progress Bar:", SwingConstants.CENTER));
        topPanel.add(progressBar);

        // Panel for List, Table, and Tree
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3, 10, 10));

        // List with event handling
        JLabel listLabel = new JLabel("Selected Item: None", SwingConstants.CENTER);
        String[] listItems = {"Item 1", "Item 2", "Item 3", "Item 4"};
        JList<String> list = new JList<>(listItems);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedItem = list.getSelectedValue();
                listLabel.setText("Selected Item: " + selectedItem);
            }
        });
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(listLabel, BorderLayout.NORTH);
        listPanel.add(new JScrollPane(list), BorderLayout.CENTER);

        // Table
        String[] columnNames = {"ID", "Name", "Age"};
        Object[][] data = {
                {1, "Sishir Dangi", 23},
                {2, "Santosh Bhandari", 37},
                {3, "Raj Rai", 26},
        };
        JTable table = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane tableScrollPane = new JScrollPane(table);

        // Tree
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode childA = new DefaultMutableTreeNode("Child A");
        DefaultMutableTreeNode childB = new DefaultMutableTreeNode("Child B");
        root.add(childA);
        root.add(childB);
        childA.add(new DefaultMutableTreeNode("Child A1"));
        childA.add(new DefaultMutableTreeNode("Child A2"));
        childB.add(new DefaultMutableTreeNode("Child B1"));
        childB.add(new DefaultMutableTreeNode("Child B2"));
        JTree tree = new JTree(root);
        JScrollPane treeScrollPane = new JScrollPane(tree);

        // Add components to bottom panel
        bottomPanel.add(listPanel);
        bottomPanel.add(tableScrollPane);
        bottomPanel.add(treeScrollPane);

        // Add panels to the frame
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.CENTER);

        // Make frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingGUIComponents::new);
    }
}
