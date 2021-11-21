package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Класс SpringDI - использует Dependency Injection от SpringFramework.
 * В context регистрируем классы и он отдает проинициализированные объекты.
 * Подключили зависимости spring-core, spring-beans, spring-context.
 * AnnotationConfigApplicationContext - класс из пакета org.springframework.
 *
 * Если класс отмечен аннотацией @Component, то Spring регистрирует этот класс в контексте.
 * Нужно просканировать директории для поиска компонентов context.scan("ru.job4j.di");
 *
 * @author Nikolay Polegaev
 * @version 1.0 21.11.2021
 */
public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.di");
        context.scan("ru.job4j.tracker");
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Petr Arsentev!");
        ui.add("Ivan Ivanov!");

        ui.print();
    }
}
