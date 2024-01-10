package org.gr40in;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Table {

    private final static List<String> allNames = new ArrayList<>(Arrays.asList(
            "Aristotle",
            "Plato",
            "Socrates",
            "Confucius",
            "Immanuel Kant",
            "Friedrich Nietzsche",
            "Karl Marx"));

    private static int countTableSize = 5;
    private static List<Philosopher> philosophers = new ArrayList<>(countTableSize);
    private static List<Fork> forks = new ArrayList<>(countTableSize);


    public static void main(String[] args) {
        forks = prepareTable(countTableSize);
        philosophers = invitePhilosophersToTheTable(countTableSize);
        System.out.println(philosophers);

    }

    private static List<Fork> prepareTable(int countTableSize) {
        List<Fork> tempLink = new ArrayList<>(countTableSize);
        for (int i = 0; i < countTableSize; i++) {

        }
        return tempLink;
    }

    public static List<Philosopher> invitePhilosophersToTheTable(int count) {
        List<Philosopher> tempLink = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            tempLink.add(new Philosopher(i, allNames.get(i)));
        }
        return tempLink;
    }

    public static class Philosopher implements Runnable {
        private String name;
        int placeOnTable;

        @Override
        public String toString() {
            return placeOnTable + 1 + ". " + name;
        }

        public Philosopher(int placeOnTable, String name) {
            this.placeOnTable = placeOnTable;
            this.name = name;
        }

        @Override
        public void run() {

        }

        public void eat() throws InterruptedException {
            if (canEat(this)) {
                Thread.sleep((long) Math.random() * 10000);
            }
        }


    }

    private static boolean canEat(Philosopher philosopher) {

    }


    private static class Fork {
        int numberOnTable;
        boolean used;

        public Fork(int numberOnTable) {
            this.numberOnTable = numberOnTable;
            this.used = false;
        }

        @Override
        public String toString() {
            return "Fork" + numberOnTable + " " + used;
        }
    }
}