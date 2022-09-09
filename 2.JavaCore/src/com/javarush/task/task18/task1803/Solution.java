package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileReader = new FileInputStream(fileName);
        int[] array = new int[256];
        while (fileReader.available()>0){
            int a = fileReader.read();
            array[a]++;
        }
        fileReader.close();
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i]>max) max = array[i];
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <array.length; i++) {
            if (array[i] == max) result.add(i);
        }

        for (int i = 0; i <result.size(); i++) {
            System.out.print(result.get(i) + " ");

        }
}
}
