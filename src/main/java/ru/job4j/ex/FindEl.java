package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i] == key) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] value = {"test1", "test2"};
        String key1 = "test1";
        String key2 = "test3";
        try {
            indexOf(value, key1);
        } catch (ElementNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            indexOf(value, key2);
        } catch (ElementNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}