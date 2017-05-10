package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        String name;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (!(name=reader.readLine()).equals("exit")){
            new ReadThread(name).start();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) throws IOException {
            this.fileName = fileName;
        }
        @Override
        public void run() {
            Map<Integer, Integer> map = new HashMap<>();
            int max = 0;
            int value = 0;
            try {
                FileInputStream stream = new FileInputStream(fileName);
                while (stream.available() > 0) {
                    int b = stream.read();
                    if (map.containsKey(b)) {
                        value = map.get(b);
                        value++;
                        if (value > max) max = value;
                        map.remove(b);
                        map.put(b, value);
                    } else {
                        map.put(b, 1);
                    }
                }
                stream.close();
                for (Map.Entry<Integer,Integer> pair : map.entrySet()) {
                    Integer key = pair.getKey();
                    Integer val = pair.getValue();
                    if(val == max) resultMap.put(fileName, key);
                }
            }catch (IOException e){
                System.out.println("Ошибка");
                return;
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
