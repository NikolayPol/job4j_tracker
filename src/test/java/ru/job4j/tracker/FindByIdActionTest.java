package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Класс FindByIdActionTest тестирует класс FindByIdAction
 *  * с использованием библиотеки Mockito.
 *
 * @author Nikolay Polegaev
 * @version 1.0 22.09.2021
 */
public class FindByIdActionTest {
    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Finded item");
        tracker.add(item);
        FindByIdAction f = new FindByIdAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        f.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by id ====" + ln
                + item + ln));
        assertThat(tracker.findAll(), is(List.of(item)));
    }
}