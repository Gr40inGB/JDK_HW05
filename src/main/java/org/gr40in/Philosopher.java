package org.gr40in;

import java.time.LocalDateTime;

public class Philosopher extends Thread {

    private String name;
    private Fork forkFirst;
    private Fork forkSecond;
    public int placeOnTable;
    public int needToEatCount = 3;
    public LocalDateTime time = null;

    @Override
    public String toString() {
        return placeOnTable + 1 + ". " + name + " [" + forkFirst + ", " + forkSecond + "]";
    }

    public Philosopher(int placeOnTable, String name, Fork leftFork, Fork rightFork) {
        this.placeOnTable = placeOnTable;
        this.name = name;
        forkFirst = leftFork.compareTo(rightFork) < 0 ? leftFork : rightFork;
        forkSecond = leftFork.compareTo(rightFork) > 0 ? leftFork : rightFork;
    }

    @Override
    public void run() {
        time = LocalDateTime.now();
        while (needToEatCount > 0) {
            synchronized (forkFirst) {
                synchronized (forkSecond) {
                    eat();
                    needToEatCount--;
                }
            }
            think();
        }
    }

    private void eat() {
        System.out.println(toString() + "\t  start eating " + needToEatCount + " " + LocalDateTime.now());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(toString() + "\t finish eating " + needToEatCount + " " + LocalDateTime.now());

    }

    private void think() {
        System.out.println(toString() + "\t  start thinking " + needToEatCount + " " + LocalDateTime.now());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(toString() + "\t  finish thinking " + needToEatCount + " " + LocalDateTime.now());

    }
}
