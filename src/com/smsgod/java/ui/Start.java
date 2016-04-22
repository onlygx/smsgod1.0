package com.smsgod.java.ui;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;

/**
 * Created by GaoXiang on 2016/4/22 0022.
 */
public class Start {

    public static void main(String[] args) {
        System.out.println("项目启动中...");
        try
        {
            //设置本属性将改变窗口边框样式定义
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencyAppleLike;
            //隐藏设置按钮
            UIManager.put("RootPane.setupButtonVisible", false);
            //开启样式
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();

        }catch (Exception e) {
            System.err.println("加载样式失败！");
        }

        try {

            MainFrame mainPage = new MainFrame();

            //设置主要JPanel
            mainPage.setContentPane(new IndexPanel().getJpIndex());
            mainPage.pack();
            mainPage.setSize(500,350);
            mainPage.setLocationRelativeTo(null);
            mainPage.setVisible(true);

            System.out.println("项目启动成功。");
        } catch (Exception e) {
            System.out.println("项目启动失败，错误如下：");
            e.printStackTrace();
        }


    }
}
