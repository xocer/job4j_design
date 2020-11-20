package ru.job4j.searcher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FileHelper extends SimpleFileVisitor<Path> {
    private Predicate<Path> predicate;
    private List<Path> pathList = new ArrayList<>();

    public FileHelper(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    public void writeFiles(String output) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            for (Path tmp : pathList) {
                writer.write(tmp.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (predicate.test(file)) {
            pathList.add(file);
        }
        return FileVisitResult.CONTINUE;
    }
}
