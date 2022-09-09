package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    static String fileName;

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
        this.stream = new FileOutputStream(fileName,true);

    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution("D:/Javarush/sample.txt");
        solution.writeObject("sdsd");
        FileOutputStream fileOutput = new FileOutputStream("D:/Javarush/sample1.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(solution);
        outputStream.flush();
        outputStream.close();
        FileInputStream fileInput = new FileInputStream("D:/Javarush/sample1.txt");
        ObjectInputStream inputStream = new ObjectInputStream(fileInput);
        solution = (Solution) inputStream.readObject();
        solution.writeObject("sdsd");
        inputStream.close();


    }
}
