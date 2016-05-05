package com.smsgod.java.util;

import com.smsgod.java.app.SmsUrl;
import com.smsgod.java.util.UrlUtil;
import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
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
     * @param smsUrl
     */
    public static void addOne(SmsUrl smsUrl){
        Map<String,SmsUrl> mapdata = findForFile();
        String index = ""+mapdata.size();
        System.out.println("添加到编号：" + index);
        mapdata.put(index,smsUrl);
        saveToFile(mapdata);
    }

    /**
     * 添加对象到文件
     * @param mapData
     */
    private static void saveToFile(Map<String,SmsUrl> mapData){
        String filePath = getPath()+"\\url.dat";
        File file = new File(filePath);
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

        Object temp = null;
        String filePath = getPath()+"\\url.dat";
        File file = new File(filePath);
        if(!file.exists()){
            Map<String,SmsUrl> urlMap = UrlUtil.smsUrls;
            saveToFile(urlMap);
        }
        file = new File(filePath);
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

    public static String getPath(){
        URL url = DbUtils.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = null;
        try {
            filePath = URLDecoder.decode(url.getPath(), "utf-8");// 转化为utf-8编码
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (filePath.endsWith(".jar")) {// 可执行jar包运行的结果里包含".jar"
            // 截取路径中的jar包名
            filePath = filePath.substring(0, filePath.lastIndexOf("/") + 1);
        }

        File file = new File(filePath);

        // /If this abstract pathname is already absolute, then the pathname
        // string is simply returned as if by the getPath method. If this
        // abstract pathname is the empty abstract pathname then the pathname
        // string of the current user directory, which is named by the system
        // property user.dir, is returned.
        filePath = file.getAbsolutePath();//得到windows下的正确路径
        System.out.println(filePath);
        return filePath;
    }
}
