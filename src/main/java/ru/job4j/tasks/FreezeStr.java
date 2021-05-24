package ru.job4j.tasks;

import java.util.HashMap;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = false;
        char[] leftSplit = left.toCharArray();
        char[] rightSplit = right.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 1;
        for (char ch : leftSplit) {
            if (map.containsKey(ch)) {
                i = map.get(ch);
                i++;
            }
            map.put(ch, i);
            i = 1;
        }
        for (char ch : rightSplit) {
            if (!map.containsKey(ch)) {
                rsl = false;
            }
            if (map.containsKey(ch) && map.get(ch) == 1) {
                map.remove(ch);
            }
            if (map.containsKey(ch) && map.get(ch) > 1) {
                map.replace(ch, map.get(ch) - 1);
            }
        }
        if (map.isEmpty()) {
            rsl = true;
        }
        return rsl;
    }
}
