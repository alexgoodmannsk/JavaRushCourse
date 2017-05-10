package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        SortedMap<String,Double> map = new TreeMap<>();
        String str = "";
        while ((str=reader.readLine())!=null){
            String name = str.split(" ")[0];
            double zp = Double.parseDouble(str.split(" ")[1]);
            if(map.containsKey(name)){
                zp+=map.get(name);
                map.remove(name);
                map.put(name,zp);
            }
            else {
                map.put(name,zp);
            }
        }
        reader.close();
        for (SortedMap.Entry<String,Double> x:map.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }
}
