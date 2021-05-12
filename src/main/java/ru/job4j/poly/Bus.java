package ru.job4j.poly;

public class Bus implements Transport {
    private int passengers;

    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void setPassenger(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public float toRefuel(int litresOfFuel) {
        float price = 1; // цена литра топлива
        return price * litresOfFuel;
    }
}
