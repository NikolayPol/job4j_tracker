package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";

    }

    @Override
    public boolean execute(Input input, Store tracker) {
        boolean rsl = false;
        out.println("=== Show all items by react====");
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            rsl = true;
        } else {
            out.println("Хранилище еще не содержит заявок");
        }
        return rsl;
    }
}
