package ru.job4j.tasks;

import java.util.Collections;
import java.util.HashSet;
import java.util.regex.Pattern;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        Pattern p = Pattern.compile("[.,\\s!:;]");
        String[] originSplit = p.split(origin);
        String[] lineSplit = p.split(line);
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