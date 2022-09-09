package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.Arrays;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter;
        char[] array = new char[1024];
        while(fileReader.ready()) fileReader.read(array);
        String[] text = String.valueOf(array).trim().split(" ");
        System.out.println(Arrays.toString(text));
        StringBuilder result = new StringBuilder();
        int a;
        for (String s:text){
            a =  Math.round(Float.parseFloat(s));
            result.append(a).append(" ");
        }
        fileWriter = new FileWriter(fileName2);
        System.out.println(result);
        fileWriter.write(result.toString());


        fileReader.close();
        fileWriter.close();





    }
}
