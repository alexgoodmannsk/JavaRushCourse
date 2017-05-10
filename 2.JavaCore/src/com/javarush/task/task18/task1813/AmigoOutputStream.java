package com.javarush.task.task18.task1813;

import java.io.*;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream stream;

    public AmigoOutputStream(FileOutputStream s) throws FileNotFoundException {
        super(fileName);
        this.stream = s;
    }




    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    @Override
    public void write(int b) throws IOException {
       stream.write(b);
    }

    public void write(byte[] b) throws IOException {
        stream.write(b);
    }

    public void write(byte[] b, int f, int c) throws IOException {
        stream.write(b,f,c);
    }

    public void flush() throws IOException {
        stream.flush();
    }

    @Override
    public void close() throws IOException {
        flush();
        write("JavaRush © All rights reserved.".getBytes());
        stream.close();
    }

}
