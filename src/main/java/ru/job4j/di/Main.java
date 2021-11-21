package ru.job4j.di;

import ru.job4j.tracker.ConsoleInput;

/**
 * Класс Main.
 * Используем Dependency Injection.
 *
 * @author Nikolay Polegaev
 * @version 1.0 21.11.2021
 */
public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(StartUI.class);
        context.reg(ConsoleInput.class);
        StartUI ui = context.get(StartUI.class);

        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
    }
}
