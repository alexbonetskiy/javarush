package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1;
        String fileName2;
        String fileName3;
        FileInputStream fileReader;
        try {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            fileName3 = reader.readLine();
            fileReader =new FileInputStream (fileName1);
            byte[] array = new byte[fileReader.available()];
            while (fileReader.available()>0){
                 fileReader.read(array);
            }
            int halfArray = array.length/2;
            FileOutputStream out1 = new FileOutputStream (fileName2);
            FileOutputStream out2 = new FileOutputStream(fileName3);
            if (array.length%2 == 0){
                out1.write(array,0, halfArray);
                out2.write(array,  halfArray, halfArray);}
            else {
                out1.write(array,0, halfArray+1);
                out2.write(array, halfArray +1, halfArray );

            }

                out2.close();
                out1.close();
                fileReader.close();
                reader.close();




    } catch (IOException e) {e.printStackTrace();}


}}
