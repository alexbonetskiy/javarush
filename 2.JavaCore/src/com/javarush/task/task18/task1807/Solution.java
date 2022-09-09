package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        FileInputStream fileReader;
        int count = 0;
        try {
            fileName = reader.readLine();
            fileReader =new FileInputStream (fileName);
            while (fileReader.available()>0)
        if (fileReader.read() == 44) {
            count++;
        }
        fileReader.close();
        reader.close();
        } catch (IOException e) {e.printStackTrace();}
        System.out.println(count);
    }
}
