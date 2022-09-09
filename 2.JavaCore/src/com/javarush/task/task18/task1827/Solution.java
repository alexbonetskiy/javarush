package com.javarush.task.task18.task1827;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }
        String pam = args[0], productName = args[1], price = args[2], quantity = args[3];
        String fileName;
        FileReader reader;
        FileWriter writer;
        BufferedReader fileReader =  new BufferedReader(new InputStreamReader(System.in) );
        fileName = fileReader.readLine();
        reader = new FileReader(fileName);
        char[] array = new char[1024];
        int i =0;
        while (reader.ready()) {
            array[i] = (char) reader.read();
            System.out.println(Character.getNumericValue(array[i]));
            i++;

        }
        System.out.println(array);
        String text = String.valueOf(array).trim();
        System.out.println(text);
        String [] stringText = text.split("\n");

        reader.close();
        String c =stringText[0].substring(0, 8).trim().replaceAll("[^0-9]", "");

        if (pam.equals("-c")) {
            int idMax = 0;
            for (String s : stringText) {
                int a = Integer.parseInt(s.substring(0, 8).trim().replaceAll("[^0-9]", ""));
                if (a > idMax) idMax = a;
            }
            idMax +=1;
            writer = new FileWriter(fileName, true);
            writer.write("\n");
            writer.write(String.format("%-8d%-30s%-8s%-4s", idMax, productName, price, quantity));
            writer.close();
        }


    }
}

