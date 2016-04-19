package com.smsgod.java.app;

import com.smsgod.java.util.HttpUtil;
import com.smsgod.java.util.UrlUtil;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // 创建HttpClient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建Get方法实例
        String index = "3";
        HttpPost httpPost = new HttpPost(UrlUtil.getUrlsByIndex(index));
        if(UrlUtil.getUrlHeaderByIndex(index) != null){
            httpPost.setHeaders(UrlUtil.getUrlHeaderByIndex(index));
            System.out.println(index+" 号 成功添加header");
        }
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("tel", "18660132803"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response = httpclient.execute(httpPost);
        HttpUtil.printResponse(response,httpPost);

    }
}
