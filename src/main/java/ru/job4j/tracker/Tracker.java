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
        return Arrays.copyOf(items, items.length);
    }

    public Item[] findByName(String key) {
        Item[] names = new Item[items.length];
        int k = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(key)) {
                names[i] = items[i];
                k++;
            }
        }
        return Arrays.copyOf(items, k);
    }

    public Item findById(int id) {
        int index = indexOf(id);
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
        item.setId(id);
        boolean rsl = index != -1;
        if (rsl) {
            items[index] = item;
        }
        return rsl;
    }

    public boolean delete(int id) {
        int start = indexOf(id);
        boolean rsl = start != -1;
        if (rsl) {
            items[start] = null;
            System.arraycopy(items, start + 1, items, start, size - start - 1);
            items[size - 1] = null;
            size--;
        }
        return rsl;

    }
}