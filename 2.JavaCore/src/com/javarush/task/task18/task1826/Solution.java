package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String pam = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];
        FileInputStream in = new FileInputStream(fileName);
        FileOutputStream out = new FileOutputStream(fileOutputName);
        byte[] array = new byte[in.available()];
        byte [] reversedArray = new byte[array.length];
        if (args[0].equals("-e") || args[0].equals("-d")){
                while (in.available()>0){
                    in.read(array);}
                in.close();
                for (int i = 0; i < array.length; i++) {
                    reversedArray [i] = array [array.length -1 - i];
                }
                out.write(reversedArray);
                out.close();
        }
        else throw new IllegalArgumentException();

    }

}
