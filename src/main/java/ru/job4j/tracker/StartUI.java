package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
создаем объект класса Item
на этом объекте вызываем геттер и получаем объект LocalDateTime
выбираем паттерн форматирования DateTimeFormatter
форматируем
результат выводим в строку
*/

public class StartUI {
    public static void main(String[] args) {
        Item itm = new Item();
        LocalDateTime currentDateTime = itm.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
    }
}