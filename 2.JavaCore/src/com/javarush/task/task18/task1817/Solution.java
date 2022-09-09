package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileReader reader = new FileReader(fileName);
        char[] array = new char[1024];
        while (reader.ready()){
            reader.read(array);
        }
        reader.close();
        String first = String.valueOf(array);
        double a = first.length();
        double spaces = first.replaceAll("[^ ]", "").length();
        double c = (spaces/a)*100;
        System.out.println(String.format("%.2f", c));


    }
}

