package ru.job4j.tracker;

/**
 * Интерфейс Observe
 *
 * @author Nikolay Polegaev
 * @version 1.0 07.01.2022
 */
public interface Observe<T> {
    void receive(T model);
}
