package com.acc.prototype.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;


@Component(value = "getAll")
@WebService
public class getAll {

    @Autowired
    private WriteToCache service;

    @WebMethod
    public List<String> getAllValue() {

        List<String> resultList=new ArrayList<>();

         service.map.entrySet().forEach(index->resultList.add(index.getValue()));

        return resultList;

    }

}
