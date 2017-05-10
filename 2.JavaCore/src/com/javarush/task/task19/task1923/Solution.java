package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
        String str;
        String fin=" ";
        while ((str = in.readLine())!=null){
            fin+=" " + str;
        }
        Pattern p = Pattern.compile("\\b[\\w\\p{Punct}]*[0-9]+[\\p{Punct}\\w]*\\b");
        Matcher m = p.matcher(fin);
        while (m.find()){
            out.write(fin.substring(m.start(),m.end())+" ");
        }
        in.close();
        out.close();
    }
}
