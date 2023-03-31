package com.manish.spring.service;

public class SecondService {
    String prepareMessage(String name){
        if(name == null || name.trim().length() == 0)
            return null;
        try{
           Thread.sleep(50);
        } catch(Exception e){
            e.printStackTrace();
        }
        return "Hello Again "+ name.trim();
    }
}
