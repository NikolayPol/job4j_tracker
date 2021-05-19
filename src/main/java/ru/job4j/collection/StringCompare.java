package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char[] leftArr = left.toCharArray();
        char[] rightArr = right.toCharArray();
        int leftArrLength = leftArr.length;
        int rightArrLength = rightArr.length;
        for (int i = 0; i < Math.min(leftArrLength, rightArrLength); i++) {
            if (leftArr[i] > rightArr[i]) {
                return 1;
            }
            if (leftArr[i] < rightArr[i]) {
                return -1;
            }
        }
        if (leftArrLength < rightArrLength) {
            return -1;
        } else if (leftArrLength > rightArrLength) {
            return 1;
        }
        return 0;
    }
}