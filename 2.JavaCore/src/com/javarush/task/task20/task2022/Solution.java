package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName,  true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {;
        Solution obj = new Solution("h:\\1.txt");
        obj.writeObject("12345678");
        obj.writeObject("87654321");

        FileOutputStream outputStream = new FileOutputStream("h:\\2.txt");
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        oos.writeObject(obj);
        oos.flush();

        FileInputStream inputStream = new FileInputStream("h:\\2.txt");
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        Solution loadObj = (Solution) ois.readObject();

        loadObj.writeObject("123");

    }
}
