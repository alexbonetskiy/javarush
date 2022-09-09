package com.javarush.task.pro.task16.task1612;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/* 
Синтезируем LocalDateTime
*/

public class Solution {

    public static void main(String[] args) {
        Map<LocalDate, List<LocalTime>> dateMap = DateTimeGenerator.generateDateMap();
        printCollection(dateMap.entrySet());

        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);
    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap) {
        //напишите тут ваш код
        Set<LocalDateTime> set = new HashSet<>();
        for (Map.Entry<LocalDate, List<LocalTime>> map : sourceMap.entrySet()){
            for (int i = 0; i <map.getValue().size() ; i++) {
                LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(map.getKey().getYear(), map.getKey().getMonth(), map.getKey().getDayOfMonth()), LocalTime.of(map.getValue().get(i).getHour(), map.getValue().get(i).getMinute(),map.getValue().get(i).getSecond(),map.getValue().get(i).getNano() ));
                set.add(localDateTime);
            }
        }

        return set;
    }

    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}