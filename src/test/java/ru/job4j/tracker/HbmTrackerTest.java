package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

/**
 * Класс HbmTrackerTest тестирует класс HbmTracker.
 * Это интеграционное тестирование с Hibernate.
 * Файл конфигурации Hibernate находится в test/resources.
 * Используется зависимость hsqldb.
 *
 * @author Nikolay Polegaev
 * @version 1.0 21.11.2021
 */
public class HbmTrackerTest {

    @Test
        public void whenAddAndReplace() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("name");
        tracker.add(item);
        int id = item.getId();
        Item newItem = new Item("newName");
        tracker.replace(id, newItem);
        assertThat(tracker.findById(id).getName(), is("newName"));
    }

    @Test
    public void whenAddAndDelete() {
        HbmTracker tracker = new HbmTracker();
        Item deleteName = new Item("deleteName");
        int id = deleteName.getId();
        tracker.add(deleteName);
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenAddAndFindAll() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item("name1"));
        tracker.add(new Item("name2"));
        tracker.add(new Item("name3"));
        List<Item> findAll = tracker.findAll();
        assertThat(findAll.size(), is(3));
        assertThat(findAll.get(0).getName(), is("name1"));
        assertThat(findAll.get(1).getName(), is("name2"));
        assertThat(findAll.get(2).getName(), is("name3"));
    }

    @Test
    public void whenAddAndFindByName() {
        HbmTracker tracker = new HbmTracker();
        tracker.add(new Item("findByName"));
        List<Item> items = tracker.findByName("findByName");
        assertThat(items.get(0).getName(), is("findByName"));
    }

    @Test
    public void whenAddAndFindById() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("findById");
        tracker.add(item);
        Item byId = tracker.findById(item.getId());
        assertThat(byId.getName(), is("findById"));
    }
}