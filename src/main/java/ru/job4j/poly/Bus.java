package ru.job4j.poly;

public class Bus implements Transport {
    private int passengers;

    @Override
    public void drive() {
        System.out.println("Bus is driving");
    }

    @Override
    public void setPassenger(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public float toRefuel(int litresOfFuel) {
        float price = 1;
        return price * litresOfFuel;
    }
}
