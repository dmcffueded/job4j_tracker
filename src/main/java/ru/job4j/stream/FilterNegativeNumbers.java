package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 100, 0, -1, -123, 0, 55, 20, -90);
        List<Integer> positive = numbers.stream().filter(number -> number > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}