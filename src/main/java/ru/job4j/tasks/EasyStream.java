package ru.job4j.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> source;

    private EasyStream(List<Integer> source) {
        this.source = source;
    }

    public static EasyStream of(List<Integer> source) {
        if (source == null) {
            throw new UnsupportedOperationException();
        }
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        if (fun == null) {
            throw new UnsupportedOperationException();
        }
        List<Integer> list = new ArrayList<>(source);
        for (int i = 0; i < source.size(); i++) {
            list.set(i, fun.apply(list.get(i)));
        }
        return new EasyStream(list);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        if (fun == null) {
            throw new UnsupportedOperationException();
        }
        List<Integer> list = new ArrayList<>();
        Integer el;
        for (Integer integer : source) {
            el = integer;
            if (fun.test(el)) {
                list.add(el);
            }
        }
        return new EasyStream(list);
    }

    public List<Integer> collect() {
        if (source == null) {
            throw new UnsupportedOperationException();
        }
        return List.copyOf(source);
    }
}
