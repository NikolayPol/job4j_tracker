package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Класс ReplaceActionTest тестирует класс ReplaceAction.
 * Создаем mock-объект для Input.
 * Настраиваем заглушку.
 * when(input.askInt(any(String.class))).thenReturn(1);
 * when(input.askStr(any(String.class))).thenReturn(replacedName);
 * При запуске теста, когда выполнение кода дойдет до этих строк
 * и потребует параметра от объекта input - поскольку мы уже настроили нашу "заглушку",
 * то при вызове метода askInt() заглушка вернет значение 1,
 * а вызов метода askStr() вернет из заглушки значение replacedName.
 * Поскольку методы askInt() и askStr() принимают строки в качестве параметров
 * нам их нужно и передавать - для того чтобы не писать саму строку мы просто подменяем
 * ее вызовом метода any() в котором указываем класс, которому принадлежит передаваемый параметр.
 * Следующей строкой в тесте будет вызов метода, который мы тестируем
 * и в который мы передаем необходимые параметры: rep.execute(input, tracker);
 * И последними строками мы будем писать значения с которыми сравниваем,
 * т.е. проверяем работоспособность нашего кода.
 * out.toString() - объект ReplaceAction изменил его внутренне состояние.
 *
 * @author Nikolay Polegaev
 * @version 1.0 22.09.2021
 */
public class ReplaceActionTest {
    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        when(input.askStr(any(String.class))).thenReturn(replacedName);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Edit item ====" + ln
                + "Заявка изменена успешно." + ln));
        assertThat(tracker.findAll().get(0).getName(), is(replacedName));
    }
}