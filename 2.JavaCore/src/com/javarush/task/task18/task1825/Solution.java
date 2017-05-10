package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        SortedMap<Integer, FileInputStream> map = new TreeMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        int number=0;
        String absPath="";

        while (!(name = reader.readLine()).equals("end")){
            String[] str = name.split("\\.part");
            absPath = str[0];
            number = Integer.parseInt(str[1]);
            map.put(number, new FileInputStream(name));
        }
        reader.close();
        File file = new File(absPath);
        FileOutputStream out = new FileOutputStream(absPath,true);
        for (SortedMap.Entry<Integer, FileInputStream> x:map.entrySet()) {
            byte[] buff = new byte[x.getValue().available()];
            x.getValue().read(buff);
            out.write(buff);
            x.getValue().close();
        }
        out.close();
    }
}
