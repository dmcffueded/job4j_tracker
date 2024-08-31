package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            int matches = 0;
            boolean validInput = false;
            while (!validInput) {
                System.out.println(player + ", введите число от 1 до 3:");
                matches = Integer.parseInt(input.nextLine());
                if (matches < 1 || matches > 3) {
                    System.out.println("Некорректный ввод! Нужно ввести число от 1 до 3.");
                } else if (matches > count) {
                    System.out.println("Вы не можете взять больше оставшихся спичек. Осталось " + count + " спичек.");
                } else {
                    validInput = true;
                }
            }
            count -= matches;
            System.out.println("Осталось " + count + " спичек.");
            turn = !turn;
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}