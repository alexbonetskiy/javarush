package com.javarush.task.pro.task16.task1604;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* 
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(1988, 5, 1);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код
         int day = calendar.get(Calendar.DAY_OF_WEEK);
        String d;
        switch (day){
            case 1: d = "воскресенье";
                break;
            case 2: d = "понедельник";
                break;
            case 3: d = "вторник";
                break;
            case 4: d = "среда";
                break;
            case 5: d = "четверг";
                break;
            case 6: d = "пятница";
                break;
            case 7: d = "суббота";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + day);
        }

        return d;
    }
}
