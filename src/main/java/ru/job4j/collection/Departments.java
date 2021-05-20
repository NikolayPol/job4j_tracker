package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>();
        Set<String> tmp = new LinkedHashSet<>();
        String start;
        for (String dep : deps) {
            start = "";
            for (String el : dep.split("/")) {
                if (start.equals("")) {
                    start += el;
                } else {
                    start += "/" + el;
                }
                tmp.add(start);
            }
        }
        rsl.addAll(tmp);
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
        System.out.println(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
        System.out.println(orgs);
    }
}
