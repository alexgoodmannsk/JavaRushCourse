package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(name));
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        String str;
        while ((str=reader1.readLine())!=null){
            list.add(str);
        }
        Pattern p = Pattern.compile("\\b(([1][0-2])|\\d)\\b");
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            Matcher m = p.matcher(s);
            while (m.find()) {
                int x = Integer.parseInt(m.group(1));
                if (map.containsKey(x)) {
                    s = m.replaceFirst(map.get(x));
                }
                m = p.matcher(s);
            }
            list1.add(s);
        }
        for (String x:list1) {
            System.out.println(x);
        }
        reader1.close();
    }
}
