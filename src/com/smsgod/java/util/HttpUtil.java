package com.smsgod.java.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpUtil {


    public static void BeginSms(String phone) throws IOException {
        // 创建HttpClient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建Get方法实例
        for(int i = 1 ;i<=10 ; i++){

            try {
                HttpPost httpPost = new HttpPost(UrlUtil.getUrlsByIndex(""+i).replace("{phone}",phone));
                if(UrlUtil.getUrlHeaderByIndex(""+i) != null){
                    httpPost.setHeaders(UrlUtil.getUrlHeaderByIndex(""+i));
                    System.out.println(i+" 号 成功添加header");
                }
                CloseableHttpResponse response = httpclient.execute(httpPost);
                HttpUtil.printResponse(response,httpPost);
            } catch (Exception e) {
                System.out.println(i+" 号 出现错误");
            }
        }
    }


    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 打印结果并释放连接
     * @param response
     * @param httpPost
     * @throws IOException
     */
    public static void printResponse(CloseableHttpResponse response, HttpPost httpPost) throws IOException {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instreams = entity.getContent();
            String str = HttpUtil.convertStreamToString(instreams);
            System.out.println("============= begin =============");
            System.out.println(str);
            System.out.println("============= end =============");
            httpPost.abort();
        }
    }

}
