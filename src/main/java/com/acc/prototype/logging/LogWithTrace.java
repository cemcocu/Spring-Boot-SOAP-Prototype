package com.acc.prototype.logging;

import org.springframework.boot.actuate.trace.Trace;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;


@Component
public class LogWithTrace implements TraceRepository {

    @Override
    public List<Trace> findAll() {
        return null;
    }

    @Override
    public void add(Map<String, Object> map) {

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        Date sysdate=new Date();
        try {
            sysdate=new SimpleDateFormat("yyyyMMdd_HHmmss").parse(timeStamp);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Map<String, Object> headersList= (Map<String, Object>) map.get("headers");

        Map<String, Object> request= (Map<String, Object>) headersList.get("request");


        String log =sysdate.toString()+"  "+request.get("host")+map.get("path")+" "+"cagrildi";

        String filename = "prototype.log";
        try
        {

            FileWriter fileWriter = new FileWriter(filename,true); //the true will append the new data
            fileWriter.write(log+"\n");//appends the string to the file
            fileWriter.close();
        }
        catch(IOException e)
        {
            System.err.println("IOException: " + e.getMessage());
        }



    }


}