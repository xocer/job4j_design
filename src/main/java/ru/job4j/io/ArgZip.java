package ru.job4j.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {

        Path path = Paths.get(args[1]);
        return Files.isDirectory(path);
    }

    public String directory() {
        if (!valid()) {
            System.out.println("Такой папки не существует");
            return null;
        }

        return args[1];
    }

    public String exclude() {
        return args[3];
    }

    public String output() {
        return args[5];
    }
}

