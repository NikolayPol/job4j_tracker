package ru.job4j.tracker;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
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
        List<Item> expectedActual = new ArrayList<>(itemsActual);
        Collections.sort(itemsActual, new SortByNameItem());
        assertEquals(itemsActual.get(0), expectedActual.get(0));
        assertEquals(itemsActual.get(1), expectedActual.get(2));
        assertEquals(itemsActual.get(2), expectedActual.get(3));
        assertEquals(itemsActual.get(3), expectedActual.get(1));
    }
    @Test
    public void whenCompareIdReverse() {
        List<Item> itemsActual = Arrays.asList(
                new Item(10, "Create"),
                new Item(40, "Update"),
                new Item(20, "Show"),
                new Item(30, "Delete")
        );
        List<Item> expectedActual = new ArrayList<>(itemsActual);
        Collections.sort(itemsActual, new SortByNameItemReverse());
        assertEquals(itemsActual.get(3), expectedActual.get(0));
        assertEquals(itemsActual.get(0), expectedActual.get(1));
        assertEquals(itemsActual.get(2), expectedActual.get(2));
        assertEquals(itemsActual.get(1), expectedActual.get(3));
    }
}