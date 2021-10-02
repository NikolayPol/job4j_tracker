package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Класс DeleteActionTest тестирует класс DeleteAction
 * с использованием библиотеки Mockito.
 *
 * @author Nikolay Polegaev
 * @version 1.0 19.09.2021
 */

public class DeleteActionTest {
    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Deleted item"));

        DeleteAction del = new DeleteAction(out);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);

        del.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Delete item ====" + ln
        + "Заявка удалена успешно." + ln));
        assertThat(tracker.findAll(), is(new ArrayList<>()));
    }
}