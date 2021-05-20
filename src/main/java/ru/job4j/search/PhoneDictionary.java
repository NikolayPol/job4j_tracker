package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> compare1 = person -> person.getName().contains(key);
        Predicate<Person> compare2 = person -> person.getSurname().contains(key);
        Predicate<Person> compare3 = person -> person.getPhone().contains(key);
        Predicate<Person> compare4 = person -> person.getAddress().contains(key);
        Predicate<Person> combine = compare1.or(compare2).or(compare3).or(compare4);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
