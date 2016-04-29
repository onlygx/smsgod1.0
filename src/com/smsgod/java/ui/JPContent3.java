package com.smsgod.java.ui;

import javax.swing.*;

/**
 * Created by GaoXiang on 2016/4/29 0029.
 */
public class JPContent3 {
    private JPanel JP1;
    private JTable table1;
    private JScrollPane jsp;
    private JLabel l1;
    private JLabel l2;

    public JPContent3() {
        JP1.setSize(500,300);
        jsp.setSize(450,280);

        String[] columnNames = {"Product","Number of Boxes","Price"};
        Object[][] data =
                {
                        {"Apples", new Integer(5),"5.00"},
                        {"Oranges", new Integer(3),"6.00"},
                        {"Pears", new Integer(2),"4.00"},
                        {"Grapes", new Integer(3),"2.00"},
                };
        table1 = new JTable(data,columnNames);
        table1.setSize(400,200);
        // 更新表格
        table1.invalidate();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("JPContent3");
        frame.setContentPane(new JPContent3().JP1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
