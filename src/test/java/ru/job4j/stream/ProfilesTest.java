package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenCollectProfileAdress() {
        List<Profile> clients = List.of(
                new Profile(new Address("London", "45", 10, 20)),
                new Profile(new Address("London", "45", 10, 20)),
                new Profile(new Address("London", "45", 10, 20)),
                new Profile(new Address("Oslo", "56", 5, 50)),
                new Profile(new Address("London", "45", 10, 30)),
                new Profile(new Address("London", "67", 7, 100))
        );
        List<Address> explicit = List.of(
                new Address("London", "45", 10, 20),
                new Address("London", "45", 10, 30),
                new Address("London", "67", 7, 100),
                new Address("Oslo", "56", 5, 50)
        );
        Profiles profiles = new Profiles();
        List<Address> actual = profiles.collect(clients);
        assertEquals(actual, explicit);
    }
}