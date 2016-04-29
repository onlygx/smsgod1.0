package com.smsgod.java.util;

import com.smsgod.java.app.SmsUrl;
import javax.swing.*;
import java.io.IOException;
import java.util.Map;
import java.util.Random;

public class ReadThread implements Runnable {
    public Thread t;
    private String threadName;
    boolean suspended = false;
    boolean stop = false;
    JProgressBar jindu;
    int time ;
    String phone ;
    float totalCount;       //总共要进行的次数
    float oldCount = 0;     //已经进行的次数

    public ReadThread() {

    }

    public ReadThread(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    public ReadThread(String threadName, int time,int totalCount,String phone ,JProgressBar jindu) {
        this.threadName = threadName;
        this.jindu = jindu;
        this.time = time;
        this.phone = phone;
        this.totalCount = totalCount;
        System.out.println("Creating " + threadName);
    }

    public void run() {

        Map<String,SmsUrl> smsUrlMap = DbUtils.findForFile();
        Random random = new Random();
        for (int i = 0; i < totalCount; i++) {
            if(stop){
                break;
            }
            oldCount++;
            if(smsUrlMap.size() == 0){
                smsUrlMap = DbUtils.findForFile();
            }
            String[] keys = smsUrlMap.keySet().toArray(new String[0]);
            int total = keys.length;
            int randomInt = random.nextInt(total);
            String key = keys[randomInt];
            //开始发送
            try {
                SmsUrl smsUrl = smsUrlMap.get(key);
                String method = smsUrl.getMethod();
                if("post".equals(method)){
                    HttpUtil.post(smsUrl,phone);
                }else{
                    HttpUtil.get(smsUrl,phone);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            smsUrlMap.remove(key);
            Float progress = (oldCount/totalCount)*100;
            jindu.setValue(progress.intValue());

            // Let the thread sleep for a while.
            try {
                Thread.sleep(time);
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Thread " + threadName + " interrupted.");
                e.printStackTrace();
            }
        }

    }

    /**
     * 开始
     */
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    /**
     * 暂停
     */
    public void suspend() {
        suspended = true;

    }

    /**
     * 停止
     */
    public void stop() {
        stop = true;

    }

    /**
     * 继续
     */
    public synchronized void resume() {
        suspended = false;
        notify();
    }
}