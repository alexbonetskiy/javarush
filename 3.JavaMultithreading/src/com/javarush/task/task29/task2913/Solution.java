package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;


    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        if (a > b) {
            for (int i = a-1; i >b ; i--) {
                stringBuilder.append(" ").append(i);
            }
        } else {
            if (a == b) {
                return Integer.toString(a);
            }
            for (int i = a+1; i < b ; i++) {
                stringBuilder.append(" ").append(i);
            }
        }
        stringBuilder.append(" ").append(b);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}