package ru.job4j.di;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Store
 *
 * @author Nikolay Polegaev
 * @version 1.0 21.11.2021
 */
public class Store {
    private List<String> data = new ArrayList<>();

    public void add(String value) {
        data.add(value);
    }

    public List<String> getAll() {
        return data;
    }
}