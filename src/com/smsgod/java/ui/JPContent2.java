package com.smsgod.java.ui;

import com.smsgod.java.app.SmsUrl;
import com.smsgod.java.util.DbUtils;
import com.smsgod.java.util.HttpUtil;
import com.smsgod.java.util.UrlUtil;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

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
    private JTextField resoult;
    private JLabel lbresoult;
    private JLabel lbparam;
    private JTextField phone;
    private JLabel lbshow;
    private JPanel lbp;

    SmsUrl smsUrl = new SmsUrl();

    public JPContent2() {
        ButtonGroup buttonGroup = new ButtonGroup();
        rPost.setSelected(true);
        buttonGroup.add(rPost);
        buttonGroup.add(rGet);

        try {
            test.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.green));
            add.setUI(new BEButtonUI().setNormalColor(BEButtonUI.NormalColor.red));
        } catch (Exception e) {
            System.out.println("设置按钮ui失败！");
            e.printStackTrace();
        }
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("".equals(url.getText()) || "".equals(phone.getText())) {
                    System.out.println("地址和手机号不能为空！");
                    return;
                }
                if (rPost.isSelected()) {
                    smsUrl.setMethod("post");
                    System.out.println("提交方式：POST");
                } else {
                    smsUrl.setMethod("get");
                    System.out.println("提交方式：GET");
                }
                System.out.println("url:" + url.getText() + ";");
                System.out.println("header:" + header.getText() + ";");
                System.out.println("param:" + paramBody.getText() + ";");

                smsUrl.setUrl(url.getText());
                smsUrl.setHeaders(UrlUtil.StringToHeaders(header.getText()));
                try {
                    smsUrl.setParams(UrlUtil.StringToFormList(paramBody.getText()));
                } catch (UnsupportedEncodingException e1) {
                    System.out.println("参数转换失败！");
                    e1.printStackTrace();
                }

                String method = smsUrl.getMethod();
                String response = "";
                try {
                    if ("post".equals(method)) {
                        response = HttpUtil.post(smsUrl, phone.getText());
                    } else {
                        response = HttpUtil.get( smsUrl, phone.getText());
                    }
                    resoult.setText(response);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("".equals(url.getText()) || "".equals(phone.getText())) {
                    System.out.println("地址和手机号不能为空！");
                    return;
                }
                DbUtils.addOne(smsUrl);
                url.setText("");
                header.setText("");
                paramBody.setText("");
                resoult.setText("");

                Map<String, SmsUrl> map = DbUtils.findForFile();

                int index = map.size()-1;
                System.out.println("获取序号：" + index);
                System.out.println(map.get(index+""));
            }
        });
    }
}
