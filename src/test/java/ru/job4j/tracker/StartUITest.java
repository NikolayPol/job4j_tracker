//package ru.job4j.tracker;
//
//import org.junit.Test;
//
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.nullValue;
//import static org.junit.Assert.*;
//
//public class StartUITest {
//    @Test
//    public void whenExit() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"0"}
//        );
//        Store tracker = new SqlTracker();
//        UserAction[] actions = {
//                new ExitAction(out)
//        };
//        String ln = System.lineSeparator();
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                "Menu." + ln
//                        + "0. Exit" + ln
//        ));
//    }
//
//    @Test
//    public void testCreateItem() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"0", "Item name", "1"}
//        );
//        Store tracker = new SqlTracker();
//        UserAction[] actions = {
//                new CreateAction(out),
//                new ExitAction(out)
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
//    }
//
//    @Test
//    public void testReplaceItem() {
//        Output out = new StubOutput();
//        Store tracker = new SqlTracker();
//        Item item = tracker.add(new Item("Replaced item"));
//        String replacedName = "New item name";
//        Input in = new StubInput(
//                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
//        );
//        UserAction[] actions = {
//                new ReplaceAction(out),
//                new ExitAction(out)
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
//
//    }
//
//    @Test
//    public void testDeteleItem() {
//        Output out = new StubOutput();
//        Store tracker = new SqlTracker();
//        Item item = tracker.add(new Item("Deleted item"));
//        Input in = new StubInput(
//                new String[]{"0", String.valueOf(item.getId()), "1"}
//        );
//        UserAction[] actions = {
//                new DeleteAction(out),
//                new ExitAction(out)
//        };
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()), is(nullValue()));
//
//    }
//
//    @Test
//    public void testShowAllAction() {
//        Output out = new StubOutput();
//        Store tracker = new SqlTracker();
//        Item item = tracker.add(new Item("New item"));
//        Input in = new StubInput(
//                new String[]{"0", "1"}
//        );
//        UserAction[] actions = {
//                new ShowAllAction(out),
//                new ExitAction(out)
//        };
//        new StartUI(out).init(in, tracker, actions);
//        String ln = System.lineSeparator();
//        assertThat(out.toString(), is(
//                "Menu." + ln
//                        + "0. Show all items" + ln
//                        + "1. Exit" + ln
//                        + "=== Show all items ====" + ln
//                        + item + ln
//                        + "Menu." + ln
//                        + "0. Show all items" + ln
//                        + "1. Exit" + ln
//        ));
//
//    }
//
//    @Test
//    public void testFindByIdAction() {
//        Output out = new StubOutput();
//        Store tracker = new SqlTracker();
//        Item item = tracker.add(new Item("New item"));
//        Input in = new StubInput(
//                new String[]{"0", "1", "1"}
//        );
//        UserAction[] actions = {
//                new FindByIdAction(out),
//                new ExitAction(out)
//        };
//        String ln = System.lineSeparator();
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                "Menu." + ln
//                        + "0. Find item by id" + ln
//                        + "1. Exit" + ln
//                        + "=== Find item by id ====" + ln
//                        + item + ln
//                        + "Menu." + ln
//                        + "0. Find item by id" + ln
//                        + "1. Exit" + ln
//        ));
//
//    }
//
//    @Test
//    public void testFindByNameAction() {
//        Output out = new StubOutput();
//        Store tracker = new SqlTracker();
//        Item item = tracker.add(new Item("New item"));
//        Input in = new StubInput(
//                new String[]{"0", "New item", "1"}
//        );
//        UserAction[] actions = {
//                new FindByNameAction(out),
//                new ExitAction(out)
//        };
//        String ln = System.lineSeparator();
//        new StartUI(out).init(in, tracker, actions);
//        assertThat(out.toString(), is(
//                "Menu." + ln
//                        + "0. Find item by name" + ln
//                        + "1. Exit" + ln
//                        + "=== Find items by name ====" + ln
//                        + item + ln
//                        + "Menu." + ln
//                        + "0. Find item by name" + ln
//                        + "1. Exit" + ln
//        ));
//    }
//
//    @Test
//    public void whenInvalidExit() {
//        Output out = new StubOutput();
//        Input in = new StubInput(
//                new String[]{"10", "0"}
//        );
//        Store tracker = new SqlTracker();
//        UserAction[] actions = new UserAction[]{
//                new ExitAction(out)
//        };
//        new StartUI(out).init(in, tracker, actions);
//        String ln = System.lineSeparator();
//        assertThat(out.toString(), is(
//                "Menu." + ln
//                        + "0. Exit" + ln
//                        + "Wrong input, you can select: 0 .. 0" + ln
//                        + "Menu." + ln
//                        + "0. Exit" + ln
//                )
//        );
//    }
//}