package com.smsgod.java.ui;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;

/**
 * Created by GaoXiang on 2016/4/21 0021.
 */
public class MainPage extends  JFrame{
    private JPanel index1;
    private JButton bt1;
    private JButton bt2;
    private JButton bt3;
    private JTextField phoneNumber;
    private JTextField chixuTime;
    private JButton btBegin;
    private JButton btStop;
    private JLabel lb1;
    private JLabel lb2;
    private JLabel lb3;
    private JLabel lb4;
    private JTextField jiangeTime;
    private JPanel jpContent1;

    public MainPage(){
        bt1.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        bt2.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        bt3.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));

        btBegin.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
        btStop.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));

    }

    public static void main(String[] args) {
        try
        {
            //设置本属性将改变窗口边框样式定义
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
            //隐藏设置按钮
            UIManager.put("RootPane.setupButtonVisible", false);
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

        }catch (Exception e) {
            System.err.println("加载样式失败！");
        }
        JFrame frame = new JFrame("MainPage");
        frame.setContentPane(new MainPage().index1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500,350);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }


}
