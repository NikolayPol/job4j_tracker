package ru.job4j.profession;

import javax.xml.crypto.Data;

public class Builder extends Engineer {
    private String diplom;

    public Builder(String name, String surname, String education, Data birthday,
                   String diplom, String diplom1) {
        super(name, surname, education, birthday, diplom);
        this.diplom = diplom1;
    }

    public void drawing() {

    }
}
