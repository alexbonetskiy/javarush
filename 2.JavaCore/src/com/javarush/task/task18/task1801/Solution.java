package com.javarush.task.task18.task1801;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileReader = new FileInputStream(fileName);
        int max = 0;

            while ((fileReader.available()) > 0)
        {
            int b = fileReader.read();
            if (b > max)
                max = b;
        }
        fileReader.close();
        reader.close();
                System.out.println(max);
    }
}
