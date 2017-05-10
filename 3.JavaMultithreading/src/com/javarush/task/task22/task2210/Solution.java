package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer strt = new StringTokenizer(query, delimiter);
        String[] strings = new String[strt.countTokens()];
        int i = 0;
        while (strt.hasMoreTokens()){
            strings[i] = strt.nextToken();
            i++;
        }
        return strings;
    }
}
