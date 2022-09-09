package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
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
        String result = text.replaceAll("\\p{P}","");


        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))){
            writer.write(result);
        }



    }
}
