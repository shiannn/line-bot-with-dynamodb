package com.my.line_bot_dynamo.ParseUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.my.line_bot_dynamo.models.ParseInfo;
import com.my.line_bot_dynamo.repositories.ParseInfoRepository;

public class parserForUrl{
    public static ParseInfo parseUrl(String name){
        try{
            URL url = new URL(name);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent", "BBot/1.0");
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.connect();

            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            String html = "";
            while((line = reader.readLine())!=null){
                html += line + "\n";
            }
            html.trim();
            System.out.println(html);

            //ParseInfo parseInfo =  new ParseInfo(message, "sample content");
            ParseInfo parseInfo =  new ParseInfo(name, html);
            //ParseInfoRepository.save(parseInfo);
            return parseInfo;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}