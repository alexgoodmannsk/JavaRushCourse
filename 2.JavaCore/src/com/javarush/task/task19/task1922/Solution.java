package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader(new FileReader(name));
        String str;
        while ((str=reader1.readLine())!=null){
            int count =0;
            String[] s = str.split(" ");
            for (int i=0; i<s.length; i++){
                if(words.contains(s[i])){
                    count++;
                }
            }
            if(count==2) System.out.println(str);
        }
        reader1.close();
    }
}
