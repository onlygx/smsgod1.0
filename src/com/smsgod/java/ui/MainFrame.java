package com.smsgod.java.ui;

import javax.swing.*;

/**
 * Created by GaoXiang on 2016/4/21 0021.
 */
public class MainFrame extends  JFrame{

    private JPanel jpIndex;
    private JLabel lbIndex;

    public MainFrame(){
        super("SMS God - 人生转折点");

        System.out.println("JFrame 构造...");

        //关闭事件方式
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //不能改变窗体大小
        setResizable(false);

    }




}
