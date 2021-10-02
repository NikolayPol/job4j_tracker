/**package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * + "alter sequence items_id_seq restart with 1;"))
 */
/**
public class SqlTrackerTest {
    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        item = tracker.add(item);
        Item expected = tracker.findById(item.getId());
        assertEquals(expected, item);
    }

    @Test
    public void whenSaveItemAndFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        item = tracker.add(item);
        List<Item> list = new ArrayList<>();
        list.add(item);
        assertThat(tracker.findByName(item.getName()), is(list));
    }

    @Test
    public void whenShowAllItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        Item item3 = new Item("item3");
        item1 = tracker.add(item1);
        item2 = tracker.add(item2);
        item3 = tracker.add(item3);
        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        assertThat(tracker.findAll(), is(list));
    }

    @Test
    public void whenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        item1 = tracker.add(item1);
        item2.setId(item1.getId());
        List<Item> list = new ArrayList<>();
        list.add(item2);
        assertTrue(tracker.replace(item1.getId(), item2));
        assertThat(tracker.findAll(), is(list));
    }

    @Test
    public void whenDelete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        item1 = tracker.add(item1);
        item2 = tracker.add(item2);
        List<Item> list = new ArrayList<>();
        list.add(item1);
        assertTrue(tracker.delete(item2.getId()));
        assertThat(tracker.findAll(), is(list));
    }

}
*/