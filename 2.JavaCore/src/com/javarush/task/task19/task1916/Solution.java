package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        List<String> file1 = new ArrayList<>();
        List<String> file2 = new ArrayList<>();
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String name1 = rd.readLine();
        String name2 = rd.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(name1)); //"h:\\1.txt"
        BufferedReader reader1 = new BufferedReader(new FileReader(name2)); //"h:\\2.txt"
        String s="";
        while ((s = reader.readLine())!=null){
            file1.add(s);
        }
        while ((s = reader1.readLine())!=null){
            file2.add(s);
        }
        for(int i=0; i<file1.size();i++){
            if(!file2.isEmpty()) {
                if (file1.get(i).equals(file2.get(0))) {
                    lines.add(new LineItem(Type.SAME, file1.get(i)));
                    file2.remove(0);
                } else {
                    if (file1.get(i).equals(file2.get(1))) {
                        lines.add(new LineItem(Type.ADDED, file2.get(0)));
                        file2.remove(0);
                        i--;
                    } else {
                        lines.add(new LineItem(Type.REMOVED, file1.get(i)));
                    }
                }
            }
            else lines.add(new LineItem(Type.REMOVED, file1.get(i)));
        }
        if(!file2.isEmpty()) lines.add(new LineItem(Type.ADDED, file2.get(0)));

        rd.close();
        reader.close();
        reader1.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
