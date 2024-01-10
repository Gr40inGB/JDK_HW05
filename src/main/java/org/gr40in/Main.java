package org.gr40in;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5};
        List<Integer> list = Arrays.asList(array);
//        list.add(6);
        System.out.println(list);
        array[0]=100;
        System.out.println(list);
    }
}