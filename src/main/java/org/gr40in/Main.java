package org.gr40in;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        String data = "1. Aristotle [Fork 0, Fork 1]\t  start eating 3 2024-01-15T00:32:38.166689\n" +
                "3. Aristotle [Fork 2, Fork 3]\t  start eating 3 2024-01-15T00:32:38.166689\n" +
                "3. Aristotle [Fork 2, Fork 3]\t finish eating 3 2024-01-15T00:32:38.675578300\n" +
                "1. Aristotle [Fork 0, Fork 1]\t finish eating 3 2024-01-15T00:32:38.675578300\n" +
                "4. Aristotle [Fork 3, Fork 4]\t  start eating 3 2024-01-15T00:32:38.675578300\n" +
                "2. Aristotle [Fork 1, Fork 2]\t  start eating 3 2024-01-15T00:32:38.675578300\n" +
                "3. Aristotle [Fork 2, Fork 3]\t  start thinking 2 2024-01-15T00:32:38.675578300\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  start thinking 2 2024-01-15T00:32:38.675578300\n" +
                "3. Aristotle [Fork 2, Fork 3]\t  finish thinking 2 2024-01-15T00:32:38.977163900\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 2 2024-01-15T00:32:38.977163900\n" +
                "4. Aristotle [Fork 3, Fork 4]\t finish eating 3 2024-01-15T00:32:39.176301800\n" +
                "4. Aristotle [Fork 3, Fork 4]\t  start thinking 2 2024-01-15T00:32:39.176301800\n" +
                "5. Aristotle [Fork 0, Fork 4]\t  start eating 3 2024-01-15T00:32:39.176301800\n" +
                "2. Aristotle [Fork 1, Fork 2]\t finish eating 3 2024-01-15T00:32:39.178293900\n" +
                "2. Aristotle [Fork 1, Fork 2]\t  start thinking 2 2024-01-15T00:32:39.178293900\n" +
                "3. Aristotle [Fork 2, Fork 3]\t  start eating 2 2024-01-15T00:32:39.178293900\n" +
                "2. Aristotle [Fork 1, Fork 2]\t  finish thinking 2 2024-01-15T00:32:39.478496600\n" +
                "4. Aristotle [Fork 3, Fork 4]\t  finish thinking 2 2024-01-15T00:32:39.478496600\n" +
                "5. Aristotle [Fork 0, Fork 4]\t finish eating 3 2024-01-15T00:32:39.677536700\n" +
                "5. Aristotle [Fork 0, Fork 4]\t  start thinking 2 2024-01-15T00:32:39.677536700\n" +
                "3. Aristotle [Fork 2, Fork 3]\t finish eating 2 2024-01-15T00:32:39.678536600\n" +
                "3. Aristotle [Fork 2, Fork 3]\t  start thinking 1 2024-01-15T00:32:39.678536600\n" +
                "2. Aristotle [Fork 1, Fork 2]\t  start eating 2 2024-01-15T00:32:39.678536600\n" +
                "4. Aristotle [Fork 3, Fork 4]\t  start eating 2 2024-01-15T00:32:39.678536600\n" +
                "5. Aristotle [Fork 0, Fork 4]\t  finish thinking 2 2024-01-15T00:32:39.977728\n" +
                "3. Aristotle [Fork 2, Fork 3]\t  finish thinking 1 2024-01-15T00:32:39.978725\n" +
                "4. Aristotle [Fork 3, Fork 4]\t finish eating 2 2024-01-15T00:32:40.178928400\n" +
                "2. Aristotle [Fork 1, Fork 2]\t finish eating 2 2024-01-15T00:32:40.178928400\n" +
                "4. Aristotle [Fork 3, Fork 4]\t  start thinking 1 2024-01-15T00:32:40.178928400\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  start eating 2 2024-01-15T00:32:40.178928400\n" +
                "3. Aristotle [Fork 2, Fork 3]\t  start eating 1 2024-01-15T00:32:40.178928400\n" +
                "2. Aristotle [Fork 1, Fork 2]\t  start thinking 1 2024-01-15T00:32:40.178928400\n" +
                "4. Aristotle [Fork 3, Fork 4]\t  finish thinking 1 2024-01-15T00:32:40.481254100\n" +
                "2. Aristotle [Fork 1, Fork 2]\t  finish thinking 1 2024-01-15T00:32:40.481254100\n" +
                "1. Aristotle [Fork 0, Fork 1]\t finish eating 2 2024-01-15T00:32:40.679516600\n" +
                "5. Aristotle [Fork 0, Fork 4]\t  start eating 2 2024-01-15T00:32:40.679516600\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  start thinking 1 2024-01-15T00:32:40.679516600\n" +
                "3. Aristotle [Fork 2, Fork 3]\t finish eating 1 2024-01-15T00:32:40.681509700\n" +
                "2. Aristotle [Fork 1, Fork 2]\t  start eating 1 2024-01-15T00:32:40.681509700\n" +
                "3. Aristotle [Fork 2, Fork 3]\t  start thinking 0 2024-01-15T00:32:40.681509700\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 1 2024-01-15T00:32:40.980494900\n" +
                "3. Aristotle [Fork 2, Fork 3]\t  finish thinking 0 2024-01-15T00:32:40.982495500\n" +
                "5. Aristotle [Fork 0, Fork 4]\t finish eating 2 2024-01-15T00:32:41.180761500\n" +
                "5. Aristotle [Fork 0, Fork 4]\t  start thinking 1 2024-01-15T00:32:41.180761500\n" +
                "4. Aristotle [Fork 3, Fork 4]\t  start eating 1 2024-01-15T00:32:41.180761500\n" +
                "2. Aristotle [Fork 1, Fork 2]\t finish eating 1 2024-01-15T00:32:41.181761200\n" +
                "2. Aristotle [Fork 1, Fork 2]\t  start thinking 0 2024-01-15T00:32:41.181761200\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  start eating 1 2024-01-15T00:32:41.181761200\n" +
                "5. Aristotle [Fork 0, Fork 4]\t  finish thinking 1 2024-01-15T00:32:41.482951800\n" +
                "2. Aristotle [Fork 1, Fork 2]\t  finish thinking 0 2024-01-15T00:32:41.489950600\n" +
                "4. Aristotle [Fork 3, Fork 4]\t finish eating 1 2024-01-15T00:32:41.683074700\n" +
                "4. Aristotle [Fork 3, Fork 4]\t  start thinking 0 2024-01-15T00:32:41.683074700\n" +
                "1. Aristotle [Fork 0, Fork 1]\t finish eating 1 2024-01-15T00:32:41.696071400\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  start thinking 0 2024-01-15T00:32:41.696071400\n" +
                "5. Aristotle [Fork 0, Fork 4]\t  start eating 1 2024-01-15T00:32:41.696071400\n" +
                "4. Aristotle [Fork 3, Fork 4]\t  finish thinking 0 2024-01-15T00:32:41.985524400\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 0 2024-01-15T00:32:42.010523900\n" +
                "5. Aristotle [Fork 0, Fork 4]\t finish eating 1 2024-01-15T00:32:42.201600800\n" +
                "5. Aristotle [Fork 0, Fork 4]\t  start thinking 0 2024-01-15T00:32:42.201600800\n" +
                "5. Aristotle [Fork 0, Fork 4]\t  finish thinking 0 2024-01-15T00:32:42.513399400";

        String data0 = "1. Aristotle [Fork 0, Fork 1]\t  start eating 3 2024-01-14T20:11:59.477935700\n" +
                "3. Socrates [Fork 2, Fork 3]\t  start eating 3 2024-01-14T20:11:59.477935700\n" +
                "3. Socrates [Fork 2, Fork 3]\t finish eating 3 2024-01-14T20:12:01.486705700\n" +
                "1. Aristotle [Fork 0, Fork 1]\t finish eating 3 2024-01-14T20:12:01.486705700\n" +
                "4. Confucius [Fork 3, Fork 4]\t  start eating 3 2024-01-14T20:12:01.487702900\n" +
                "3. Socrates [Fork 2, Fork 3]\t  start thinking 2 2024-01-14T20:12:01.487702900\n" +
                "2. Plato [Fork 1, Fork 2]\t  start eating 3 2024-01-14T20:12:01.487702900\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  start thinking 2 2024-01-14T20:12:01.487702900\n" +
                "4. Confucius [Fork 3, Fork 4]\t finish eating 3 2024-01-14T20:12:03.488529100\n" +
                "4. Confucius [Fork 3, Fork 4]\t  start thinking 2 2024-01-14T20:12:03.488529100\n" +
                "5. Immanuel Kant [Fork 0, Fork 4]\t  start eating 3 2024-01-14T20:12:03.488529100\n" +
                "2. Plato [Fork 1, Fork 2]\t finish eating 3 2024-01-14T20:12:03.489528700\n" +
                "2. Plato [Fork 1, Fork 2]\t  start thinking 2 2024-01-14T20:12:03.489528700\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 2 2024-01-14T20:12:04.489326400\n" +
                "3. Socrates [Fork 2, Fork 3]\t  finish thinking 2 2024-01-14T20:12:04.489326400\n" +
                "3. Socrates [Fork 2, Fork 3]\t  start eating 2 2024-01-14T20:12:04.489326400\n" +
                "5. Immanuel Kant [Fork 0, Fork 4]\t finish eating 3 2024-01-14T20:12:05.504957900\n" +
                "5. Immanuel Kant [Fork 0, Fork 4]\t  start thinking 2 2024-01-14T20:12:05.504957900\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  start eating 2 2024-01-14T20:12:05.504957900\n" +
                "3. Socrates [Fork 2, Fork 3]\t finish eating 2 2024-01-14T20:12:06.490677900\n" +
                "3. Socrates [Fork 2, Fork 3]\t  start thinking 1 2024-01-14T20:12:06.490677900\n" +
                "4. Confucius [Fork 3, Fork 4]\t  finish thinking 2 2024-01-14T20:12:06.493085300\n" +
                "2. Plato [Fork 1, Fork 2]\t  finish thinking 2 2024-01-14T20:12:06.493085300\n" +
                "4. Confucius [Fork 3, Fork 4]\t  start eating 2 2024-01-14T20:12:06.493085300\n" +
                "1. Aristotle [Fork 0, Fork 1]\t finish eating 2 2024-01-14T20:12:07.511679400\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  start thinking 1 2024-01-14T20:12:07.511679400\n" +
                "2. Plato [Fork 1, Fork 2]\t  start eating 2 2024-01-14T20:12:07.511679400\n" +
                "4. Confucius [Fork 3, Fork 4]\t finish eating 2 2024-01-14T20:12:08.494517900\n" +
                "4. Confucius [Fork 3, Fork 4]\t  start thinking 1 2024-01-14T20:12:08.494517900\n" +
                "5. Immanuel Kant [Fork 0, Fork 4]\t  finish thinking 2 2024-01-14T20:12:08.512828900\n" +
                "5. Immanuel Kant [Fork 0, Fork 4]\t  start eating 2 2024-01-14T20:12:08.512828900\n" +
                "3. Socrates [Fork 2, Fork 3]\t  finish thinking 1 2024-01-14T20:12:09.498036300\n" +
                "2. Plato [Fork 1, Fork 2]\t finish eating 2 2024-01-14T20:12:09.513574500\n" +
                "2. Plato [Fork 1, Fork 2]\t  start thinking 1 2024-01-14T20:12:09.513574500\n" +
                "3. Socrates [Fork 2, Fork 3]\t  start eating 1 2024-01-14T20:12:09.513574500\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 1 2024-01-14T20:12:10.513180200\n" +
                "5. Immanuel Kant [Fork 0, Fork 4]\t finish eating 2 2024-01-14T20:12:10.515180200\n" +
                "5. Immanuel Kant [Fork 0, Fork 4]\t  start thinking 1 2024-01-14T20:12:10.515180200\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  start eating 1 2024-01-14T20:12:10.515180200\n" +
                "4. Confucius [Fork 3, Fork 4]\t  finish thinking 1 2024-01-14T20:12:11.509456600\n" +
                "3. Socrates [Fork 2, Fork 3]\t finish eating 1 2024-01-14T20:12:11.524963700\n" +
                "3. Socrates [Fork 2, Fork 3]\t  start thinking 0 2024-01-14T20:12:11.524963700\n" +
                "4. Confucius [Fork 3, Fork 4]\t  start eating 1 2024-01-14T20:12:11.524963700\n" +
                "1. Aristotle [Fork 0, Fork 1]\t finish eating 1 2024-01-14T20:12:12.527664700\n" +
                "2. Plato [Fork 1, Fork 2]\t  finish thinking 1 2024-01-14T20:12:12.527664700\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  start thinking 0 2024-01-14T20:12:12.527664700\n" +
                "2. Plato [Fork 1, Fork 2]\t  start eating 1 2024-01-14T20:12:12.527664700\n" +
                "5. Immanuel Kant [Fork 0, Fork 4]\t  finish thinking 1 2024-01-14T20:12:13.522872100\n" +
                "4. Confucius [Fork 3, Fork 4]\t finish eating 1 2024-01-14T20:12:13.538885100\n" +
                "4. Confucius [Fork 3, Fork 4]\t  start thinking 0 2024-01-14T20:12:13.538885100\n" +
                "5. Immanuel Kant [Fork 0, Fork 4]\t  start eating 1 2024-01-14T20:12:13.538885100\n" +
                "2. Plato [Fork 1, Fork 2]\t finish eating 1 2024-01-14T20:12:14.535595\n" +
                "3. Socrates [Fork 2, Fork 3]\t  finish thinking 0 2024-01-14T20:12:14.535595\n" +
                "2. Plato [Fork 1, Fork 2]\t  start thinking 0 2024-01-14T20:12:14.535595\n" +
                "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 0 2024-01-14T20:12:15.538622400\n" +
                "5. Immanuel Kant [Fork 0, Fork 4]\t finish eating 1 2024-01-14T20:12:15.553628900\n" +
                "5. Immanuel Kant [Fork 0, Fork 4]\t  start thinking 0 2024-01-14T20:12:15.553628900\n" +
                "4. Confucius [Fork 3, Fork 4]\t  finish thinking 0 2024-01-14T20:12:16.539456600\n" +
                "2. Plato [Fork 1, Fork 2]\t  finish thinking 0 2024-01-14T20:12:17.542158800\n" +
                "5. Immanuel Kant [Fork 0, Fork 4]\t  finish thinking 0 2024-01-14T20:12:18.559764700";
        List<State> stateList = new ArrayList<>();
        Scanner scanner = new Scanner(data);
        while (scanner.hasNext()) stateList.add(new State(scanner.nextLine()));
        Collections.sort(stateList);
        LocalDateTime start = stateList.getFirst().time;
        LocalDateTime end = stateList.getLast().time;
        Duration duration = Duration.between(start, end);
        System.out.println(duration.getNano());
        List<StringBuilder> dinner = new ArrayList<>() {{
            add(new StringBuilder("1."));
            add(new StringBuilder("2."));
            add(new StringBuilder("3."));
            add(new StringBuilder("4."));
            add(new StringBuilder("5."));
        }};

        int scale = 500000;

        List<State> states1 = stateList.stream().filter(x -> x.number.equals("5")).toList();

//        for (int d = 1; d < dinner.size() + 1; d++) {
        LocalDateTime momentOfDinner = start;
        Doing doing = Doing.waiting;
        for (State s : states1) {
//                if (s.number.equals(String.valueOf(d))) {
            int before = (int) Duration.between(momentOfDinner, s.time).getSeconds()*10;

            for (int i = 0; i < before; i++) {
                dinner.get(0).append(doing == Doing.eating ? "+" : doing == Doing.thinking ? "." : "_");
            }
            if (s.start) doing = s.doing;
            else doing = Doing.waiting;
            momentOfDinner = s.time;

        }
//            }
//        }

        dinner.forEach(System.out::println);
    }

    static class State implements Comparable<State> {
        String number;
        boolean start;
        Doing doing;

        @Override
        public String toString() {
            return "State{" +
                    "number='" + number + '\'' +
                    ", start=" + start +
                    ", doing=" + doing +
                    ", time=" + time +
                    '}';
        }

        LocalDateTime time;

        public State(String data) {
            number = data.substring(0, 1);
            String[] arr = data.split("\\t")[1].trim().split("\\s+");
            start = arr[0].trim().equals("start");
            doing = arr[1].trim().equals("eating") ? Doing.eating : Doing.thinking;
            time = LocalDateTime.parse(arr[3]);
        }

        @Override
        public int compareTo(State o) {
            return time.compareTo(o.time);
        }
    }

    enum Doing {
        waiting,
        eating,
        thinking
    }

}