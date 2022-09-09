package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;
        String text="";
        String result = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1))) {
            while (reader.ready()) text += reader.readLine()+"\n";
        }
        Pattern p = Pattern.compile("\\b\\d+\\b");
        Matcher matcher = p.matcher(text);
        while (matcher.find()){
            result += text.substring(matcher.start(), matcher.end()) + " ";
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))){
            writer.write(result);
        }



    }
}

