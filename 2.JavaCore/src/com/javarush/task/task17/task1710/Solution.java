package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]){

            case "-c": {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date date = format.parse(args[3]);
                if (args[2].equals("м")) allPeople.add(Person.createMale(args[1], date));
                if (args[2].equals("ж")) allPeople.add(Person.createFemale(args[1], date));
                System.out.println(allPeople.size()-1);
                break;
            }
            case "-u": {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                Date date = format.parse(args[4]);
                Sex sex = null;
                if(args[3].equals("м")) sex = Sex.MALE;
                if(args[3].equals("ж")) sex = Sex.FEMALE;
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(args[2]);
                person.setSex(sex);
                person.setBirthDay(date);
                break;
            }
            case "-d": {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setBirthDay(null);
                person.setSex(null);
                allPeople.set(Integer.parseInt(args[1]), person);
                break;
            }
            case "-i": {
                Person person = allPeople.get(Integer.parseInt(args[1]));
                String sex = "";
                SimpleDateFormat dformat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                if (person.getSex()==Sex.MALE) sex = "м";
                if (person.getSex()==Sex.FEMALE) sex = "ж";
                System.out.println(person.getName() + " " + sex + " " + dformat.format(person.getBirthDay()));
                break;
            }
        }
    }
}
