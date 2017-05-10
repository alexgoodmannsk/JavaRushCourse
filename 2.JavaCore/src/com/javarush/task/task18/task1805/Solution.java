package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();
        String name = reader.readLine();
        FileInputStream stream = new FileInputStream(name);
        while (stream.available()>0){
            int b = stream.read();
            if(!list.contains(b)) list.add(b);
        }
        reader.close();
        stream.close();
        Collections.sort(list);
        list.forEach(value -> System.out.print(value + " "));
    }

}
