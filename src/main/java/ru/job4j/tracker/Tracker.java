package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int id = 1;

    public Item add(Item item) {
        item.setId(id++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    public List<Item> findByName(String key) {
        List<Item> names = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                names.add(item);
            }
        }
        return names;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
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
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int start = indexOf(id);
        boolean rsl = start != -1;
        if (rsl) {
            items.remove(start);
        }
        return rsl;

    }
}