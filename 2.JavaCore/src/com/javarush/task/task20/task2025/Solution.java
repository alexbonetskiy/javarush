package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/


public class Solution {
    public static long[][] pow;
    public static long armstrong = 0;
    public static int[] number;
    public static Set<Long> set = new TreeSet<>();



    public static long[] getNumbers(long N) {
        long[] result;
        if (N<=0) return new long[0];
        getPow(N);
        getTestNumber(N);
        int len = 0;
        for (long l : set) {
            if (l < N){
                len++;
            }
        }
        result = new long[len];
        int i = 0;
        for (Long l : set){
            if (i==len) break;
            result[i] = l;
            i++; }
        set.clear();
        Arrays.fill(pow,null);
        return result;

    }


    public static void check(Set<Long> firstResult){
        long[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L, 1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};
        int i = 0;
        for (Long l : firstResult){
            if (l != temp[i]){
                System.out.println("False");
            }
            i++;
        }
        System.out.println("true");
    }

    public static long[][] getPow (long N)
    {
        long n;
        int length = (int) (Math.log10(N) + 1);
        pow = new long[10][length+1];
        for (int i = 0; i < length+1; i++) {
            pow [0][i] = 0;
        }
        for (int i = 1; i < 10; i++) {
            n = 1;
            for (int j = 0; j < length+1; j++) {
                pow[i][j] = n;
                n *= i;
            }

        }
        return pow;
    }

    public static void getTestNumber (long N) {
        long possibleArmstrong = 0;
        int length = (int) (Math.log10(N) + 1);
        number = new int[length];
        int power = 0;
        int b = 0;
        int v = 0;
        long [] array;
        int f = 0;
        long check;
        while (increment()) {
            int y =0;
            for (int i = number.length - 1; i > 0 ; i--) {
                y++;
                if(number[i]==0 && number[i-1]==0) {power = number.length; b=0; v= y-2; break;} else {power = number.length; b =0; v = number.length -2;}
            }
            while (power > v){

                for (int z = b; z < number.length; z++) {
                    if (number[z]==0) continue;
                    if (number[z]==1) {armstrong ++; continue;}
                    armstrong += pow[number[z]][power];
                }
                String inputToString = String.valueOf(armstrong);
                f = inputToString.length();
                array = new long[f];
                check =  armstrong;
                if (armstrong < 0 || f != power) {armstrong = 0;
                    power--;
                    b++;continue;}
                for (int k = array.length-1; k >=0; k--)
                {
                    array[k] = check%10;
                    check /=10;
                }
                for (int j = 0; j < array.length; j++) {
                    if (array[j]==0) continue;
                    possibleArmstrong += pow[(int) array[j]][f];
                }
                if (possibleArmstrong == armstrong) {set.add(armstrong);
                }
                possibleArmstrong = 0;
                armstrong = 0;
                power--;
                b++;
            }}


    }

    public static boolean increment () {
        int index = number.length - 1;
        while ((index > 0) && (number[index] == 9)){
            index--;
        }
        if (number[0] == 9) return false;
        Arrays.fill(number, index, number.length, number[index]+1);
        return true;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
