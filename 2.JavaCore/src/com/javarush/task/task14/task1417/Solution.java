package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            //напишите тут ваш код
        }

        private List<Money> allMoney = Arrays.asList(new Ruble(213), new Hryvnia(213), new USD(3254));



        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
