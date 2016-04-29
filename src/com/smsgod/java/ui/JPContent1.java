package com.smsgod.java.ui;

import com.smsgod.java.util.MyThread;
import com.smsgod.java.util.ReadThread;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JLabel lb5;
    private JProgressBar jindu;
    private JTextField count;
    private JButton btSuspend;
    private JButton btResume;

    ReadThread readThread = null;

    public JPContent1(){
        System.out.println("JPContent1 构造...");

        String labels[] = { "1", "3", "5", "10", "60", "300" };
        time.setModel(new DefaultComboBoxModel(labels));
        count.setText("10");

        try {
            btBegin.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
            btSuspend.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.normal));
            btResume.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
            btStop.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        } catch (Exception e) {
           System.out.println("设置按钮ui失败！");
           e.printStackTrace();
        }




        btBegin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phonem = phoneNumber.getText();
                if("".equals(phonem)){
                    System.out.println("请输入手机号！");
                    return;
                }
                phoneNumber.setEnabled(false);
                time.setEnabled(false);
                count.setEnabled(false);
                int timem = 1;
                int countm = 10;
                try {
                    timem = Integer.parseInt(time.getSelectedItem().toString());
                    countm = Integer.parseInt(count.getText());

                } catch (NumberFormatException e1) {
                    timem = 1;
                    countm = 10;
                    count.setText("10(默认)");
                }
                readThread = new ReadThread("sms",timem*1000,countm,phonem,jindu);
                readThread.start();
            }
        });
        btStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(readThread == null){
                    return;
                }
                readThread.stop();
                readThread.resume();
                phoneNumber.setEnabled(true);
                time.setEnabled(true);
                count.setEnabled(true);
                jindu.setValue(0);
            }
        });
        btSuspend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(readThread == null){
                    return;
                }
                readThread.suspend();
            }
        });
        btResume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(readThread == null){
                    return;
                }
                readThread.resume();
            }
        });
    }


}
