package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
static{
    labels.put(1d,"123");
    labels.put(2d,"234");
    labels.put(3d,"434");
    labels.put(4d,"534");
    labels.put(5d,"634");
}
    public static void main(String[] args) {
        System.out.println(labels);
    }
}
