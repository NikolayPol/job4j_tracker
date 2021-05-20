package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class JobDescByNameTest {

    @Test
    public void compare() {
        List<Job> jobsActual = new ArrayList<>();
        Collections.addAll(jobsActual,
                new Job("Job2", 2),
                new Job("Job3", 1),
                new Job("Job1", 3)
        );
        List<Job> jobsExpected = new ArrayList<>();
        Collections.addAll(jobsExpected,
                jobsActual.get(1),
                jobsActual.get(0),
                jobsActual.get(2)
        );
        jobsActual.sort(new JobDescByName());
        assertEquals(jobsActual, jobsExpected);
    }
}