package com.smsgod.java.util;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.HashMap;
import java.util.Map;

public class UrlUtil {

    static Map<String , String> urls = new HashMap<String , String>(){{
        put("1", "https://creditcard.ecitic.com/citiccard/cardishop/cardInfo.do?func=generatePhoneCode&dom=%3Crequest%3E%3CcardInfo%20type=%22sendMessage%22%20phone=%22{phone}%22/%3E%3C/request%3E");
        put("2", "http://www.ljabc.com.cn/user/sendPhoneCodeAction.html?phone={phone}");
        put("3", "http://www.9ask.cn/index.php?m=content&c=weituo&a=getyzm&t=1");
        put("address", "url");
    }};

    static Map<String , Header[]> urlsHead = new HashMap<String , Header[]>(){{
        put("3",new Header[]{

        });

        put("address", new Header[]{});
    }};



    public static String getUrlsByIndex(String index){
        return urls.get(index).toString();
    }

    public static Header[] getUrlHeaderByIndex(String index){
        return urlsHead.get(index);
    }
}
