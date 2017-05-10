package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        int sum = 0;
        int count = 0;
        while ((s = reader.readLine())!=null){
            if(Integer.parseInt(s)==-1) break;
            sum+=Integer.parseInt(s);
            count++;
        }
        double sa = 1.0*sum/count;
        System.out.println(sa);
    }
}

