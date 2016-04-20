package com.smsgod.java.app;

import com.smsgod.java.util.HttpUtil;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static Map<String,SmsUrl> smsUrlMap = DbUtils.findForFile();
    public static String phone = "1836";


    public static void main(String[] args) throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 初始化 测试数据
        String i = "7";
        SmsUrl smsUrl = smsUrlMap.get(i);
        String url = smsUrl.getUrl();
        if("".equals(url)){
            System.out.println("预设值为空！");
            return;
        }
        String method = smsUrl.getMethod();
        if("post".equals(method)){
            HttpUtil.post(httpclient,smsUrl,phone);
        }else{
            HttpUtil.get(httpclient,smsUrl,phone);
        }
    }
}
