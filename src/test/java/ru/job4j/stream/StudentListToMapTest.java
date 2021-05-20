package ru.job4j.stream;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;

public class StudentListToMapTest {

    @Test
    public void studentListToMapTest() {
        List<Student> students = List.of(
                new Student(90, "Ivanov"),
                new Student(90, "Ivanov"),
                new Student(90, "Ivanov"),
                new Student(60, "Petrov"),
                new Student(40, "Aleksandrov"),
                new Student(80, "Dmitriev")
        );
        StudentListToMap studentListToMap = new StudentListToMap();
        Map<String, Student> actual = studentListToMap.listToMap(students);
        Map<String, Student> explicit = Map.of(
                "Ivanov", new Student(90, "Ivanov"),
                "Dmitriev", new Student(80, "Dmitriev"),
                "Petrov", new Student(60, "Petrov"),
                "Aleksandrov", new Student(40, "Aleksandrov")
        );
        assertEquals(actual, explicit);
    }
}