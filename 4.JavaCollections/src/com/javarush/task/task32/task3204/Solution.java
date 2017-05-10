package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        StringReader pass = new StringReader(passGen());
        int b;
        while ((b=pass.read())!=-1){
            baos.write(b);
        }
        return baos;
    }

    public static int genDigit(){
        double x = Math.random();
        return (int)(48+10*x);
    }
    public static int genUpChar(){
        double x = Math.random();
        return (int)(65+26*x);
    }
    public static int genLowerChar(){
        double x = Math.random();
        return (int)(97+26*x);
    }
    public static String passGen(){
        boolean isFin=false;
        StringBuilder pass = new StringBuilder();
        String pwd="";
        while (!isFin){
            double x = Math.random();
            int ch = (int) (x * 3);
            char t;
            switch (ch) {
                case 0: {
                    pass.append((char) genDigit());
                    break;
                }
                case 1: {
                    pass.append((char) genUpChar());
                    break;
                }
                case 2: {
                    pass.append((char) genLowerChar());
                    break;
                }
            }
            if(pass.length()>7){
                pwd = new String(pass).substring(pass.length()-8);
                isFin=isValid(pwd);
            }
        }
        return pwd;
    }
    public static boolean isValid(String str){
        if (str.length()!=8) return false;
        char[] ch = str.toCharArray();
        boolean isUp=false;
        boolean islw=false;
        boolean isDig=false;
        for (char x:ch) {
            if(Character.isDigit(x)) isDig=true;
            if(Character.isLetter(x)) {
                if (Character.isLowerCase(x)) islw = true;
                if (Character.isUpperCase(x)) isUp = true;
            }
            if(isDig&&islw&&isUp) break;
        }
        return isDig&&islw&&isUp;
    }
}