package ru.job4j.condition;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class MaxTest {

    @Test
    public void when10and20then20() {
        int first = 10;
        int second = 20;
        int result = Max.max(first, second);
        Assert.assertEquals(result, 20);
    }

    @Test
    public void when10and20and30then30() {
        int first = 10;
        int second = 20;
        int third = 30;
        int result = Max.max(first, second, third);
        Assert.assertEquals(result, 30);
    }

    @Test
    public void when10and20and30and40then40() {
        int first = 10;
        int second = 20;
        int third = 30;
        int fourth = 40;
        int result = Max.max(first, second, third, fourth);
        Assert.assertEquals(result, 40);
    }
}