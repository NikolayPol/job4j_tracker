package ru.job4j.tasks;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = false;
        char[] leftSplit = left.toCharArray();
        char[] rightSplit = right.toCharArray();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int i = 1;
        for (char ch : leftSplit) {
            if (map1.containsKey(ch)) {
                i = map1.get(ch);
                i++;
            }
            map1.put(ch, i);
            i = 1;
        }
        for (char ch : rightSplit) {
            if (map2.containsKey(ch)) {
                i = map2.get(ch);
                i++;
            }
            map2.put(ch, i);
            i = 1;
        }
        if (map1.entrySet().equals(map2.entrySet())) {
            return true;
        }
        return rsl;
    }
}
