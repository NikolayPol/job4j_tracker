package ru.job4j.profession;

import javax.xml.crypto.Data;

public class Doctor extends Profession {
    private String license;

    public Doctor(String name, String surname, String education, Data birthday, String license) {
        super(name, surname, education, birthday);
        this.license = license;
    }

    public void heal() {

    }
}
