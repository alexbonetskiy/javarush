package com.javarush.task.pro.task16.task1601;

import java.util.Calendar;
import java.util.Date;

/* 
Лишь бы не в понедельник:)
*/

public class Solution {

    static Date birthDate = new Date(88,5,1);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        //напишите тут ваш код
        int day = date.getDay();
        String d;
        switch (day){
            case 0: d = "воскресенье";
            break;
            case 1: d = "понедельник";
                break;
            case 2: d = "вторник";
                break;
            case 3: d = "среда";
                break;
            case 4: d = "четверг";
                break;
            case 5: d = "пятница";
                break;
            case 6: d = "суббота";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + day);
        }
        return d;

    }
}
