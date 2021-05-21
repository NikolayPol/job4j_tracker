package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority =
                new JobByName().thenComparing(new JobByPriority());
        List<Job> jobsActual = new ArrayList<>();
        Collections.addAll(jobsActual,
                new Job("Job2", 2),
                new Job("Job2", 1),
                new Job("Job1", 3)
        );
        List<Job> jobsExpected = new ArrayList<>();
        Collections.addAll(jobsExpected,
                jobsActual.get(2),
                jobsActual.get(1),
                jobsActual.get(0)
        );
        jobsActual.sort(cmpNamePriority);
        assertEquals(jobsActual, jobsExpected);
    }

    @Test
    public void whenCompatorByNameAndDescPrority() {
        Comparator<Job> cmpNameDescPriority =
                new JobByName().thenComparing(new JobDescByPriority());
        List<Job> jobsActual = new ArrayList<>();
        Collections.addAll(jobsActual,
                new Job("Job2", 2),
                new Job("Job2", 1),
                new Job("Job1", 3)
        );
        List<Job> jobsExpected = new ArrayList<>();
        Collections.addAll(jobsExpected,
                jobsActual.get(2),
                jobsActual.get(0),
                jobsActual.get(1)
        );
        jobsActual.sort(cmpNameDescPriority);
        assertEquals(jobsActual, jobsExpected);
    }

    @Test
    public void whenCompatorByDescNameAndPrority() {
        Comparator<Job> cmpDescNamePriority =
                new JobDescByName().thenComparing(new JobByPriority());
        List<Job> jobsActual = new ArrayList<>();
        Collections.addAll(jobsActual,
                new Job("Job2", 2),
                new Job("Job2", 1),
                new Job("Job1", 3)
        );
        List<Job> jobsExpected = new ArrayList<>();
        Collections.addAll(jobsExpected,
                jobsActual.get(1),
                jobsActual.get(0),
                jobsActual.get(2)
        );
        jobsActual.sort(cmpDescNamePriority);
        assertEquals(jobsActual, jobsExpected);
    }

    @Test
    public void whenCompatorByDescNameAndDescPrority() {
        Comparator<Job> cmpDescNameDescPriority =
                new JobDescByName().thenComparing(new JobDescByPriority());
        List<Job> jobsActual = new ArrayList<>();
        Collections.addAll(jobsActual,
                new Job("Job2", 2),
                new Job("Job2", 1),
                new Job("Job1", 3)
        );
        List<Job> jobsExpected = new ArrayList<>();
        Collections.addAll(jobsExpected,
                jobsActual.get(0),
                jobsActual.get(1),
                jobsActual.get(2)
        );
        jobsActual.sort(cmpDescNameDescPriority);
        assertEquals(jobsActual, jobsExpected);
    }
}