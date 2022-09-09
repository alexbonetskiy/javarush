package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH(25),
    STEAK(30),
    SOUP(15),
    JUICE(5),
    WATER(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString() {
        StringBuilder dishes = new StringBuilder();
        for (Dish dish: Dish.values())
        {
            dishes.append(dish.name());
            if (dish.ordinal() != Dish.values().length - 1) dishes.append(", ");
        }
        return  dishes.toString();
    }
}
