package ru.job4j.pojo;

public class Book {
    private String name;
    private int kolStr;

    public Book(String name, int kolStr) {
        this.name = name;
        this.kolStr = kolStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKolStr() {
        return kolStr;
    }

    public void setKolStr(int kolStr) {
        this.kolStr = kolStr;
    }
}
