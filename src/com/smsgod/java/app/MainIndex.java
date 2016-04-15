package com.smsgod.java.app;

import com.smsgod.java.util.HttpUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by GaoXiang on 2016/4/14 0014.
 */
public class MainIndex {
    private JPanel panel1;
    private JTextField textField1;
    private JButton beginButton;
    private JLabel phoneLabel;

    public MainIndex() {
        beginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("开始执行");
                try {
                    String phone = textField1.getText();
                    if(!"".equals(phone)){
                        System.out.println("号码："+phone);
                        HttpUtil.BeginSms(phone);
                    }else{
                        System.out.println("手机号不可为空！");
                        return;
                    }
                } catch (Exception e1) {
                    System.out.println("执行出错=====================");
                }
                System.out.println("结束执行");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainIndex");
        frame.setContentPane(new MainIndex().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
