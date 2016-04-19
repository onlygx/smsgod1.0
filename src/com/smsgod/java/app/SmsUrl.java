package com.smsgod.java.app;


import org.apache.http.Header;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import java.io.Serializable;

public class SmsUrl implements Serializable {

    private String title;
    private String url;
    private Header[] headers;
    private UrlEncodedFormEntity params;

    public SmsUrl(String url,Header[] headers,UrlEncodedFormEntity params){
        this.url = url;
        this.headers = headers;
        this.params = params;
    }

    public SmsUrl(String url,String headers,String params){
        this.url = url;



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

    public UrlEncodedFormEntity getParams() {
        return params;
    }

    public void setParams(UrlEncodedFormEntity params) {
        this.params = params;
    }
}
