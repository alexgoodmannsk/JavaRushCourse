package com.javarush.task.task22.task2207;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader lineReader = new BufferedReader(new InputStreamReader
                (new FileInputStream(fileName), StandardCharsets.UTF_8));
        String line;
        List<String> words = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        while ((line = lineReader.readLine()) != null) {
            builder.append(line);
            builder.append(" ");
        }
        line = builder.toString().trim();    //line
        StringTokenizer st = new StringTokenizer(line, " ");
        while (st.hasMoreTokens()) words.add(st.nextToken());    //words
        int x = words.size();
        for (int i = 0; i < x; i++) {
            String thisWord = words.get(i--);
            StringBuilder sb = new StringBuilder(thisWord);
            String rev = sb.reverse().toString();
            words.remove(thisWord);
            if (words.contains(rev)) {
                Pair pair = new Pair();
                pair.second = thisWord;
                pair.first = rev;
                result.add(pair);
                words.remove(rev);
                x--;
            }
            x--;
        }
        for (Pair pair : result) {
            System.out.println(pair);
        }
    }

    public static class Pair {
        String first;
        String second;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
