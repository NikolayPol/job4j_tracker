package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.greaterThan;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "k2/sk1/ssk2",
                "k2/sk1/ssk1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "k2",
                "k2/sk1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore2() {
        int rsl = new DepDescComp().compare (
                "k2/sk1",
                "k2/sk1/sk2"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore3() {
        int rsl = new DepDescComp().compare (
                "k2",
                "k1"
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore4() {
        int rsl = new DepDescComp().compare (
                "k1/ssk2",
                "k1"
        );
        assertThat(rsl, greaterThan(0));
    }

}