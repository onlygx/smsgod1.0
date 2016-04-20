package test;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/**
 * Created by GaoXiang on 2016/4/20 0020.
 */
public class TestMain {

    public static void main(String[] args) {
        String test = "Host: api.baidao.com\n" +
                "Connection: keep-alive\n" +
                "Accept: */*\n" +
                "User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36\n" +
                "Referer: http://kaihu.98.cn/tt\n";

        String[] strings = test.split("\\n");
        Header[] headers = new Header[strings.length];
        for(int i = 0 ; i < strings.length ; i ++){
            String[] header = strings[i].split(":");
            headers[i] = new BasicHeader(header[0],header[1].trim());
        }

        System.out.println(headers[2].getValue());
    }
}
