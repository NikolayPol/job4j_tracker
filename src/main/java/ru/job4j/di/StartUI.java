package ru.job4j.di;

import org.springframework.stereotype.Component;

/**
 * Класс StartUI
 * StartUI зависит от класса Store.
 * Если класс отмечен аннотацией @Component,
 * то Spring регистрирует этот класс в контексте.
 *
 * @author Nikolay Polegaev
 * @version 1.0 21.11.2021
 */
@Component
public class StartUI {

    private Store store;

    public StartUI(Store store) {
        this.store = store;
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }
}
