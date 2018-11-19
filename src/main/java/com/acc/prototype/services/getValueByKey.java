package com.acc.prototype.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.HashMap;


@Component(value = "getValueByKey")
@WebService
public class getValueByKey {

    @Autowired
    private WriteToCache service;

    public String getValueByKey(String asdll) throws Exception {

            HashMap<String, String> map = service.map;

             String response = map.get(asdll);

      return response;


    }
}
