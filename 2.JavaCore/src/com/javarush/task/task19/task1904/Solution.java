package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        File file = new File("h:\\1.txt");
        Scanner c = new Scanner(file);
        PersonScannerAdapter scaner = new PersonScannerAdapter(c);
        Person person = scaner.read();
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;
        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String str = fileScanner.nextLine();
            String[] split = str.split(" ");

            Calendar calendar = new GregorianCalendar(Integer.parseInt(split[5]), Integer.parseInt(split[4]) - 1, Integer.parseInt(split[3]));
            Date date = calendar.getTime();
            Person person = new Person(split[1], split[2], split[0], date);
            return person;

        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
