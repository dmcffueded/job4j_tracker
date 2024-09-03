package ru.job4j.cast;

import java.util.Arrays;

public class Port {
    public static void main(String[] args) {
        Vehicle aircraft1 = new Aircraft();
        Vehicle aircraft2 = new Aircraft();
        Vehicle train1 = new Train();
        Vehicle train2 = new Train();
        Vehicle bus1 = new Bus();
        Vehicle bus2 = new Bus();
        Vehicle[] vehicles = {aircraft1, aircraft2, train1, train2, bus1, bus2};
        for (Vehicle o : vehicles) {
            System.out.println(o);
            o.move();
        }
    }
}
