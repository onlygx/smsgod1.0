package com.smsgod.java.util;

import com.smsgod.java.app.SmsUrl;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

public class HttpUtil {

    public static Map<String,SmsUrl> smsUrlMap = DbUtils.findForFile();

    public static void BeginSms(String phone) throws IOException {
        // 创建HttpClient实例
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建Get方法实例
        for(int i = 1 ;i <= smsUrlMap.size() ; i++){

            try {
                SmsUrl smsUrl = smsUrlMap.get(i+"");
                String url = smsUrl.getUrl();
                if("".equals(url)){
                    System.out.println("预设值为空！");
                    return;
                }
                String method = smsUrl.getMethod();
                if("post".equals(method)){
                    post(httpclient,smsUrl,phone);
                }else{
                    get(httpclient,smsUrl,phone);
                }

            } catch (Exception e) {
                //e.printStackTrace();
                System.out.println(i+" 号 出现错误");
            }
        }
    }


    public static void post(CloseableHttpClient httpclient,SmsUrl smsUrl,String phone) throws IOException {

        String url = smsUrl.getUrl().replace("{phone}",phone);
        String method = smsUrl.getMethod();
        Header[] headers = smsUrl.getHeaders();
        UrlEncodedFormEntity params = smsUrl.getFromEntity(phone);

        HttpPost httpPost = new HttpPost(url);

        // 判断并添加 Header
        if(headers != null && headers.length > 0){
            httpPost.setHeaders(headers);
            System.out.println("成功添加 Header");
        }

        // 判断并添加 FormEntity
        if(params != null){
            httpPost.setEntity(params);
            System.out.println("成功添加 Entity");
        }

        // 判断并选择提交方式  post 和 get
        System.out.println("提交方式：" + method);

        //提交开始
        CloseableHttpResponse response = httpclient.execute(httpPost);
        HttpUtil.printResponse(response);
        httpPost.abort();
    }

    public static void get(CloseableHttpClient httpclient,SmsUrl smsUrl,String phone) throws IOException {

        String url = smsUrl.getUrl().replace("{phone}",phone);
        String method = smsUrl.getMethod();
        Header[] headers = smsUrl.getHeaders();
        UrlEncodedFormEntity params = smsUrl.getFromEntity(phone);

        HttpGet httpGet = new HttpGet(url);

        // 判断并添加 Header
        if(headers.length > 0){
            httpGet.setHeaders(headers);
            System.out.println("成功添加 Header");
        }

        // 判断并选择提交方式  post 和 get
        System.out.println("提交方式：" + method);

        //提交开始
        CloseableHttpResponse response = httpclient.execute(httpGet);
        HttpUtil.printResponse(response);
        httpGet.abort();
    }

    /**
     * 打印结果
     * @param response
     * @throws IOException
     */
    public static void printResponse(CloseableHttpResponse response) throws IOException {
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            InputStream instreams = entity.getContent();
            String str = HttpUtil.convertStreamToString(instreams);
            System.out.println("============= begin =============");
            System.out.println(str);
            System.out.println("============= end =============");

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

}
