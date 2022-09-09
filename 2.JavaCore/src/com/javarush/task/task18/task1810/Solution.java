package com.javarush.task.task18.task1810;

import java.io.*;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1;
        FileInputStream fileReader;
       while (true){ try {
            fileName1 = reader.readLine();
            fileReader =new FileInputStream (fileName1);
           if(fileReader.available() < 1000){
            fileReader.close();
            reader.close();
           throw new DownloadException();}
        }
        catch (IOException e) {}

    }}

    public static class DownloadException extends Exception {

    }
}
