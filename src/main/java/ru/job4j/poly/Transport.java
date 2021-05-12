package ru.job4j.poly;

public interface Transport {
    void drive();

    void setPassenger(int passengers);

    float toRefuel(int litresOfFuel);
}
