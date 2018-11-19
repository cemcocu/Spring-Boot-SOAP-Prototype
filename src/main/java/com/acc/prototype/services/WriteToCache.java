package com.acc.prototype.services;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;

@Service
public class WriteToCache {

  public static HashMap<String,String> map =new HashMap();

    @EventListener(ApplicationReadyEvent.class)
    public void readFile() {
        String fileName = "settings.properties";
        String row;
        String word1,word2;

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()));
        try {
            while ((row = bufferedReader.readLine()) != null) {
                StringBuilder stringBuilder=new StringBuilder();
                String parserow;
                 stringBuilder.append(row);

                parserow=stringBuilder.toString();

                 word1 = parserow.trim().split("=")[0];
                word2 = parserow.trim().split("=")[1];

                map.put(word1,word2);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Datalar settings.properties dosyasindan okundu ve Cache e yazildi\n");

    }

}
