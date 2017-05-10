package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        BigInteger fact = BigInteger.ONE;
        if(n==0) {return "1";}
        else if(n<0&&n>150) {return "Не коррекное значение";}
        else if(n<0){return "0";}
        else {
            for (int i = 1; i <= n; i++) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
            return fact.toString();
        }
    }
}
