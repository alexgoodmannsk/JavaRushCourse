package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream stream = new FileInputStream(name);
        int max =0;
        int value=0;
        while (stream.available()>0){
            int b = stream.read();
            if(map.containsKey(b)){
                value = map.get(b);
                value++;
                if(value>max) max = value;
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
            if(val == max) System.out.print(key+" ");
        }



    }

}
