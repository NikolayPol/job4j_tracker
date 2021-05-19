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
                    tmp.add(start);
                } else {
                    start += "/" + el;
                    tmp.add(start);
                }
                //System.out.println(tmp);
            }
        }
        rsl.addAll(tmp);
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
        System.out.println("---ASC---");
        System.out.println(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
        System.out.println("---DESC---");
        System.out.println(orgs);
    }

    public static void main(String[] args) {
        List<String> input = new ArrayList<>();
        Collections.addAll(input, "k1/sk1/ssk1", "k2/sk1/ssk1", "k2/sk1/ssk2",
                "k1/sk1/ssk2", "k2/sk1/ssk1", "k1/sk2", "k1/sk1");
        Departments.fillGaps(input);
        Departments.sortAsc(Departments.fillGaps(input));
        Departments.sortDesc(Departments.fillGaps(input));
    }
}
