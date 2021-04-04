package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        String ls = System.lineSeparator();
        return "{" + ls +
                "name" + ":" + "name" + "," + ls +
                "body" + ":" + "body" + ls +
               "}";
    }
}
