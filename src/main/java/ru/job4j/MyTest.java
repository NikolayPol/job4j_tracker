package ru.job4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyTest {
    public static void main(String[] args) {
//        List<Integer> arr = Arrays.asList(
//                new Integer(1),
//                new Integer(2),
//                new Integer(3)
//        );
//        System.out.println(arr);
//        arr.add(new Integer(4));
//        System.out.println(arr);

        List<Integer> arr2 = new ArrayList<>();
        Collections.addAll(arr2,
                new Integer(1),
                new Integer(2),
                new Integer(3)
        );
        System.out.println(arr2);
        Collections.addAll(arr2, new Integer(4));
        System.out.println(arr2);
    }
}
