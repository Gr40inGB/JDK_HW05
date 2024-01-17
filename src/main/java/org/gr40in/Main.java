package org.gr40in;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        String data = "1. Aristotle [Fork 0, Fork 1]\t  start eating 3 2024-01-15T00:32:38.166689\n" + "3. Aristotle [Fork 2, Fork 3]\t  start eating 3 2024-01-15T00:32:38.166689\n" + "3. Aristotle [Fork 2, Fork 3]\t finish eating 3 2024-01-15T00:32:38.675578300\n" + "1. Aristotle [Fork 0, Fork 1]\t finish eating 3 2024-01-15T00:32:38.675578300\n" + "4. Aristotle [Fork 3, Fork 4]\t  start eating 3 2024-01-15T00:32:38.675578300\n" + "2. Aristotle [Fork 1, Fork 2]\t  start eating 3 2024-01-15T00:32:38.675578300\n" + "3. Aristotle [Fork 2, Fork 3]\t  start thinking 2 2024-01-15T00:32:38.675578300\n" + "1. Aristotle [Fork 0, Fork 1]\t  start thinking 2 2024-01-15T00:32:38.675578300\n" + "3. Aristotle [Fork 2, Fork 3]\t  finish thinking 2 2024-01-15T00:32:38.977163900\n" + "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 2 2024-01-15T00:32:38.977163900\n" + "4. Aristotle [Fork 3, Fork 4]\t finish eating 3 2024-01-15T00:32:39.176301800\n" + "4. Aristotle [Fork 3, Fork 4]\t  start thinking 2 2024-01-15T00:32:39.176301800\n" + "5. Aristotle [Fork 0, Fork 4]\t  start eating 3 2024-01-15T00:32:39.176301800\n" + "2. Aristotle [Fork 1, Fork 2]\t finish eating 3 2024-01-15T00:32:39.178293900\n" + "2. Aristotle [Fork 1, Fork 2]\t  start thinking 2 2024-01-15T00:32:39.178293900\n" + "3. Aristotle [Fork 2, Fork 3]\t  start eating 2 2024-01-15T00:32:39.178293900\n" + "2. Aristotle [Fork 1, Fork 2]\t  finish thinking 2 2024-01-15T00:32:39.478496600\n" + "4. Aristotle [Fork 3, Fork 4]\t  finish thinking 2 2024-01-15T00:32:39.478496600\n" + "5. Aristotle [Fork 0, Fork 4]\t finish eating 3 2024-01-15T00:32:39.677536700\n" + "5. Aristotle [Fork 0, Fork 4]\t  start thinking 2 2024-01-15T00:32:39.677536700\n" + "3. Aristotle [Fork 2, Fork 3]\t finish eating 2 2024-01-15T00:32:39.678536600\n" + "3. Aristotle [Fork 2, Fork 3]\t  start thinking 1 2024-01-15T00:32:39.678536600\n" + "2. Aristotle [Fork 1, Fork 2]\t  start eating 2 2024-01-15T00:32:39.678536600\n" + "4. Aristotle [Fork 3, Fork 4]\t  start eating 2 2024-01-15T00:32:39.678536600\n" + "5. Aristotle [Fork 0, Fork 4]\t  finish thinking 2 2024-01-15T00:32:39.977728\n" + "3. Aristotle [Fork 2, Fork 3]\t  finish thinking 1 2024-01-15T00:32:39.978725\n" + "4. Aristotle [Fork 3, Fork 4]\t finish eating 2 2024-01-15T00:32:40.178928400\n" + "2. Aristotle [Fork 1, Fork 2]\t finish eating 2 2024-01-15T00:32:40.178928400\n" + "4. Aristotle [Fork 3, Fork 4]\t  start thinking 1 2024-01-15T00:32:40.178928400\n" + "1. Aristotle [Fork 0, Fork 1]\t  start eating 2 2024-01-15T00:32:40.178928400\n" + "3. Aristotle [Fork 2, Fork 3]\t  start eating 1 2024-01-15T00:32:40.178928400\n" + "2. Aristotle [Fork 1, Fork 2]\t  start thinking 1 2024-01-15T00:32:40.178928400\n" + "4. Aristotle [Fork 3, Fork 4]\t  finish thinking 1 2024-01-15T00:32:40.481254100\n" + "2. Aristotle [Fork 1, Fork 2]\t  finish thinking 1 2024-01-15T00:32:40.481254100\n" + "1. Aristotle [Fork 0, Fork 1]\t finish eating 2 2024-01-15T00:32:40.679516600\n" + "5. Aristotle [Fork 0, Fork 4]\t  start eating 2 2024-01-15T00:32:40.679516600\n" + "1. Aristotle [Fork 0, Fork 1]\t  start thinking 1 2024-01-15T00:32:40.679516600\n" + "3. Aristotle [Fork 2, Fork 3]\t finish eating 1 2024-01-15T00:32:40.681509700\n" + "2. Aristotle [Fork 1, Fork 2]\t  start eating 1 2024-01-15T00:32:40.681509700\n" + "3. Aristotle [Fork 2, Fork 3]\t  start thinking 0 2024-01-15T00:32:40.681509700\n" + "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 1 2024-01-15T00:32:40.980494900\n" + "3. Aristotle [Fork 2, Fork 3]\t  finish thinking 0 2024-01-15T00:32:40.982495500\n" + "5. Aristotle [Fork 0, Fork 4]\t finish eating 2 2024-01-15T00:32:41.180761500\n" + "5. Aristotle [Fork 0, Fork 4]\t  start thinking 1 2024-01-15T00:32:41.180761500\n" + "4. Aristotle [Fork 3, Fork 4]\t  start eating 1 2024-01-15T00:32:41.180761500\n" + "2. Aristotle [Fork 1, Fork 2]\t finish eating 1 2024-01-15T00:32:41.181761200\n" + "2. Aristotle [Fork 1, Fork 2]\t  start thinking 0 2024-01-15T00:32:41.181761200\n" + "1. Aristotle [Fork 0, Fork 1]\t  start eating 1 2024-01-15T00:32:41.181761200\n" + "5. Aristotle [Fork 0, Fork 4]\t  finish thinking 1 2024-01-15T00:32:41.482951800\n" + "2. Aristotle [Fork 1, Fork 2]\t  finish thinking 0 2024-01-15T00:32:41.489950600\n" + "4. Aristotle [Fork 3, Fork 4]\t finish eating 1 2024-01-15T00:32:41.683074700\n" + "4. Aristotle [Fork 3, Fork 4]\t  start thinking 0 2024-01-15T00:32:41.683074700\n" + "1. Aristotle [Fork 0, Fork 1]\t finish eating 1 2024-01-15T00:32:41.696071400\n" + "1. Aristotle [Fork 0, Fork 1]\t  start thinking 0 2024-01-15T00:32:41.696071400\n" + "5. Aristotle [Fork 0, Fork 4]\t  start eating 1 2024-01-15T00:32:41.696071400\n" + "4. Aristotle [Fork 3, Fork 4]\t  finish thinking 0 2024-01-15T00:32:41.985524400\n" + "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 0 2024-01-15T00:32:42.010523900\n" + "5. Aristotle [Fork 0, Fork 4]\t finish eating 1 2024-01-15T00:32:42.201600800\n" + "5. Aristotle [Fork 0, Fork 4]\t  start thinking 0 2024-01-15T00:32:42.201600800\n" + "5. Aristotle [Fork 0, Fork 4]\t  finish thinking 0 2024-01-15T00:32:42.513399400";
        String data3 = "2. Plato [Fork 1, Fork 2]\t  start eating 3 2024-01-16T03:24:29.885766300\n" + "4. Confucius [Fork 3, Fork 4]\t  start eating 3 2024-01-16T03:24:29.885766300\n" + "4. Confucius [Fork 3, Fork 4]\t finish eating 3 2024-01-16T03:24:30.395110800\n" + "2. Plato [Fork 1, Fork 2]\t finish eating 3 2024-01-16T03:24:30.395110800\n" + "1. Aristotle [Fork 0, Fork 1]\t  start eating 3 2024-01-16T03:24:30.396108200\n" + "3. Socrates [Fork 2, Fork 3]\t  start eating 3 2024-01-16T03:24:30.396108200\n" + "4. Confucius [Fork 3, Fork 4]\t  start thinking 2 2024-01-16T03:24:30.396108200\n" + "2. Plato [Fork 1, Fork 2]\t  start thinking 2 2024-01-16T03:24:30.396108200\n" + "1. Aristotle [Fork 0, Fork 1]\t finish eating 3 2024-01-16T03:24:30.898270300\n" + "1. Aristotle [Fork 0, Fork 1]\t  start thinking 2 2024-01-16T03:24:30.898270300\n" + "3. Socrates [Fork 2, Fork 3]\t finish eating 3 2024-01-16T03:24:30.898270300\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  start eating 3 2024-01-16T03:24:30.898270300\n" + "2. Plato [Fork 1, Fork 2]\t  finish thinking 2 2024-01-16T03:24:30.898270300\n" + "4. Confucius [Fork 3, Fork 4]\t  finish thinking 2 2024-01-16T03:24:30.898270300\n" + "3. Socrates [Fork 2, Fork 3]\t  start thinking 2 2024-01-16T03:24:30.898270300\n" + "2. Plato [Fork 1, Fork 2]\t  start eating 2 2024-01-16T03:24:30.898270300\n" + "2. Plato [Fork 1, Fork 2]\t finish eating 2 2024-01-16T03:24:31.399150900\n" + "3. Socrates [Fork 2, Fork 3]\t  finish thinking 2 2024-01-16T03:24:31.399150900\n" + "2. Plato [Fork 1, Fork 2]\t  start thinking 1 2024-01-16T03:24:31.399150900\n" + "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 2 2024-01-16T03:24:31.408150600\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t finish eating 3 2024-01-16T03:24:31.408150600\n" + "1. Aristotle [Fork 0, Fork 1]\t  start eating 2 2024-01-16T03:24:31.408150600\n" + "4. Confucius [Fork 3, Fork 4]\t  start eating 2 2024-01-16T03:24:31.408150600\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  start thinking 2 2024-01-16T03:24:31.408150600\n" + "2. Plato [Fork 1, Fork 2]\t  finish thinking 1 2024-01-16T03:24:31.900078400\n" + "4. Confucius [Fork 3, Fork 4]\t finish eating 2 2024-01-16T03:24:31.910075400\n" + "1. Aristotle [Fork 0, Fork 1]\t finish eating 2 2024-01-16T03:24:31.910075400\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  finish thinking 2 2024-01-16T03:24:31.910075400\n" + "3. Socrates [Fork 2, Fork 3]\t  start eating 2 2024-01-16T03:24:31.910075400\n" + "1. Aristotle [Fork 0, Fork 1]\t  start thinking 1 2024-01-16T03:24:31.910075400\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  start eating 2 2024-01-16T03:24:31.910075400\n" + "4. Confucius [Fork 3, Fork 4]\t  start thinking 1 2024-01-16T03:24:31.910075400\n" + "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 1 2024-01-16T03:24:32.411218600\n" + "4. Confucius [Fork 3, Fork 4]\t  finish thinking 1 2024-01-16T03:24:32.411218600\n" + "3. Socrates [Fork 2, Fork 3]\t finish eating 2 2024-01-16T03:24:32.411218600\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t finish eating 2 2024-01-16T03:24:32.411218600\n" + "3. Socrates [Fork 2, Fork 3]\t  start thinking 1 2024-01-16T03:24:32.412220700\n" + "4. Confucius [Fork 3, Fork 4]\t  start eating 1 2024-01-16T03:24:32.412220700\n" + "2. Plato [Fork 1, Fork 2]\t  start eating 1 2024-01-16T03:24:32.412220700\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  start thinking 1 2024-01-16T03:24:32.412220700\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  finish thinking 1 2024-01-16T03:24:32.912882600\n" + "2. Plato [Fork 1, Fork 2]\t finish eating 1 2024-01-16T03:24:32.912882600\n" + "2. Plato [Fork 1, Fork 2]\t  start thinking 0 2024-01-16T03:24:32.912882600\n" + "1. Aristotle [Fork 0, Fork 1]\t  start eating 1 2024-01-16T03:24:32.912882600\n" + "3. Socrates [Fork 2, Fork 3]\t  finish thinking 1 2024-01-16T03:24:32.919882100\n" + "4. Confucius [Fork 3, Fork 4]\t finish eating 1 2024-01-16T03:24:32.919882100\n" + "4. Confucius [Fork 3, Fork 4]\t  start thinking 0 2024-01-16T03:24:32.919882100\n" + "3. Socrates [Fork 2, Fork 3]\t  start eating 1 2024-01-16T03:24:32.919882100\n" + "2. Plato [Fork 1, Fork 2]\t  finish thinking 0 2024-01-16T03:24:33.413955900\n" + "1. Aristotle [Fork 0, Fork 1]\t finish eating 1 2024-01-16T03:24:33.413955900\n" + "1. Aristotle [Fork 0, Fork 1]\t  start thinking 0 2024-01-16T03:24:33.413955900\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  start eating 1 2024-01-16T03:24:33.413955900\n" + "3. Socrates [Fork 2, Fork 3]\t finish eating 1 2024-01-16T03:24:33.421951800\n" + "4. Confucius [Fork 3, Fork 4]\t  finish thinking 0 2024-01-16T03:24:33.421951800\n" + "3. Socrates [Fork 2, Fork 3]\t  start thinking 0 2024-01-16T03:24:33.421951800\n" + "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 0 2024-01-16T03:24:33.923922100\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t finish eating 1 2024-01-16T03:24:33.923922100\n" + "3. Socrates [Fork 2, Fork 3]\t  finish thinking 0 2024-01-16T03:24:33.923922100\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  start thinking 0 2024-01-16T03:24:33.923922100\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  finish thinking 0 2024-01-16T03:24:34.435444600";
        String data2 = "4. Aristotle [Fork 3, Fork 4]\t  start eating 3 2024-01-16T03:14:54.824407600\n" + "4. Aristotle [Fork 3, Fork 4]\t finish eating 3 2024-01-16T03:14:55.331948600\n" + "3. Aristotle [Fork 2, Fork 3]\t  start eating 3 2024-01-16T03:14:55.331948600\n" + "5. Aristotle [Fork 0, Fork 4]\t  start eating 3 2024-01-16T03:14:55.332949\n" + "4. Aristotle [Fork 3, Fork 4]\t  start thinking 2 2024-01-16T03:14:55.331948600\n" + "3. Aristotle [Fork 2, Fork 3]\t finish eating 3 2024-01-16T03:14:55.833736300\n" + "3. Aristotle [Fork 2, Fork 3]\t  start thinking 2 2024-01-16T03:14:55.833736300\n" + "2. Aristotle [Fork 1, Fork 2]\t  start eating 3 2024-01-16T03:14:55.833736300\n" + "5. Aristotle [Fork 0, Fork 4]\t finish eating 3 2024-01-16T03:14:55.833736300\n" + "5. Aristotle [Fork 0, Fork 4]\t  start thinking 2 2024-01-16T03:14:55.833736300\n" + "4. Aristotle [Fork 3, Fork 4]\t  finish thinking 2 2024-01-16T03:14:55.833736300\n" + "4. Aristotle [Fork 3, Fork 4]\t  start eating 2 2024-01-16T03:14:55.833736300\n" + "4. Aristotle [Fork 3, Fork 4]\t finish eating 2 2024-01-16T03:14:56.335859\n" + "5. Aristotle [Fork 0, Fork 4]\t  finish thinking 2 2024-01-16T03:14:56.335859\n" + "4. Aristotle [Fork 3, Fork 4]\t  start thinking 1 2024-01-16T03:14:56.335859\n" + "2. Aristotle [Fork 1, Fork 2]\t finish eating 3 2024-01-16T03:14:56.347864800\n" + "2. Aristotle [Fork 1, Fork 2]\t  start thinking 2 2024-01-16T03:14:56.347864800\n" + "1. Aristotle [Fork 0, Fork 1]\t  start eating 3 2024-01-16T03:14:56.347864800\n" + "3. Aristotle [Fork 2, Fork 3]\t  finish thinking 2 2024-01-16T03:14:56.347864800\n" + "3. Aristotle [Fork 2, Fork 3]\t  start eating 2 2024-01-16T03:14:56.347864800\n" + "4. Aristotle [Fork 3, Fork 4]\t  finish thinking 1 2024-01-16T03:14:56.836198700\n" + "2. Aristotle [Fork 1, Fork 2]\t  finish thinking 2 2024-01-16T03:14:56.848199400\n" + "1. Aristotle [Fork 0, Fork 1]\t finish eating 3 2024-01-16T03:14:56.848199400\n" + "5. Aristotle [Fork 0, Fork 4]\t  start eating 2 2024-01-16T03:14:56.848199400\n" + "1. Aristotle [Fork 0, Fork 1]\t  start thinking 2 2024-01-16T03:14:56.848199400\n" + "3. Aristotle [Fork 2, Fork 3]\t finish eating 2 2024-01-16T03:14:56.850198700\n" + "2. Aristotle [Fork 1, Fork 2]\t  start eating 2 2024-01-16T03:14:56.850198700\n" + "3. Aristotle [Fork 2, Fork 3]\t  start thinking 1 2024-01-16T03:14:56.850198700\n" + "5. Aristotle [Fork 0, Fork 4]\t finish eating 2 2024-01-16T03:14:57.350533200\n" + "5. Aristotle [Fork 0, Fork 4]\t  start thinking 1 2024-01-16T03:14:57.350533200\n" + "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 2 2024-01-16T03:14:57.350533200\n" + "4. Aristotle [Fork 3, Fork 4]\t  start eating 1 2024-01-16T03:14:57.350533200\n" + "3. Aristotle [Fork 2, Fork 3]\t  finish thinking 1 2024-01-16T03:14:57.351533500\n" + "2. Aristotle [Fork 1, Fork 2]\t finish eating 2 2024-01-16T03:14:57.351533500\n" + "2. Aristotle [Fork 1, Fork 2]\t  start thinking 1 2024-01-16T03:14:57.352531100\n" + "1. Aristotle [Fork 0, Fork 1]\t  start eating 2 2024-01-16T03:14:57.352531100\n" + "5. Aristotle [Fork 0, Fork 4]\t  finish thinking 1 2024-01-16T03:14:57.851249400\n" + "4. Aristotle [Fork 3, Fork 4]\t finish eating 1 2024-01-16T03:14:57.852248300\n" + "4. Aristotle [Fork 3, Fork 4]\t  start thinking 0 2024-01-16T03:14:57.852248300\n" + "3. Aristotle [Fork 2, Fork 3]\t  start eating 1 2024-01-16T03:14:57.852248300\n" + "1. Aristotle [Fork 0, Fork 1]\t finish eating 2 2024-01-16T03:14:57.853260\n" + "2. Aristotle [Fork 1, Fork 2]\t  finish thinking 1 2024-01-16T03:14:57.853260\n" + "1. Aristotle [Fork 0, Fork 1]\t  start thinking 1 2024-01-16T03:14:57.853260\n" + "5. Aristotle [Fork 0, Fork 4]\t  start eating 1 2024-01-16T03:14:57.853260\n" + "4. Aristotle [Fork 3, Fork 4]\t  finish thinking 0 2024-01-16T03:14:58.353300500\n" + "3. Aristotle [Fork 2, Fork 3]\t finish eating 1 2024-01-16T03:14:58.353300500\n" + "2. Aristotle [Fork 1, Fork 2]\t  start eating 1 2024-01-16T03:14:58.354301100\n" + "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 1 2024-01-16T03:14:58.354301100\n" + "3. Aristotle [Fork 2, Fork 3]\t  start thinking 0 2024-01-16T03:14:58.353300500\n" + "5. Aristotle [Fork 0, Fork 4]\t finish eating 1 2024-01-16T03:14:58.354301100\n" + "5. Aristotle [Fork 0, Fork 4]\t  start thinking 0 2024-01-16T03:14:58.354301100\n" + "3. Aristotle [Fork 2, Fork 3]\t  finish thinking 0 2024-01-16T03:14:58.854826900\n" + "5. Aristotle [Fork 0, Fork 4]\t  finish thinking 0 2024-01-16T03:14:58.856827800\n" + "2. Aristotle [Fork 1, Fork 2]\t finish eating 1 2024-01-16T03:14:58.863828100\n" + "2. Aristotle [Fork 1, Fork 2]\t  start thinking 0 2024-01-16T03:14:58.863828100\n" + "1. Aristotle [Fork 0, Fork 1]\t  start eating 1 2024-01-16T03:14:58.863828100\n" + "2. Aristotle [Fork 1, Fork 2]\t  finish thinking 0 2024-01-16T03:14:59.374206200\n" + "1. Aristotle [Fork 0, Fork 1]\t finish eating 1 2024-01-16T03:14:59.374206200\n" + "1. Aristotle [Fork 0, Fork 1]\t  start thinking 0 2024-01-16T03:14:59.374206200\n" + "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 0 2024-01-16T03:14:59.883885600";
        String data0 = "1. Aristotle [Fork 0, Fork 1]\t  start eating 3 2024-01-14T20:11:59.477935700\n" + "3. Socrates [Fork 2, Fork 3]\t  start eating 3 2024-01-14T20:11:59.477935700\n" + "3. Socrates [Fork 2, Fork 3]\t finish eating 3 2024-01-14T20:12:01.486705700\n" + "1. Aristotle [Fork 0, Fork 1]\t finish eating 3 2024-01-14T20:12:01.486705700\n" + "4. Confucius [Fork 3, Fork 4]\t  start eating 3 2024-01-14T20:12:01.487702900\n" + "3. Socrates [Fork 2, Fork 3]\t  start thinking 2 2024-01-14T20:12:01.487702900\n" + "2. Plato [Fork 1, Fork 2]\t  start eating 3 2024-01-14T20:12:01.487702900\n" + "1. Aristotle [Fork 0, Fork 1]\t  start thinking 2 2024-01-14T20:12:01.487702900\n" + "4. Confucius [Fork 3, Fork 4]\t finish eating 3 2024-01-14T20:12:03.488529100\n" + "4. Confucius [Fork 3, Fork 4]\t  start thinking 2 2024-01-14T20:12:03.488529100\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  start eating 3 2024-01-14T20:12:03.488529100\n" + "2. Plato [Fork 1, Fork 2]\t finish eating 3 2024-01-14T20:12:03.489528700\n" + "2. Plato [Fork 1, Fork 2]\t  start thinking 2 2024-01-14T20:12:03.489528700\n" + "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 2 2024-01-14T20:12:04.489326400\n" + "3. Socrates [Fork 2, Fork 3]\t  finish thinking 2 2024-01-14T20:12:04.489326400\n" + "3. Socrates [Fork 2, Fork 3]\t  start eating 2 2024-01-14T20:12:04.489326400\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t finish eating 3 2024-01-14T20:12:05.504957900\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  start thinking 2 2024-01-14T20:12:05.504957900\n" + "1. Aristotle [Fork 0, Fork 1]\t  start eating 2 2024-01-14T20:12:05.504957900\n" + "3. Socrates [Fork 2, Fork 3]\t finish eating 2 2024-01-14T20:12:06.490677900\n" + "3. Socrates [Fork 2, Fork 3]\t  start thinking 1 2024-01-14T20:12:06.490677900\n" + "4. Confucius [Fork 3, Fork 4]\t  finish thinking 2 2024-01-14T20:12:06.493085300\n" + "2. Plato [Fork 1, Fork 2]\t  finish thinking 2 2024-01-14T20:12:06.493085300\n" + "4. Confucius [Fork 3, Fork 4]\t  start eating 2 2024-01-14T20:12:06.493085300\n" + "1. Aristotle [Fork 0, Fork 1]\t finish eating 2 2024-01-14T20:12:07.511679400\n" + "1. Aristotle [Fork 0, Fork 1]\t  start thinking 1 2024-01-14T20:12:07.511679400\n" + "2. Plato [Fork 1, Fork 2]\t  start eating 2 2024-01-14T20:12:07.511679400\n" + "4. Confucius [Fork 3, Fork 4]\t finish eating 2 2024-01-14T20:12:08.494517900\n" + "4. Confucius [Fork 3, Fork 4]\t  start thinking 1 2024-01-14T20:12:08.494517900\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  finish thinking 2 2024-01-14T20:12:08.512828900\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  start eating 2 2024-01-14T20:12:08.512828900\n" + "3. Socrates [Fork 2, Fork 3]\t  finish thinking 1 2024-01-14T20:12:09.498036300\n" + "2. Plato [Fork 1, Fork 2]\t finish eating 2 2024-01-14T20:12:09.513574500\n" + "2. Plato [Fork 1, Fork 2]\t  start thinking 1 2024-01-14T20:12:09.513574500\n" + "3. Socrates [Fork 2, Fork 3]\t  start eating 1 2024-01-14T20:12:09.513574500\n" + "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 1 2024-01-14T20:12:10.513180200\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t finish eating 2 2024-01-14T20:12:10.515180200\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  start thinking 1 2024-01-14T20:12:10.515180200\n" + "1. Aristotle [Fork 0, Fork 1]\t  start eating 1 2024-01-14T20:12:10.515180200\n" + "4. Confucius [Fork 3, Fork 4]\t  finish thinking 1 2024-01-14T20:12:11.509456600\n" + "3. Socrates [Fork 2, Fork 3]\t finish eating 1 2024-01-14T20:12:11.524963700\n" + "3. Socrates [Fork 2, Fork 3]\t  start thinking 0 2024-01-14T20:12:11.524963700\n" + "4. Confucius [Fork 3, Fork 4]\t  start eating 1 2024-01-14T20:12:11.524963700\n" + "1. Aristotle [Fork 0, Fork 1]\t finish eating 1 2024-01-14T20:12:12.527664700\n" + "2. Plato [Fork 1, Fork 2]\t  finish thinking 1 2024-01-14T20:12:12.527664700\n" + "1. Aristotle [Fork 0, Fork 1]\t  start thinking 0 2024-01-14T20:12:12.527664700\n" + "2. Plato [Fork 1, Fork 2]\t  start eating 1 2024-01-14T20:12:12.527664700\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  finish thinking 1 2024-01-14T20:12:13.522872100\n" + "4. Confucius [Fork 3, Fork 4]\t finish eating 1 2024-01-14T20:12:13.538885100\n" + "4. Confucius [Fork 3, Fork 4]\t  start thinking 0 2024-01-14T20:12:13.538885100\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  start eating 1 2024-01-14T20:12:13.538885100\n" + "2. Plato [Fork 1, Fork 2]\t finish eating 1 2024-01-14T20:12:14.535595\n" + "3. Socrates [Fork 2, Fork 3]\t  finish thinking 0 2024-01-14T20:12:14.535595\n" + "2. Plato [Fork 1, Fork 2]\t  start thinking 0 2024-01-14T20:12:14.535595\n" + "1. Aristotle [Fork 0, Fork 1]\t  finish thinking 0 2024-01-14T20:12:15.538622400\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t finish eating 1 2024-01-14T20:12:15.553628900\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  start thinking 0 2024-01-14T20:12:15.553628900\n" + "4. Confucius [Fork 3, Fork 4]\t  finish thinking 0 2024-01-14T20:12:16.539456600\n" + "2. Plato [Fork 1, Fork 2]\t  finish thinking 0 2024-01-14T20:12:17.542158800\n" + "5. Immanuel Kant [Fork 0, Fork 4]\t  finish thinking 0 2024-01-14T20:12:18.559764700";
        List<State> stateList = new ArrayList<>();
        Scanner scanner = new Scanner(data3);
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
        int scale = 30000000;
        List<List<State>> byNumbers = new ArrayList<>();
        byNumbers.add(stateList.stream().filter(x -> x.number.equals("1")).sorted().toList());
        byNumbers.add(stateList.stream().filter(x -> x.number.equals("2")).sorted().toList());
        byNumbers.add(stateList.stream().filter(x -> x.number.equals("3")).sorted().toList());
        byNumbers.add(stateList.stream().filter(x -> x.number.equals("4")).sorted().toList());
        byNumbers.add(stateList.stream().filter(x -> x.number.equals("5")).sorted().toList());
                for (int d = 1; d < dinner.size() + 1; d++) {
            LocalDateTime momentOfDinner = start;
            Action doing = Action.WAITING;
            for (State s : stateList) {
                if (s.number.equals(String.valueOf(d))) {
                    int before = (int) Duration.between(momentOfDinner, s.time).getNano()/scale;

                    for (int i = 0; i < before; i++) {
                        dinner.get(d - 1).append(doing == Action.EATING ? "+" : doing == Action.THINKING ? "." : "_");
                    }
                    if (s.start) doing = s.action;
                    else doing = Action.WAITING;
                    momentOfDinner = s.time;

                }
            }
        }
//        for (int d = 0; d < byNumbers.size(); d++) {
//            System.out.println(byNumbers.get(d));
//            LocalDateTime momentOfDinner = start;
//            Action doing = Action.WAITING;
//            for (State s : byNumbers.get(d)) {
//                int before = (int) Math.abs(Duration.between(s.time, momentOfDinner).toNanos()) / scale;
//                for (int i = 0; i < before; i++) {
//                    dinner.get(d).append(doing == Action.EATING ? "+" : doing == Action.THINKING ? "." : "_");
//                }
//                if (s.start) doing = s.action;
//                else doing = Action.WAITING;
//                momentOfDinner = s.time;
//            }
//        }

        dinner.forEach(System.out::println);
    }


}