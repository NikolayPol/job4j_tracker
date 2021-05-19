package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ItemSorterTest {

    @Test
    public void whenCompareId() {
        List<Item> itemsActual = Arrays.asList(
                new Item(10, "Create"),
                new Item(40, "Update"),
                new Item(20, "Show"),
                new Item(30, "Delete")
        );
        List<Item> expectedActual = new ArrayList<>();
        Collections.addAll(expectedActual,
                itemsActual.get(0),
                itemsActual.get(2),
                itemsActual.get(3),
                itemsActual.get(1)
                );
        itemsActual.sort(new SortByNameItem());
        assertEquals(itemsActual, expectedActual);
    }

    @Test
    public void whenCompareIdReverse() {
        List<Item> itemsActual = Arrays.asList(
                new Item(10, "Create"),
                new Item(40, "Update"),
                new Item(20, "Show"),
                new Item(30, "Delete")
        );
        List<Item> expectedActual = new ArrayList<>();
        Collections.addAll(expectedActual,
                itemsActual.get(1),
                itemsActual.get(3),
                itemsActual.get(2),
                itemsActual.get(0)
        );
        itemsActual.sort(new SortByNameItemReverse());
        assertEquals(itemsActual, expectedActual);
    }
}