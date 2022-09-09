package com.javarush.task.task18.task1828;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }
        String pam = args[0];
        String fileName;
        FileReader reader;
        FileWriter writer;
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(System.in));
        fileName = fileReader.readLine();
        reader = new FileReader(fileName);
        char[] array = new char[1024];
        int z = 0;
        while (reader.ready()) {
            array[z] = (char) reader.read();
            z++;

        }
        String text = String.valueOf(array).trim();
        String[] stringText = text.split("\n");
        reader.close();
        List<String> list = new ArrayList<>(Arrays.asList(stringText));
        switch (pam) {
            case "-c":
                int idMax = 0;
                for (String s : stringText) {
                    int a = Integer.parseInt(s.substring(0, 8).trim().replaceAll("[^0-9]", ""));
                    if (a > idMax) idMax = a;
                }
                idMax += 1;
                writer = new FileWriter(fileName, true);
                writer.write("\n");
                writer.write(String.format("%-8d%-30s%-8s%-4s", idMax, args[1], args[2], args[3]));
                writer.close();
                break;
            case "-d":
                for (int i=0; i< list.size(); i++) {
                    int a = Integer.parseInt(list.get(i).substring(0, 8).trim().replaceAll("[^0-9]", ""));
                    if ((Integer.parseInt(args[1])) == (a)) {
                        list.remove(i);
                        break;
                    }
                }
                writer = new FileWriter(fileName);
                for (String value : list) {
                    writer.write(value.substring(0, 8));
                    writer.write(value.substring(8, 38));
                    writer.write(value.substring(38, 46));
                    writer.write(value.substring(46, 50));
                    writer.write("\n");

                }

                writer.close();
                break;
            case "-u":
                for (int i = 0; i < list.size(); i++) {
                    int a = Integer.parseInt(list.get(i).substring(0, 8).trim().replaceAll("[^0-9]", ""));
                    if ((Integer.parseInt(args[1])) == (a)) {
                        list.set(i, String.format("%-8d%-30s%-8s%-4s", Integer.parseInt(args[1]), args[2], args[3], args[4]));
                    }
                }
                writer = new FileWriter(fileName);
                for (String value : list) {
                    writer.write(value.substring(0, 8));
                    writer.write(value.substring(8, 38));
                    writer.write(value.substring(38, 46));
                    writer.write(value.substring(46, 50));
                    writer.write("\n");

                }

                writer.close();


                break;



        }


    }
}


