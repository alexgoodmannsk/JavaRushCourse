package com.javarush.task.task18.task1812;

import java.io.IOException;
import java.io.OutputStream;

public interface AmigoOutputStream {
    void flush() throws IOException;

    void write(int b) throws IOException;

    void write(byte[] b) throws IOException;

    void write(byte[] b, int off, int len) throws IOException;

    void close() throws IOException;
}
