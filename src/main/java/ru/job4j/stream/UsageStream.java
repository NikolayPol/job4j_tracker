package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;

public class UsageStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(-1, -2, -3, 4, 5));
        list = list.stream().filter(x -> x > 0).collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
