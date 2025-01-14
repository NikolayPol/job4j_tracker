package ru.job4j.lambda;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare " + left + " with " + right);
            return Integer.compare(args.length, right.length());
        };
    }
}
