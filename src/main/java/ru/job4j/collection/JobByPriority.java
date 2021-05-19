package ru.job4j.collection;

import java.util.Comparator;

public class JobByPriority implements Comparator<Job> {
    @Override
    public int compare(Job o1, Job o2) {
        if (o1.getPriority() > o2.getPriority()) {
            return 1;
        }
        if (o1.getPriority() < o2.getPriority()) {
            return -1;
        }
        return 0;
    }
}
