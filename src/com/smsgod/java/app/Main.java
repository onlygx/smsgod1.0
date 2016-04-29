package com.smsgod.java.app;

import com.smsgod.java.util.HttpUtil;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static Map<String,SmsUrl> smsUrlMap = HttpUtil.smsUrlMap;
    public static String phone = "18660132803";

    public static void main(String[] args) throws IOException {

        // 初始化 测试数据
        String i = "8";
        SmsUrl smsUrl = smsUrlMap.get(i);
        String url = smsUrl.getUrl();
        if("".equals(url)){
            System.out.println("预设值为空！");
            return;
        }
        String method = smsUrl.getMethod();
        if("post".equals(method)){
            HttpUtil.post(smsUrl,phone);
        }else{
            HttpUtil.get(smsUrl,phone);
        }
    }
}
