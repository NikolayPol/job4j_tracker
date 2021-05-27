package ru.job4j.stream;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(), Stream.of(pupil)
                                                            .flatMap(p -> p.getSubjects().stream())
                                                            .mapToInt(Subject::getScore)
                                                            .average()
                                                            .orElse(0D)
                                       ))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                                               LinkedHashMap::new,
                                               Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(el -> new Tuple(el.getKey(), el.getValue()))
                .collect(Collectors.toList());

    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(),
                                        Stream.of(pupil)
                                                .flatMap(p -> p.getSubjects().stream())
                                                .mapToInt(Subject::getScore)
                                                .sum()))
                                                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("student", 0));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        //HashMap::new,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(el -> new Tuple(el.getKey(), el.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("student", 0));
    }
}