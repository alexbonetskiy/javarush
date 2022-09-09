package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;
        String text="";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1))) {
            while (reader.ready()) text += reader.readLine()+"\n";
        }
       String result = text.replaceAll("\\.","!");


        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))){
            writer.write(result);
        }



    }
}
