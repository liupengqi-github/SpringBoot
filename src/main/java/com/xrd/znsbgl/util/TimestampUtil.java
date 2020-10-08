package com.xrd.znsbgl.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimestampUtil {
    //static静态方法：直接通过类名点方法名调用， 无需实例化
    public static Timestamp getTimestamp(){
        Date date = new Date();//获得系统时间. 
        String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp timestamp = Timestamp.valueOf(nowTime);//把时间转换 

        return timestamp;
    }
}
