package ru.job4j.function;

import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare " + left + " with " + right);
            return left.length() - right.length();
        };
    }
}
