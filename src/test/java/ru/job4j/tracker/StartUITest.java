//package ru.job4j.tracker;
//
//import junit.framework.TestCase;
//
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.nullValue;
//import static org.junit.Assert.*;
//
//public class StartUITest extends TestCase {
//
//    public void testCreateItem() {
//        Input in = new StubInput(
//                new String[] {"0", "Item name", "1"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(),
//                new ExitAction()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name"));
//    }
//
//    public void testReplaceItem() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("Replaced item"));
//        String replacedName = "New item name";
//        Input in = new StubInput(
//                new String[] {"0", "1", "New item name", "1"}
//        );
//        UserAction[] actions = {
//                new ReplaceAction(),
//                new ExitAction()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
//
//    }
//
//    public void testDeteleItem() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("Deleted item"));
//        Input in = new StubInput(
//                new String[] {"0", "1", "1"}
//        );
//        UserAction[] actions = {
//                new DeleteAction(),
//                new ExitAction()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()), is(nullValue()));
//    }
//}