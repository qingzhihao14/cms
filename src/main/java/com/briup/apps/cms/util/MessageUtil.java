package com.briup.apps.cms.util;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * @Atuhor: qin
 * @Create: 2019-12-20-09-36
 * @Time: 9:36
 * @Description:
 */
public class MessageUtil {
    //使用于查询接口
    public static Message success(Object data){
        return new Message(200,"success",data,(new Date().getTime()));
    }
    //适用于更新接口
    public static Message success(String message){
        return new Message(200,message,null,(new Date().getTime()));
    }
    //适用于更新接口
    public static Message error(String message){
        return new Message(500,message,null,(new Date().getTime()));
    }

    //适用于其他接口
    public static Message message(int status,String message,Object data){
        return new Message(500,message,null,(new Date().getTime()));
    }
}
