package ru.job4j.profession;

import javax.xml.crypto.Data;

public class Surgeon extends Doctor {

    public Surgeon(String name, String surname, String education, Data birthday, String license) {
        super(name, surname, education, birthday, license);
    }

    public void makeOperation() {

    }
}
