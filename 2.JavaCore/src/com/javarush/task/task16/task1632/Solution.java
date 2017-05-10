package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new nit1());
        threads.add(new nit2());
        threads.add(new nit3());
        threads.add(new nit4());
        threads.add(new nit5());
    }

    public static void main(String[] args) {
 //       threads.get(4).start();
    }

    public static class nit1 extends Thread{
        public void run() {
            while (true){

            }
        }
    }

    public static class nit2 extends Thread{
        public void run() {
            try {
                while (true){
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }

        }
    }

    public static class nit3 extends Thread{
        public void run() {
            try {
                while (!isInterrupted()){
                    System.out.println("Ура");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {

            }

        }

    }

    public static class nit4 extends Thread implements Message{
        @Override
        public void showWarning()
        {
            if(this.isAlive()) this.interrupt();
        }
        public void run() {
            try {
                while (!isInterrupted()){
                    Thread.sleep(20);
                }
            } catch (InterruptedException e) {

            }

        }

    }

    public static class nit5 extends Thread{
        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (!isInterrupted()) {
                int sum = 0;
                try {
                    while (true) {
                        int n;
                        String num = reader.readLine();
                        if (num.equals("N")) break;
                        else {
                            n = Integer.parseInt(num);
                            sum += n;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка буфера");
                    return;
                } catch (NumberFormatException e) {
                    System.out.println("Введено недопустимое значение");
                    return;
                }
                System.out.println(sum);
            }
        }
    }
}