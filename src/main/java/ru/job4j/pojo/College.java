package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFio("Parfiriy Petrovich Ivanov");
        student.setGroup(2);
        student.setData("01.09.1856");
        System.out.println(student.getFio());
        System.out.println(student.getGroup());
        System.out.println(student.getData());
    }
}
