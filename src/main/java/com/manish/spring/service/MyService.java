package com.manish.spring.service;

public class MyService {
        int divide(String firstValue, String secondValue){
                int firstData = Integer.parseInt(firstValue);
                int secondData = Integer.parseInt(secondValue);
                return firstData / secondData;
        }
}

/*
Test Scenarios
divide(null, null);
divide(null, "abc");
divide("abc", null);
divide("abc", "4");
divide("4", "abc");
divide("15.0", "4");
divide("15.0", "abc");
divide("abc", "4.0");
divide("15.0", "4.0");
divide("15", "4");

 */
