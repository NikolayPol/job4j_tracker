package ru.job4j.stream.builder;

import java.util.Objects;

public class Notebook {
    private String name;
    private double display;
    private String cpu;
    private int memory;
    private int hard;

    static class Builder {
        private String name;
        private Double display;
        private String cpu;
        private int memory;
        private int hard;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildDisplay(Double display) {
            this.display = display;
            return this;
        }

        Builder buildCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        Builder buildMemory(Integer memory) {
            this.memory = memory;
            return this;
        }

        Builder buildhard(Integer hard) {
            this.hard = hard;
            return this;
        }

        Notebook build() {
            Notebook notebook = new Notebook();
            notebook.name = name;
            notebook.display = display;
            notebook.cpu = cpu;
            notebook.memory = memory;
            notebook.hard = hard;
            return notebook;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Notebook notebook = (Notebook) o;
        return Double.compare(notebook.display, display) == 0
                && memory == notebook.memory
                && hard == notebook.hard
                && Objects.equals(name, notebook.name)
                && Objects.equals(cpu, notebook.cpu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, display, cpu, memory, hard);
    }

    @Override
    public String toString() {
        return "Notebook{"
                + "name='" + name + '\''
                + ", display=" + display
                + ", cpu='" + cpu + '\''
                + ", memory=" + memory
                + ", hard=" + hard
                + '}';
    }
}
