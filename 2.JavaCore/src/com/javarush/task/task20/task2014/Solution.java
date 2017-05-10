package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args)  {
        System.out.println(new Solution(4));
        try {

            FileOutputStream out = new FileOutputStream("h:\\1.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(out);
            Solution savedObject = new Solution(5);
            outputStream.writeObject(savedObject);
            out.close();
            outputStream.close();

            FileInputStream in = new FileInputStream("h:\\1.txt");
            ObjectInputStream inputStream = new ObjectInputStream(in);
            Object object = inputStream.readObject();
            Solution loadedObject = (Solution) object;
            in.close();
            inputStream.close();

            System.out.println(savedObject.string.equals(loadedObject.string));
        }catch (ClassNotFoundException e){
            System.out.println(e);
        }catch (IOException e){
            System.out.println(e);
        }
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
