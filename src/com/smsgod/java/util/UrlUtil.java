package com.smsgod.java.util;

import com.smsgod.java.app.SmsUrl;
import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;

import java.io.UnsupportedEncodingException;
import java.util.*;

public class UrlUtil {

    public static Map<String , SmsUrl> smsUrls = new HashMap<String , SmsUrl>(){{
        put("0",new SmsUrl("http://www.ljabc.com.cn/user/sendPhoneCodeAction.html?phone={phone}",
                "post",
                "",
                ""));

        put("1",new SmsUrl("http://www.9ask.cn/index.php?m=content&c=weituo&a=getyzm&t=1",
                "post",
                "",
                "tel={phone}"));

        put("2",new SmsUrl("https://creditcard.ecitic.com/citiccard/cardishop/cardInfo.do?func=generatePhoneCode&dom=%3Crequest%3E%3CcardInfo%20type=%22sendMessage%22%20phone=%22{phone}%22/%3E%3C/request%3E",
                "post",
                "",
                ""));

        put("3",new SmsUrl("http://api.baidao.com/verify/openaccount/sms-verify/send?register=false&callback=jQuery110205721355422865599_1461146598892&usage=%E7%BD%91%E4%B8%8A%E5%BC%80%E6%88%B7&phone={phone}&name=%E6%9C%AA%E7%9F%A5&activityId=1454&utm_term=604310&c=000001&_="+new Date().getTime(),
                "get",
                "Host: api.baidao.com\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36\n" +
                "Referer: http://s.kaihu.98.cn/spa/ttyg/tt-yg-index.html?c=000001",
                ""));

        put("4",new SmsUrl("http://www.ytxzb888.com/apps/suiji_duanxin.php?action=call_yzm",
                "post",
                "Host: www.ytxzb888.com\n" +
                "Accept: application/json, text/javascript, */*; q=0.01\n" +
                "Origin: http://www.ytxzb888.com\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36\n" +
                "Content-Type: application/x-www-form-urlencoded; charset=UTF-8\n" +
                "Referer: http://www.ytxzb888.com/room/minilogin1.php?a=0\n" +
                "Cookie: PHPSESSID=2qlubk4r5efcdci22vhoig95g5; IESESSION=alive; pgv_pvi=7883317248; pgv_si=s9094010880; CNZZDATA1258139326=1745679420-1461143480-%7C1461143480; V=2.0\n",
                "static={phone}"));

        put("5",new SmsUrl("http://api.baidao.com/verify/sms-verify/send?callback=jQuery172016014599311165512_1461147220824&usage=&phone={phone}&name=%E6%9C%AA%E7%9F%A5&activityId=1433&pl=null&utm_term=1308274&sid=1433&reffer=1308274&_="+new Date().getTime(),
                "get",
                "Host: api.baidao.com\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36\n" +
                "Referer: http://www.yintx.cn/PC/360qqresource2/index.html?sid=1433&reffer=1308274",
                ""));

        put("6",new SmsUrl("http://www.oil88888.com/duanxin/demo.php?type=sendmsg",
                "post",
                "Host: www.oil88888.com\n" +
                "Origin: http://www.oil88888.com\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36\n" +
                "Referer: http://www.oil88888.com/index.php?fid=1001\n" +
                "Cookie: PHPSESSID=keha0tb6kshrl8a9m35pep1a43; username=%E6%B8%B8%E5%AE%A2x5DQ; IESESSION=alive; Hm_lvt_670e1fd2b7a6d3940cb31d787ed87219=1461147426; Hm_lpvt_670e1fd2b7a6d3940cb31d787ed87219=1461147426; CNZZDATA1257565992=1606550433-1461142910-%7C1461142910; tencentSig=911753216; pgv_pvi=9153318912; pgv_si=s3477450752; Hm_lvt_f689fe721c88e1aa892e0ff843ae109f=1461147432; Hm_lpvt_f689fe721c88e1aa892e0ff843ae109f=1461147432; Hm_lvt_b58593f2e7a6805231d5960648787ce8=1461147432; Hm_lpvt_b58593f2e7a6805231d5960648787ce8=1461147432\n",
                "telephone={phone}"));

        put("7",new SmsUrl("http://plan.zluan.com/active/GetCode.ashx?jsoncallback=jQuery171005993161164224148_1461147567386&r=0.028394358232617378&Name=123&Moblie={phone}&FromIndex=&p=4&k=242443&_="+new Date().getTime(),
                "get",
                "Host: plan.zluan.com\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36\n" +
                "Referer: http://www.zluan.com.cn/plan/163/index.html?p=4&k=242443",
                ""));

        put("8",new SmsUrl("https://www.puhuijia.com/member/memberRegistryAction!memberPhoneValidateSms.action?members.memberPhone={phone}&verifyType=1&reginstType=1012",
                "get",
                "Host: www.puhuijia.com\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36\n" +
                "Referer: https://www.puhuijia.com/ssldy/bdtg.jsp?utm_source=360&utm_medium=cpc&utm_term=%E5%B1%B1%E4%B8%9C%E6%8A%95%E8%B5%84%E7%90%86%E8%B4%A2&utm_content=%E7%90%86%E8%B4%A2-%E5%9F%8E%E5%B8%82&utm_campaign=%E7%90%86%E8%B4%A2%E8%AF%8D-%E9%87%8D%E7%82%B9\n" +
                "Cookie: JSESSIONID=677824332221E45407850E1DAF418ECF; _ga=GA1.2.1785343619.1461147728; _gat=1; Hm_lvt_5d1e0fb881f6319b25d56372b8fd452c=1461147728; Hm_lpvt_5d1e0fb881f6319b25d56372b8fd452c=1461147728" ,
                ""));


      /*  put("9",new SmsUrl("",
                "post",
                "" ,
                ""));

        put("10",new SmsUrl("",
                "post",
                "" ,
                ""));

        put("11",new SmsUrl("",
                "post",
                "" ,
                ""));*/


    }};


    /**
     * 字符串参数转Header
     * @param headerString
     * @return
     */
    public static Header[] StringToHeaders(String headerString){
        if(headerString == null || "".equals(headerString)){return null;}
        String[] strings = headerString.split("\\n");
        Header[] headerArray = new Header[strings.length];
        for(int i = 0 ; i < strings.length ; i ++){
            String[] header = strings[i].split(": ");
            headerArray[i] = new BasicHeader(header[0],header[1]);
        }
        return headerArray;
    }

    /**
     * 字符串参数转FormEntity
     * @param paramString
     * @return
     * @throws UnsupportedEncodingException
     */
    public static List<NameValuePair> StringToFormList(String paramString) throws UnsupportedEncodingException {
        if(paramString == null || "".equals(paramString)){return null;}
        String[] strings = paramString.split("&");
        List<NameValuePair> nvps = new ArrayList<>();

        for(int i = 0 ; i < strings.length ; i ++){
            String[] param = strings[i].split("=");
            nvps.add(new BasicNameValuePair(param[0], param[1]));
        }
        return nvps;
    }
    public static UrlEncodedFormEntity FormListToEntity(List<NameValuePair> formList) throws UnsupportedEncodingException {
        return new UrlEncodedFormEntity(formList);
    }

}
