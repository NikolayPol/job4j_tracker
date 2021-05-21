package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FlatMapTest {
    @Test
    public void matrixToListTest() {
        Integer[][] matrix = new Integer[][]{
                {1, 2, 3}, {4, 5, 6}
        };
        List<Integer> explicit = List.of(1, 2, 3, 4, 5, 6);
        FlatMap flatMap = new FlatMap();
        List<Integer> actual = flatMap.matrixToList(matrix);
        assertEquals(actual, explicit);
    }

}