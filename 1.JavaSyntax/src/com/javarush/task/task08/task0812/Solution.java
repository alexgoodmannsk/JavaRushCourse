package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>(10);
        int n = 1,max = 0;

        list.add(Integer.parseInt(reader.readLine()));
        for(int i = 1;i<10;i++){
            list.add(Integer.parseInt(reader.readLine()));
            if(list.get(i).equals(list.get(i-1))) n++;
            else n = 1;
            if (n>max) max = n;
        }
        System.out.println(max);

    }
}