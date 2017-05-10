package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]){

            case "-c": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        runParamC(args[i++], args[i++], args[i++]);
                    }
                    break;
                }
            }
            case "-u": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        runParamU(args[i++], args[i++], args[i++], args[i++]);
                    }
                    break;
                }
            }
            case "-d": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        runParamD(args[i++]);
                    }
                    break;
                }
            }
            case "-i": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        runParamI(args[i++]);
                    }
                    break;
                }
            }
        }
    }

    private static void runParamC(String name, String sex, String bd) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = format.parse(bd);
        if (sex.equals("м")) allPeople.add(Person.createMale(name, date));
        if (sex.equals("ж")) allPeople.add(Person.createFemale(name, date));
        System.out.println(allPeople.size()-1);
    }

    private static void runParamU(String id, String name, String sexx, String bd) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = format.parse(bd);
        Sex sex = null;
        if(sexx.equals("м")) sex = Sex.MALE;
        if(sexx.equals("ж")) sex = Sex.FEMALE;
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(name);
        person.setSex(sex);
        person.setBirthDay(date);
    }

    private static void runParamD(String id){
        Person person = allPeople.get(Integer.parseInt(id));
        person.setName(null);
        person.setBirthDay(null);
        person.setSex(null);
        allPeople.set(Integer.parseInt(id), person);
    }

    private static void runParamI(String id){
        Person person = allPeople.get(Integer.parseInt(id));
        String sex = "";
        SimpleDateFormat dformat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        if (person.getSex()==Sex.MALE) sex = "м";
        if (person.getSex()==Sex.FEMALE) sex = "ж";
        System.out.println(person.getName() + " " + sex + " " + dformat.format(person.getBirthDay()));
    }
}

