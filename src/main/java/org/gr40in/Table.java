package org.gr40in;


import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.*;

public class Table {

    private final static List<String> allNames = new ArrayList<>(Arrays.asList(
            "Aristotle", "Plato", "Socrates", "Confucius", "Immanuel Kant", "Friedrich Nietzsche", "Karl Marx"));

    private static int countTableSize = 5;
    private static List<Philosopher> philosophers = new ArrayList<>(countTableSize);
    private static List<Fork> forks = new ArrayList<>(countTableSize);

    public static void main(String[] args) throws IOException, InterruptedException {
        forks = prepareTable(countTableSize);
        philosophers = invitePhilosophersToTheTable(countTableSize);
        System.out.println(philosophers);
//
//        Logger logger = Logger.getLogger("table.logger");
//        logger.setLevel(Level.ALL);
//        ConsoleHandler handler = new ConsoleHandler();
//        handler.setLevel(Level.ALL);
//        handler.setFormatter(new SimpleFormatter());
//        logger.addHandler(handler);
//        logger.fine("dsf");

//        Logger log = Logger.getLogger("my.logger");
//        log.setLevel(Level.ALL);
//        ConsoleHandler handler = new ConsoleHandler();
//        handler.setFormatter(new SimpleFormatter());
//        log.addHandler(handler);
//        log.fine("hello world");
//        logger.addHandler(new StreamHandler(System.out, new SimpleFormatter()));

        PrintStream backUp = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream catchStream = new PrintStream(byteArrayOutputStream);
        System.setOut(catchStream);

        philosophers.forEach(Thread::start);

        for (Philosopher philosopher : philosophers) {
            philosopher.join();
        }

        System.setOut(backUp);
        String data = byteArrayOutputStream.toString();
        System.out.println(data);
        visualisation(data);
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
            tempLink.add(new Philosopher(i, allNames.get(i), forks.get(i), forks.get((i + 1) % count)));
        }
        return tempLink;
    }

    public static void visualisation(String data) {
        List<State> stateList = new ArrayList<>();
        Scanner scanner = new Scanner(data);
        while (scanner.hasNext()) stateList.add(new State(scanner.nextLine()));
        Collections.sort(stateList);

        LocalDateTime start = stateList.getFirst().time;
        List<StringBuilder> dinner = new ArrayList<>() {{
            add(new StringBuilder("1. "));
            add(new StringBuilder("2. "));
            add(new StringBuilder("3. "));
            add(new StringBuilder("4. "));
            add(new StringBuilder("5. "));
        }};
        int scale = 30000000;  // scale nanosecond to console width
        List<List<State>> byNumbers = new ArrayList<>();
        byNumbers.add(stateList.stream().filter(x -> x.number.equals("1")).sorted().toList());
        byNumbers.add(stateList.stream().filter(x -> x.number.equals("2")).sorted().toList());
        byNumbers.add(stateList.stream().filter(x -> x.number.equals("3")).sorted().toList());
        byNumbers.add(stateList.stream().filter(x -> x.number.equals("4")).sorted().toList());
        byNumbers.add(stateList.stream().filter(x -> x.number.equals("5")).sorted().toList());
        for (int d = 0; d < byNumbers.size(); d++) {
            System.out.println(byNumbers.get(d));
            LocalDateTime momentOfDinner = start;
            Action doing = Action.WAITING;
            for (State s : byNumbers.get(d)) {
                int before = (int) Math.abs(Duration.between(s.time, momentOfDinner).toNanos()) / scale;
                for (int i = 0; i < before; i++) {
                    dinner.get(d).append(doing == Action.EATING ? "+" : doing == Action.THINKING ? "." : " ");
                }
                if (s.start) doing = s.action;
                else doing = Action.WAITING;
                momentOfDinner = s.time;
            }
        }
        System.out.println("\n + - eating; . - thinking; ' ' - waiting\n");
        dinner.forEach(System.out::println);
    }
}