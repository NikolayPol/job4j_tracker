package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int rsl = 0;
        int o1Length = o1.length();
        int o2Length = o2.length();
        for (int i = 0; i < Math.min(o1Length, o2Length); i++) {
            if (i == 1) {
                rsl = Integer.compare(o2.charAt(1), o1.charAt(1));
                if (rsl != 0) {
                    return rsl;
                }
            }
            rsl = o1.compareTo(o2);
        }
        return rsl;
    }
}