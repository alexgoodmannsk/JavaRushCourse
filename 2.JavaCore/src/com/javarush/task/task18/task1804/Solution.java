package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream stream = new FileInputStream(name);
        int min =0;
        int value=0;
        while (stream.available()>0){
            int b = stream.read();
            if(map.containsKey(b)){
                value = map.get(b);
                value++;
                if(value>min) min = value;
                map.remove(b);
                map.put(b,value);
            }
            else {
                map.put(b,1);
            }
        }
        stream.close();
        for (Map.Entry<Integer,Integer> pair : map.entrySet()) {
            Integer key = pair.getKey();
            Integer val = pair.getValue();
            if (val<=min) {
                if (val < min) {
                    list.removeAll(list);
                    list.add(key);
                }
                if (val == min) {
                    list.add(key);
                }
                min = val;
            }
        }
        for (int x:list) {
            System.out.print(x+" ");
        }



    }
}
