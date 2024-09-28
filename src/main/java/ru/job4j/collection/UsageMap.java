package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("name1@mail.ru", "Ivan Ivanov");
        map.put("name2@mail.ru", "Sergei Sergeev");
        map.put("name3@mail.ru", "Sergei Ivanov");
        map.put("name4@mail.ru", "Ivan Sergeev");
        map.put("name2@mail.ru", "Ivan Sergeev");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
