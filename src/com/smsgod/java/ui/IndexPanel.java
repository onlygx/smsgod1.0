package com.smsgod.java.ui;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by GaoXiang on 2016/4/22 0022.
 */
public class IndexPanel extends JComponent{

    private JPanel jpIndex;
    private JPanel jpRoolBar;
    private JToolBar toolbar;
    private JButton bt1;
    private JButton bt2;
    private JButton bt3;
    private JPanel jpContent;
    private JLabel lbtempshow;

    private JPContent1 jpContent1;


    public IndexPanel() {
        //super();
        System.out.println("JPanel 构造...");
        System.out.println(jpContent1.getVisibleRect());
        jpContent1.setEnabled(false);

        bt1.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        bt2.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));
        bt3.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.lightBlue));

        // 首页按钮
        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("首页测试开始...~~");
                try {

                    lbtempshow.setText("首页测试~");
                    jpContent.setVisible(false);
                    jpContent1.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                    System.out.println("首页测试失败！！");
                }
                System.out.println("首页测试完成。");
            }
        });

        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    System.out.println("添加测试开始...");

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                System.out.println("添加测试结束。");
            }
        });
    }

    public JPanel getJpIndex() {
        return jpIndex;
    }

    public void setJpIndex(JPanel jpIndex) {
        this.jpIndex = jpIndex;
    }
}
