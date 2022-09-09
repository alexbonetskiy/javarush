package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Integer[] testArray =new Integer[array.length];
        Arrays.sort(array);
        Integer mediana;
        if(array.length%2 == 0)  mediana = (array[array.length/2-1]+(array[array.length/2]))/2;
        else mediana = array[array.length/2];
        Comparator<Integer> comparator = (o1, o2) -> {
            if(!((o1-mediana) >= 0) && (o2-mediana) >= 0) return Math.abs(o1 - mediana) - (o2 - mediana);
            else if ((o1-mediana) >= 0 && !((o2-mediana) >= 0)) return (o1 - mediana) - Math.abs(o2 - mediana);
            else if (!((o1-mediana) >= 0) && !((o2-mediana) >= 0) ) return o2 - o1;
            else return  (o1 - mediana) - (o2 - mediana);
        };
        Arrays.sort(array, comparator);
        return array;
    }
}
