package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<String, FileProperty> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String name = file.toFile().getName();
        FileProperty tmp = new FileProperty(file.toFile().length(), name);
        if (files.containsKey(name)) {
            if (files.get(name).equals(tmp)) {
                System.out.println("Найден дубликат! Файл " + tmp);
            } else {
                files.put(name, tmp);
            }

        } else {
            files.put(name, tmp);
        }
        return FileVisitResult.CONTINUE;
    }
}
