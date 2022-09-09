package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key1 = reader.readLine();
        String key2 = reader.readLine();
        int number1 = Integer.parseInt(key1);
        int number2 = Integer.parseInt(key2);
        if (number1 <= 0 || number2 <= 0) throw new Exception();
        while (number2 !=0) {
            int temp = number1%number2;
            number1 = number2;
            number2 = temp;
        }
        System.out.println(number1);


}}
