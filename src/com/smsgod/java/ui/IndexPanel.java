package com.smsgod.java.ui;

import com.smsgod.java.app.SmsUrl;
import com.smsgod.java.util.DbUtils;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 *
 */
public class IndexPanel extends JComponent{

    private JPanel jpIndex;
    private JPanel jpRoolBar;
    private JToolBar toolbar;
    private JButton bt1;
    private JButton bt2;
    private JPContent1 jpContent1;
    private JPContent2 jpContent2;
    private JPanel jp1;
    private JPanel jp2;
    private JButton btTest;


    public IndexPanel() {
        //super();
        System.out.println("JPanel 构造...");

        jp1.setVisible(true);
        jp2.setVisible(false);
        bt1.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        bt2.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));

        // 首页按钮
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    show1();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    show2();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        btTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Map<String,SmsUrl> mapdata = DbUtils.findForFile();
                    System.out.println("当前总数："+mapdata.size());
                    System.out.println("所有URL如下：");
                    for(SmsUrl smsUrl : mapdata.values()){
                        System.out.println(smsUrl.getUrl());
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void hideAll(){
        jp1.setVisible(false);
        jp2.setVisible(false);
    }
    private void show1(){
        hideAll();
        jp1.setVisible(true);
    }
    private void show2(){
        hideAll();
        jp2.setVisible(true);
    }


    public JPanel getJpIndex() {
        return jpIndex;
    }

    public void setJpIndex(JPanel jpIndex) {
        this.jpIndex = jpIndex;
    }
}
