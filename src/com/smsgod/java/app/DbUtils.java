package com.smsgod.java.app;

import com.smsgod.java.util.UrlUtil;
import java.io.*;
import java.util.Map;

/**
 * Created by GaoXiang on 2016/4/19 0019.
 */
public class DbUtils {

    public static void main(String[] args) {
        // 初始化程序 - 加载url列表
        init();

        Map<String,SmsUrl> mapdata = findForFile();
        System.out.printf("初始成功，获取到："+mapdata.size()+" 条。");
    }

    /**
     * 初始化所有数据
     */
    private static void init(){
        Map<String,SmsUrl> urlMap = UrlUtil.smsUrls;
        saveToFile(urlMap);
    }

    /**
     * 添加一条数据
     * @param index
     * @param smsUrl
     */
    public static void addOne(String index,SmsUrl smsUrl){
        Map<String,SmsUrl> mapdata = findForFile();
        mapdata.put(index,smsUrl);
        saveToFile(mapdata);
    }

    /**
     * 添加对象到文件
     * @param mapData
     */
    private static void saveToFile(Map<String,SmsUrl> mapData){

        File file =new File("url.dat");
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            ObjectOutputStream objOut=new ObjectOutputStream(out);
            objOut.writeObject(mapData);
            objOut.flush();
            objOut.close();
            System.out.println("write object success!");
        } catch (IOException e) {
            System.out.println("write object failed");
            e.printStackTrace();
        }
    }

    /**
     * 从文件解析对象
     * @return
     */
    public static Map<String,SmsUrl> findForFile(){

        Object temp=null;
        File file =new File("url.dat");
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            ObjectInputStream objIn=new ObjectInputStream(in);
            temp=objIn.readObject();
            objIn.close();
            System.out.println("read object success!");
        } catch (IOException e) {
            System.out.println("read object failed");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (Map<String,SmsUrl>)temp;
    }
}
