package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        try {


            String[] str = string.split(" ");
            String result = "";
            for (int i = 1; i < 4; i++) {
                result += str[i] + " ";
            }
            return result + str[4];
        }catch (Exception e){
            TooShortStringException ex = new TooShortStringException();
            ex.initCause(e);
            throw ex;
        }
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
