package ru.job4j.oop;

public class Main {
    public static void main(String[] args) {
        Vehicle airplane = new Airplane();
        Vehicle bus = new Bus();
        Vehicle train = new Train();

        Vehicle[] arr = {airplane, bus, train};
        for (Vehicle i: arr) {
            i.move();
        }
    }
}
