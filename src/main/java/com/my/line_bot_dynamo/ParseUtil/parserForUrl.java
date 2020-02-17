package com.my.line_bot_dynamo.ParseUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.my.line_bot_dynamo.models.Meta;
import com.my.line_bot_dynamo.models.ParseInfo;
import com.my.line_bot_dynamo.repositories.ParseInfoRepository;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class parserForUrl{
    public static ParseInfo parseUrlRaw(String name){
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
            //System.out.println(html);

            //ParseInfo parseInfo =  new ParseInfo(message, "sample content");
            ParseInfo parseInfo =  new ParseInfo(name, html, "", "");
            //ParseInfoRepository.save(parseInfo);
            return parseInfo;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    public static Meta parseUrlTag(String UrlName){
        //Document doc = Jsoup.parse(UrlName);
        try{
            Document doc = Jsoup.connect(UrlName).get();
            Elements metaTags = doc.getElementsByTag("meta");
    
            //String meta = "";
            Meta meta = new Meta("", "");
            for (Element metaTag : metaTags) {
                String content = metaTag.attr("content");
                String name = metaTag.attr("name");
                //meta += (name + content) + "\n";
                meta.setName(meta.getName() + name + "\n");
                meta.setContent(meta.getContent() + content + "\n");
                //System.out.println("content"+content);
                //System.out.println("name"+name);
                //System.out.println(metaTag);
            }
            return meta;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}