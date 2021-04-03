package ru.job4j.profession;

import javax.xml.crypto.Data;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private Data birthday;


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public Data getBirthday() {
        return birthday;
    }
}
