package com.smsgod.java.ui;

import javax.swing.*;

/**
 * Created by GaoXiang on 2016/4/22 0022.
 */
public class JPContent2 extends JPanel {
    private JPanel JP1;
    private JPanel form;
    private JPanel ctrlBtn;
    private JButton test;
    private JButton add;
    private JRadioButton rPost;
    private JRadioButton rGet;
    private JLabel l1;
    private JPanel c2;
    private JTextField url;
    private JLabel l2;
    private JLabel l3;
    private JPanel cm1;
    private JTextField header;
    private JTextField paramBody;

    public static void main(String[] args) {
        JFrame frame = new JFrame("JPContent2");
        frame.setContentPane(new JPContent2().JP1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public JPContent2() {
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rPost);
        buttonGroup.add(rGet);
    }
}
