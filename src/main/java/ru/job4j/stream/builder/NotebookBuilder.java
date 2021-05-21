package ru.job4j.stream.builder;

public class NotebookBuilder {
    public static void main(String[] args) {
        Notebook notebook = new Notebook.Builder()
                .buildName("HP")
                .buildDisplay(15.0)
                .buildCpu("core i5")
                .buildMemory(512)
                .buildhard(1000)
                .build();
        System.out.println(notebook);
    }
}
