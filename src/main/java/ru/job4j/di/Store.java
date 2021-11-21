package ru.job4j.di;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Store.
 * Если класс отмечен аннотацией @Component,
 * то Spring регистрирует этот класс в контексте.
 *
 * @author Nikolay Polegaev
 * @version 1.0 21.11.2021
 */
@Component
public class Store {
    private List<String> data = new ArrayList<>();

    public void add(String value) {
        data.add(value);
    }

    public List<String> getAll() {
        return data;
    }
}
