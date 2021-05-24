package ru.job4j.tasks;

import java.util.Collections;
import java.util.HashSet;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] originSplit = origin.replaceAll("\\p{Punct}", " ").split(" ");
        String[] lineSplit = line.replaceAll("\\p{Punct}", " ").split(" ");
        HashSet<String> set = new HashSet<>();
        Collections.addAll(set, originSplit);
        for (String ch : lineSplit) {
            if (!set.contains(ch)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}