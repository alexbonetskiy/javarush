package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       try {String line = bufferedReader.readLine();
       if (line.equals("helicopter")) {
       result = new Helicopter();}
       if (line.equals("plane")) {
           int passengers = Integer.parseInt(bufferedReader.readLine());
           result = new Plane(passengers);
           bufferedReader.close();
       }
       }
       catch (IOException e) {
           e.printStackTrace();
       }

    }
}
