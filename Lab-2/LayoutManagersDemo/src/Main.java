import javax.swing.*;
import java.awt.*;

class LayoutManagersDemo {

    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Layout Managers Demo");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTabbedPane tabbedPane = new JTabbedPane();

        // Flow Layout
        JPanel flowLayoutPanel = new JPanel(new FlowLayout());
        for (int i = 1; i <= 5; i++) {
            flowLayoutPanel.add(new JButton("Button " + i));
        }
        tabbedPane.add("Flow Layout", flowLayoutPanel);

        // Border Layout
        JPanel borderLayoutPanel = new JPanel(new BorderLayout());
        borderLayoutPanel.add(new JButton("North"), BorderLayout.NORTH);
        borderLayoutPanel.add(new JButton("South"), BorderLayout.SOUTH);
        borderLayoutPanel.add(new JButton("East"), BorderLayout.EAST);
        borderLayoutPanel.add(new JButton("West"), BorderLayout.WEST);
        borderLayoutPanel.add(new JButton("Center"), BorderLayout.CENTER);
        tabbedPane.add("Border Layout", borderLayoutPanel);

        // Grid Layout
        JPanel gridLayoutPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++) {
            gridLayoutPanel.add(new JButton("Button " + i));
        }
        tabbedPane.add("Grid Layout", gridLayoutPanel);

        // GridBag Layout
        JPanel gridBagLayoutPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gridBagLayoutPanel.add(new JButton("Button 1"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gridBagLayoutPanel.add(new JButton("Button 2"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gridBagLayoutPanel.add(new JButton("Button 3 (Spanning)"), gbc);
        tabbedPane.add("GridBag Layout", gridBagLayoutPanel);

        // Group Layout
        JPanel groupLayoutPanel = new JPanel();
        GroupLayout groupLayout = new GroupLayout(groupLayoutPanel);
        groupLayoutPanel.setLayout(groupLayout);

        JButton btn1 = new JButton("Button 1");
        JButton btn2 = new JButton("Button 2");
        JButton btn3 = new JButton("Button 3");

        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addComponent(btn1)
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(btn2)
                                .addComponent(btn3))
        );

        groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btn1)
                                .addComponent(btn2))
                        .addComponent(btn3)
        );

        tabbedPane.add("Group Layout", groupLayoutPanel);

        // Add the tabbed pane to the frame
        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
