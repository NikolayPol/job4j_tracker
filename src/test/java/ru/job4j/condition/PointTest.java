package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {
    @Test
    public void testDistance3d() {
        Point point = new Point(1, 1, 2);
        Point point0 = new Point(0, 0, 0);
        double result = point.distance3d(point0);
        Assert.assertEquals(result, 2.449, 0.01);
    }
}