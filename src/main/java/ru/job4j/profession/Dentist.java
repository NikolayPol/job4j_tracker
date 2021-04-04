package ru.job4j.profession;

import javax.xml.crypto.Data;

public class Dentist extends Doctor {
    private String hospital;

    public Dentist(String name, String surname, String education, Data birthday,
                   String license, String hospital) {
        super(name, surname, education, birthday, license);
        this.hospital = hospital;
    }

    public void makeDiagnostics() {

    }
}
