package ru.job4j.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> source;

    public EasyStream(List<Integer> source) {
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
        source = list;
        return new EasyStream(list);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        if (fun == null) {
            throw new UnsupportedOperationException();
        }
        List<Integer> list = new ArrayList<>();
        int j = 0;
        Integer el;
        for (Integer integer : source) {
            el = integer;
            if (fun.test(el)) {
                list.add(j, el);
                j++;
            }
        }
        source = list;
        return new EasyStream(list);

    }

    public List<Integer> collect() {
        if (source == null) {
            throw new UnsupportedOperationException();
        }
        return List.copyOf(source);
    }
}
