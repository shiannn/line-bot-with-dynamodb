package com.my.line_bot_dynamo.ParseUtil;

import java.net.URL;
import java.net.URLConnection;

public class urlValid{
    public static boolean isValidURL(String name){
        try{
            new URL(name).toURI(); 
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    public static void main(String[] args){
        boolean ret = isValidURL("https://www.ntu.edu.tw/");
        System.out.println(ret);
    }
}