package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class JobDescByPriorityTest {

    @Test
    public void compare() {
        List<Job> jobsActual = new ArrayList<>();
        Collections.addAll(jobsActual,
                new Job("Job2", 2),
                new Job("Job3", 3),
                new Job("Job1", 1)
        );
        Collections.sort(jobsActual, new JobDescByPriority());
        List<Job> jobsExpected = new ArrayList<>();
        Collections.addAll(jobsExpected,
                new Job("Job3", 3),
                new Job("Job2", 2),
                new Job("Job1", 1)
        );
        assertEquals(jobsActual.toString(), jobsExpected.toString());
    }
}