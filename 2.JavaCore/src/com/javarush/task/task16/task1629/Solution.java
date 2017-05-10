package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t1.printResult();
        t2.printResult();
    }

    public static class Read3Strings extends Thread{
        private List<String> result = new ArrayList<String>(3);
        public void run() {
            try {
                for (int i = 0; i < 3; i++) {
                    result.add(reader.readLine());
                }

            }catch (IOException e){
                System.out.println("Ошибка ввода");
            }
        }
        public void printResult(){
            System.out.println(result.get(0) + " " + result.get(1) + " " + result.get(2));
        }
    }
}
