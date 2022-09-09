package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        String text = "";


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = bufferedReader.readLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) text += reader.readLine() + "\n";

        }
            Pattern p = Pattern.compile("\\bworld\\b");
            Matcher matcher = p.matcher(text);
            int count = 0;
            while (matcher.find()) count++;
            System.out.println(count);

    }
}
