package com.tinyURL.Service;

import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Hashtable;

@Component
public class Codec {
    private static long counter = 100000001;
    private Hashtable<String , String> indexToUrl;
    private Hashtable<String, String> urlToIndex;
    private String base62 = "012345678abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQURSTUVWYZ";

    public Codec(){
        indexToUrl = new Hashtable<String, String>();
        urlToIndex = new Hashtable<String, String>();
    }

    private String encoding(String url){
        if (!urlToIndex.containsKey(url)){
            String endcodedBase62 =  base62Encode(counter) ;
            urlToIndex.put(url, endcodedBase62);
            indexToUrl.put(endcodedBase62, url);
            counter = counter + 1;
        }
        return urlToIndex.get(url);
    }

    private String base62Encode(long counter){
        StringBuilder sb = new StringBuilder();
        long val = counter;
        while(val != 0){
            int mod = (int) (val % 62);
            val = val/62;
            sb.append(base62.charAt(mod));
        }
        // make it as 7 length
        while(sb.length() < 7) {
            sb.append(0);
        }
        return sb.toString();
    }

    public String setsortUrl(String url){
        String tinyURL = encoding(url);
        return tinyURL;
    }

    public String getActualURL(String sorturl){
        if(indexToUrl.containsKey(sorturl)){
            return indexToUrl.get(sorturl);
        }
        return "NOT FOUND";
    }
}
