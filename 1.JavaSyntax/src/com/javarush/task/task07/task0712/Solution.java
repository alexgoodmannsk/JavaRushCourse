package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String minstr="";
        int minind = 0;
        String maxstr = "";
        int maxind = 0;
        for (int i = 0; i < 10; i++) {
            String str = reader.readLine();
            if(i==0) {
                minstr = str;
                minind = 0;
            }
            if(str.length()>maxstr.length()){
                maxstr = str;
                maxind = i;
            }

            if(str.length()<minstr.length()){
                minstr = str;
                minind = i;
            }
            list.add(str);
        }
        if(maxind<minind) System.out.println(maxstr);
        else System.out.println(minstr);
    }
}
