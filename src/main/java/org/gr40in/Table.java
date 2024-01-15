package org.gr40in;


import java.io.*;
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


    public static void main(String[] args) throws IOException, InterruptedException {
        forks = prepareTable(countTableSize);
        philosophers = invitePhilosophersToTheTable(countTableSize);
        System.out.println(philosophers);

        PrintStream backUp = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream catchStream = new PrintStream(backUp);
        System.setOut(catchStream);

        philosophers.forEach(Thread::start);
        for (Philosopher philosopher : philosophers) {
            philosopher.join();
        }
        System.setOut(backUp);
        System.out.println(byteArrayOutputStream.toString());
    }

    private static List<Fork> prepareTable(int countTableSize) {
        List<Fork> tempLink = new ArrayList<>(countTableSize);
        for (int i = 0; i < countTableSize; i++) {
            tempLink.add(new Fork(i));
        }
        return tempLink;
    }

    public static List<Philosopher> invitePhilosophersToTheTable(int count) {
        List<Philosopher> tempLink = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            tempLink.add(new Philosopher(i, allNames.get(i), forks.get(i), forks.get((i+1)%count)));
        }
        return tempLink;
    }
}