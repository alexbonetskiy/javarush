package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileReader reader = new FileReader(fileName);
        char[] array = new char[1024];
        while (reader.ready()){
            reader.read(array);
        }
        String text = String.valueOf(array).trim().replaceAll("[^a-z;A-z]", "");
        System.out.println(text.length());
        reader.close();

    }
}
