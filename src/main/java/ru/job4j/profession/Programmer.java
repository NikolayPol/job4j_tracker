package ru.job4j.profession;

import javax.xml.crypto.Data;

public class Programmer extends Engineer {
    private String whereAreYouSwitch;

    public Programmer(String name, String surname, String education,
                      Data birthday, String diplom, String whereAreYouSwitch) {
        super(name, surname, education, birthday, diplom);
        this.whereAreYouSwitch = whereAreYouSwitch;
    }

    public void makeCode() {

    }
}
