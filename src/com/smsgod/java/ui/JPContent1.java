package com.smsgod.java.ui;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;

/**
 * Created by GaoXiang on 2016/4/22 0022.
 */
public class JPContent1 extends JPanel{

    public JPanel JP1;
    private JPanel jpContent1;
    private JPanel jptext;
    private JLabel lb1;
    private JTextField phoneNumber;
    private JLabel lb2;
    private JLabel lb4;
    private JPanel jpctrl;
    private JButton btBegin;
    private JButton btStop;
    private JPanel jplabel;
    private JLabel lb3;
    private JComboBox time;
    private JSpinner spinner1;


    public JPContent1(){
        System.out.println("JPContent1 构造...");
        setVisible(false);
        try {
           btBegin.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
           btStop.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        } catch (Exception e) {
           System.out.println("设置按钮ui失败！");
           e.printStackTrace();
        }

    }

}
