package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        FileReader file = new FileReader(name);
        File f = new File(name);
        long len = f.length();
        List<Teg> tegs = new ArrayList<>();
        SortedMap<Integer, String> lineTegs = new TreeMap<>();
        String teg = args[0];
        char[] buff = new char[(int) len];
        file.read(buff);
        file.close();
        String text = new String(buff);
        String text1 = text.replaceAll("\\n|\\r", "");
        Pattern p = Pattern.compile("</?"+teg+"[\\s>]");
        Matcher m = p.matcher(text1);

        while (m.find()){
            boolean type;
            String t = text1.substring(m.start(), m.end());
            if (t.length()<=teg.length()+2) type = true;
            else type = false;
            tegs.add(new Teg(m.start(),m.end(),type));
        }


        int i=0;
        while (!tegs.isEmpty()){
            if(tegs.get(i).type&&!tegs.get(i+1).type){
                lineTegs.put(tegs.get(i).start, text1.substring(tegs.get(i).start, tegs.get(i+1).fin));
                tegs.remove(i);
                tegs.remove(i);
                if(i>0) {i=i-1;}
            }else {
                i++;
            }
        }
        for (SortedMap.Entry<Integer,String> x: lineTegs.entrySet()) {
            System.out.println(x.getValue());
        }


    }
    public static class Teg{
        public int start;
        public int fin;
        public boolean type;


        public Teg(int start, int fin, boolean type) {
            this.start = start;
            this.fin = fin;
            this.type = type;
        }


    }

}
