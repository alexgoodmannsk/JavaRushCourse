package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
        String str;
        int i = 0;
        while ((str=br.readLine())!=null){
            Pattern p = Pattern.compile("\\b(\\w\\w\\w\\w\\w\\w\\w+)\\b");
            Matcher m = p.matcher(str);
            while (m.find()) {
                String a = str.substring(m.start(),m.end());
                bw.write((i==0?"":",")+ a);
                i++;
            }

        }
        br.close();
        bw.close();
    }
}
