package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.*;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1;
        String fileName2;
        FileInputStream fileReader;
        FileOutputStream output;
        try {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            fileReader =new FileInputStream (fileName1);
            byte[] array = new byte[fileReader.available()];
            while (fileReader.available()>0){
                fileReader.read(array);
            }
            fileReader.close();
            byte [] reversedArray = new byte[array.length];
            for (int i = 0; i < array.length; i++) {
                reversedArray [i] = array [array.length -1 - i];

            }
            output = new FileOutputStream(fileName2);
            output.write(reversedArray, 0, reversedArray.length);

            output.close();






        }
        catch (IOException e) {}


    }
}

