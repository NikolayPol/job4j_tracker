package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl;
        String[] o1Words = o1.split("/");
        String[] o2Words = o2.split("/");
        rsl = o2Words[0].compareTo(o1Words[0]);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}