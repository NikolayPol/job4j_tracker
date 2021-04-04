package ru.job4j.profession;

import javax.xml.crypto.Data;

public class Engineer extends Profession {
    private String diplom;

    public Engineer(String name, String surname, String education, Data birthday, String diplom) {
        super(name, surname, education, birthday);
        this.diplom = diplom;
    }

    public void makeJob() {

    }
}
