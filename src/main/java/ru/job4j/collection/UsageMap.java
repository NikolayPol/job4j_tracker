package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("123@ya.ru", "Parfiriy Ivanovich Stepancsov");
        for (String key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
