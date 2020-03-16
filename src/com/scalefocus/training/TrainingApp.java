package com.scalefocus.training;

import com.scalefocus.training.linkedhashmap.MyLinkedHashMap;

public class TrainingApp {

    public static void main(String[] args) {

        MyLinkedHashMap<String, String> myMap = new MyLinkedHashMap<String, String>();
        myMap.put("Ivan", "1111111111111");
        myMap.put("Dimitar", "22222222222");
        myMap.put("Peter", "33333333333");
        myMap.put("Kostadin", "44444444444");
        myMap.put("Stoyan", "5555555555555");
        myMap.put("Ivaylo", "666666666666");
        myMap.put("Pavel", "7777777777777777");
        myMap.put("Bozidhar", "8888888888888");
        myMap.put("Anthony", "999999999999999");
        myMap.put("Georgi", "10");
        myMap.print();

        System.out.println("Test");
    }
}
