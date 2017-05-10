package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        SortedMap<Integer,Integer> map = new TreeMap<>();
        FileInputStream file = new FileInputStream(args[0]);
        while (file.available()>0){
            int b = file.read();
            if (map.containsKey(b)){
                int value = map.get(b);
                value++;
                map.remove(b);
                map.put(b,value);
            }else {
                map.put(b,1);
            }
        }
        file.close();
        for (SortedMap.Entry<Integer,Integer> x: map.entrySet()) {
            Integer key = x.getKey();
            Integer value = x.getValue();
            byte ch = (byte)((int)(key));
            System.out.println((char)ch + " " + value);
        }
    }
}
