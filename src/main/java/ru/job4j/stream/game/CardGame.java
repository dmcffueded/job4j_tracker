package ru.job4j.stream.game;

import java.util.stream.Stream;

public class CardGame {
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(value1 -> Stream.of(Value.values())
                        .map(value2 -> value1 + " " + value2))
                .forEach(System.out::println);
    }
}