package ru.job4j.di;

/**
 * Класс StartUI
 * StartUI зависит от класса Store.
 *
 * @author Nikolay Polegaev
 * @version 1.0 21.11.2021
 */
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
