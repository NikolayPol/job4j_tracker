package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item("statement");
        System.out.println("Дата создания: " + item.getCreated());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss");
        String currentDateTimeFormat = item.getCreated().format(formatter);
        System.out.println("Дата создания: " + currentDateTimeFormat);

        Tracker tracker = new Tracker();
        tracker.add(item);
        System.out.println(tracker.findById(1).getName());
    }
}
