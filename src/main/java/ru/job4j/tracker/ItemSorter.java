package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(10, "Create"),
                new Item(40, "Update"),
                new Item(30, "Show"),
                new Item(20, "Delete")
                );
        System.out.println(items);
        Collections.sort(items);
        System.out.println(items);
        Collections.sort(items, new SortByNameItemReverse());
        System.out.println(items);
        Collections.sort(items, new SortByNameItem());
        System.out.println(items);
    }
}
