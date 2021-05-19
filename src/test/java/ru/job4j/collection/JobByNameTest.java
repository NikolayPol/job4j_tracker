package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class JobByNameTest {

    @Test
    public void compare() {
        List<Job> jobsActual = new ArrayList<>();
        Collections.addAll(jobsActual,
                new Job("Job2", 2),
                new Job("Job3", 1),
                new Job("Job1", 3)
        );
        Collections.sort(jobsActual, new JobByName());
        System.out.println(jobsActual);
        List<Job> jobsExpected = new ArrayList<>();
        Collections.addAll(jobsExpected,
                new Job("Job1", 3),
                new Job("Job2", 2),
                new Job("Job3", 1)
        );
        assertEquals(jobsActual.toString(), jobsExpected.toString());
    }
}