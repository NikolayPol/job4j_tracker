package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int id = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(id++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] names = Arrays.copyOf(items, items.length);
        return items;
    }

    public Item[] findByName(String key) {
        Item[] names = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(key)) {
                names[i] = items[i];
            }
        }
        return items;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        item.setId(items[index].getId());
        items[index] = item;
    return items[indexOf(id)] == item;
    }
}