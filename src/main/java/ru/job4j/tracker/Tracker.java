package ru.job4j.tracker;

/*
добавление заявок - public Item add(Item item);
получение списка всех заявок - public Item[] findAll();
public Item[] findAll() возвращает копию массива items без null элементов (без пустых ячеек);
получение списка по имени - public Item[] findByName(String key);
получение заявки по id - public Item findById(int id);
*/

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    private int indexOf(int id) {
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item != null && item.getId() == id) {
                return index;
            }
        }
        return -1;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean res = index != -1;
        if (res) {
            items[index] = item;
            item.setId(id);
        }
        return res;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
        }
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
                result[count] = item;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }
}