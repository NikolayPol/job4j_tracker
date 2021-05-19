package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JobTest {
    /**
     Job1 - высокий приоритет имени Job1 > Job3
     Job3 - низкий приоритет имени
     1 - высокий приоритет 1 > 3
     3 - низкий приоритет

     JobByName - сортировка по возрастанию сначала по имени потом по возрастанию [Job{Job1, 3}, Job{Job2, 1}, Job{Job2, 2}]
     JobByDescName - сортировка по убыванию сначала по имени потом по убыванию [Job{Job1, 3}, Job{Job2, 2}, Job{Job2, 1}]
     JobByPriority - сортировка по возрастанию по приоритету потом по имени [Job{Job2, 1}, Job{Job2, 2}, Job{Job1, 3}]
     JobByDescPriority - сортировка по убыванию сначала по приоритету потом по имени [Job{Job2, 2}, Job{Job2, 1}, Job{Job1, 3}]
     */
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
        Collections.sort(jobsActual, cmpNamePriority);
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
        Collections.sort(jobsActual, cmpNameDescPriority);
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
        Collections.sort(jobsActual, cmpDescNamePriority);
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
        Collections.sort(jobsActual, cmpDescNameDescPriority);
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