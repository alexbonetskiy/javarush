package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }


    public static void main(String[] args) throws InterruptedException {
        Horse h = new Horse("Molly", 3, 0);
        Horse o = new Horse("Micky", 3, 0);
        Horse r = new Horse("Sally", 3, 0);
        List <Horse> list = new ArrayList<>();
        list.add(h); list.add(o); list.add(r);
        game = new Hippodrome(list);
        game.run();
        game.printWinner();

    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);

        }
    }
    public void move() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).move();
        }

    }
    public void print() {
        for (int i = 0; i < horses.size(); i++) {
            horses.get(i).print();
        }
        System.out.println("\n\n\n\n\n\n\n\n\n");
    }

    public Horse getWinner () {
        return Collections.max(horses, Comparator.comparingDouble(Horse::getDistance));
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().name + "!");

    }

}
