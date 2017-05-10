package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Set<String> set = new TreeSet<>();
        FileInputStream reader = new FileInputStream(args[0]);
        byte[] buff = new byte[reader.available()];
        reader.read(buff);
        reader.close();
        String str = new String(buff);
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if(Character.isLetter(ch[i])) set.add(String.valueOf(ch[i]).toLowerCase());
        }
        int count = 0;
        for (String x:set) {
            System.out.print(x);
            count++;
            if(count==5) break;
        }

    }
}
