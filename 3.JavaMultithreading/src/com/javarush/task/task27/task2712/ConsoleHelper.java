package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bis.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> list = new ArrayList<>();
        int counter = -1;
        writeMessage(Dish.allDishesToString());
        writeMessage("Выберите, пожалуйста, блюдо:");
        String text = bis.readLine();
        while(!text.equals("exit")){
            for (Dish dish : Dish.values())
            {if (text.equals(dish.name())) counter = dish.ordinal();
            }
            if (counter != -1) {list.add(Dish.values()[counter]); counter = -1;}
            else writeMessage("Такого блюда нет в меню");
            writeMessage("Выбирете блюдо:");
            text = bis.readLine();
        }

        return list;
    }
}
