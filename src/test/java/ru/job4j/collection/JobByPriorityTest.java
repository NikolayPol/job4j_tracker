package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.LongBinaryOperator;

import static org.junit.Assert.*;

public class JobByPriorityTest {

    @Test
    public void compare() {
        List<Job> jobsActual = new ArrayList<>();
        Collections.addAll(jobsActual,
                new Job("Job2", 2),
                new Job("Job3", 3),
                new Job("Job1", 1)
        );
        Collections.sort(jobsActual, new JobByPriority());
        List<Job> jobsExpected = new ArrayList<>();
        Collections.addAll(jobsExpected,
                new Job("Job1", 1),
                new Job("Job2", 2),
                new Job("Job3", 3)
        );
        assertEquals(jobsActual.toString(), jobsExpected.toString());
    }
}