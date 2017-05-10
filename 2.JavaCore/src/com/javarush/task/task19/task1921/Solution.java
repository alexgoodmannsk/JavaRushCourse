package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Pattern p = Pattern.compile("(([a-zA-Zа-яА-Я]+\\s?)+)\\s(\\d+\\s\\d+\\s\\d+)");
        String str;
        while ((str = reader.readLine())!=null){

            Matcher m = p.matcher(str);
            m.find();
            String name = m.group(1);
            String date = m.group(3);
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date bd = format.parse(date);
            PEOPLE.add(new Person(name,bd));

        }
        reader.close();


    }
}
