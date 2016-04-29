package test;

import com.smsgod.java.app.SmsUrl;
import com.smsgod.java.util.DbUtils;
import com.sun.jna.IntegerType;

import java.util.Map;
import java.util.Random;

/**
 * Created by GaoXiang on 2016/4/29 0029.
 */
public class javaTest {
    public static void main(String[] args) {
        int totalint = 10;
        int oldint = 0 ;
        float total = totalint;
        float oldCount=oldint;
        for(int i = 0;i<total;i++){
            oldCount++;
            Float progress = oldCount/total*100;

            System.out.println("---------------");
            System.out.println(oldCount);
            System.out.println(total);
            System.out.println(progress.intValue());

            System.out.println("---------------");
        }

/*        Map<String,SmsUrl> smsUrlMap = DbUtils.findForFile();
        Random random = new Random();
        for(int i = 0 ; i < 10 ; i ++){
            if(smsUrlMap.size() == 0){
                smsUrlMap = DbUtils.findForFile();
            }
            String[] keys = smsUrlMap.keySet().toArray(new String[0]);
            int total = keys.length;
            int randomInt = random.nextInt(total);
            smsUrlMap.remove(keys[randomInt]);

            System.out.println(total+" ======== "+randomInt);

        }*/

    }
}
