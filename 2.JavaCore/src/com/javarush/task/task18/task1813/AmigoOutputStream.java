package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends   FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    public static String text = "JavaRush © All rights reserved.";
    FileOutputStream output;
    public AmigoOutputStream (FileOutputStream output) throws FileNotFoundException {
        super(fileName);
        this.output = output;
    }

    @Override
    public void flush() throws IOException {
        output.flush();
    }

    @Override
    public void write(byte[] b) throws IOException {
        output.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        output.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        output.write(b);
    }

    @Override
    public void close() throws IOException {
       output.flush();
       output.write(text.getBytes(StandardCharsets.UTF_8));
       output.close();

    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
