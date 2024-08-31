package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Задай вопрос, на которой я смогут ответить \"да\" или \"нет\": ");
        String name = input.nextLine();
        int answer = new Random().nextInt(3);
        switch (answer) {
            case 0 -> System.out.println("Ответ на вопрос \"" + name + "\": \"Да\"");
            case 1 -> System.out.println("Ответ на вопрос \"" + name + "\": \"Нет\"");
            default -> System.out.println("Ответ на вопрос \"" + name + "\": \"Может быть\"");
        }
    }
}