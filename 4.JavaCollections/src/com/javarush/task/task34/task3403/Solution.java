package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
*/
public class Solution {

    public void recursion(int n) {
        for (int i = 2; i < n+1 ; i++) {
            if(n%i==0){
                System.out.println(i+ " ");
                recursion(n/i);
                return;
            }
        }
    }
}
