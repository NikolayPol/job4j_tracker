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
        jobsActual.sort(cmpNamePriority);
        System.out.println(jobsActual);
        List<Job> jobsExpected = new ArrayList<>();
        Collections.addAll(jobsExpected,
                new Job("Job1", 3),
                new Job("Job2", 1),
                new Job("Job2", 2)
        );
        assertEquals(jobsActual.toString(), jobsExpected.toString());
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
        jobsActual.sort(cmpNameDescPriority);
        System.out.println(jobsActual);
        List<Job> jobsExpected = new ArrayList<>();
        Collections.addAll(jobsExpected,
                new Job("Job1", 3),
                new Job("Job2", 2),
                new Job("Job2", 1)
        );
        assertEquals(jobsActual.toString(), jobsExpected.toString());
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
        jobsActual.sort(cmpDescNamePriority);
        System.out.println(jobsActual);
        List<Job> jobsExpected = new ArrayList<>();
        Collections.addAll(jobsExpected,
                new Job("Job2", 1),
                new Job("Job2", 2),
                new Job("Job1", 3)
        );
        assertEquals(jobsActual.toString(), jobsExpected.toString());
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
        jobsActual.sort(cmpDescNameDescPriority);
        System.out.println(jobsActual);
        List<Job> jobsExpected = new ArrayList<>();
        Collections.addAll(jobsExpected,
                new Job("Job2", 2),
                new Job("Job2", 1),
                new Job("Job1", 3)
        );
        assertEquals(jobsActual.toString(), jobsExpected.toString());
    }
}