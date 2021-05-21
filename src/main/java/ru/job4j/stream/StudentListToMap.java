package ru.job4j.stream;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentListToMap {
    public Map<String, Student> listToMap(List<Student> students) {
        return students.stream()
                .collect(
                        Collectors.toMap(
                                Student::getSurname,
                                (el) -> el,
                                (a, b) -> {
                                    Set<Student> set = new HashSet<>();
                                    set.add(a);
                                    return set.add(b) ? b : a;
                                }
                        ));
    }
}
