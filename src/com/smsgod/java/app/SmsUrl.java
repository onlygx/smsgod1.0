package com.smsgod.java.app;


import com.smsgod.java.util.UrlUtil;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class SmsUrl implements Serializable {

    private String title;
    private String method;
    private String url;
    private Header[] headers;
    private List<NameValuePair> params;

    public SmsUrl(){}

    public SmsUrl(String url,String method,Header[] headers,List<NameValuePair> params){
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.params = params;
    }

    public SmsUrl(String url,String method,String headers,String params){
        this.url = url;
        this.method = method;
        this.headers = UrlUtil.StringToHeaders(headers);
        try {
            this.params = UrlUtil.StringToFormList(params);
        } catch (UnsupportedEncodingException e) {
            System.out.println("参数转换失败！");
            e.printStackTrace();
        }
    }

    public UrlEncodedFormEntity getFromEntity(String phone){
        UrlEncodedFormEntity urlEncodedFormEntity = null;
        try {
            if(params == null){
                return null;
            }
            for(NameValuePair nvp : params){
                String value = nvp.getValue();
                BasicNameValuePair bnv = null;
                if(value.contains("{phone}")){
                    bnv = new BasicNameValuePair(nvp.getName(),value.replace("{phone}",phone));
                    params.remove(nvp);
                    params.add(bnv);
                    break;
                }
                System.out.println("成功替换参数{phone}："+bnv.getValue());
            }
            urlEncodedFormEntity = new UrlEncodedFormEntity(this.params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlEncodedFormEntity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Header[] getHeaders() {
        return headers;
    }

    public void setHeaders(Header[] headers) {
        this.headers = headers;
    }

    public List<NameValuePair> getParams() {
        return params;
    }

    public void setParams(List<NameValuePair> params) {
        this.params = params;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
