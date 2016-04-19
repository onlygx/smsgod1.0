package com.smsgod.java.app;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GaoXiang on 2016/4/19 0019.
 */
public class DbUtils {

    public static void main(String[] args) {
        Map<String,SmsUrl> mapTest = new HashMap<>();
        SmsUrl su = new SmsUrl();
        su.setTitle("第一个");
        mapTest.put("1",su);

        save(mapTest);


        Map<String,SmsUrl> mapdata = getAll();
        System.out.printf(mapdata.get("1").getTitle());
    }


    private static void addOne(String index,SmsUrl smsUrl){
        Map<String,SmsUrl> mapdata = getAll();
        mapdata.put(index,smsUrl);
        save(mapdata);
    }


    private static void save(Map<String,SmsUrl> mapData){

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

    private static Map<String,SmsUrl> getAll(){

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
