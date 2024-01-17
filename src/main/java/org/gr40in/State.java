package org.gr40in;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class State implements Comparable<State> {
    public String number;
    public boolean start;
    public Action action;
    public LocalDateTime time;
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss:nnn");

    @Override
    public String toString() {
        return number +", start=" + start + ", doing=" + action + ", time=" + time.format(formatter) + '}';
    }

    public State(String data) {
        number = data.substring(0, 1);
        String[] arr = data.split("\\t")[1].trim().split("\\s+");
        start = arr[0].trim().equals("start");
        action = arr[1].trim().equals("eating") ? Action.EATING : Action.THINKING;
        time = LocalDateTime.parse(arr[3]);
    }

    @Override
    public int compareTo(State o) {
        return time.compareTo(o.time);
    }
}