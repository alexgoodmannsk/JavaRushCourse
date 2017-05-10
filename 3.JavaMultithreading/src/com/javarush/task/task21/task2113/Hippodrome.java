package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC1 on 17.04.2017.
 */
public class Hippodrome {
    public static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        game = new Hippodrome(horses);
        game.getHorses().add(new Horse("1", 3, 0));
        game.getHorses().add(new Horse("2", 3, 0));
        game.getHorses().add(new Horse("3", 3, 0));

        //Начинаем забег
        game.run();
        game.printWinner();
    }

    public void move() {
        for (Horse x: horses) {
            x.move();
        }
    }

    public void print() {
        for (Horse x: horses) {
            x.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public Horse getWinner() {
        double max = 0;
        Horse winner = null;
        for (Horse x: horses) {
            if(x.distance>max) {
                winner = x;
                max = x.distance;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is "+ getWinner().getName() + "!");
    }
}



