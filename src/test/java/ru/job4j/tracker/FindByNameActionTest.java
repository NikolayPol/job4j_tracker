package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Класс FindByNameActionTest тестирует класс FindByNameAction
 * с использованием библиотеки Mockito.
 *
 * @author Nikolay Polegaev
 * @version 1.0 22.09.2021
 */
public class FindByNameActionTest {
    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        String itemName = "Finded item";
        Item item = new Item(itemName);
        tracker.add(item);
        FindByNameAction f = new FindByNameAction(out);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(itemName);

        f.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ====" + ln
                + item + ln));
        assertThat(tracker.findAll(), is(List.of(item)));
    }
}