package ru.job4j.searcher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileHelper extends SimpleFileVisitor<Path> {
    private String[] keys;
    private Path sourse;
    private String output;
    private String fileName;
    private String searchRule;
    private List<Path> pathList = new ArrayList<>();

    public FileHelper(String[] keys) {
        if (keys.length > 6) {
            this.keys = keys;
            fileName = keys[3];
            searchRule = keys[4];
            output = keys[6];
        }
    }

    public Path getSourse() throws IOException {
        Path tmp = Paths.get(keys[1]);
        if (Files.isDirectory(tmp)) {
            sourse = tmp;
        } else {
            throw new IOException("Путь не является директорией");
        }
        return sourse;
    }

    private void checkFile(Path file) {
        switch (searchRule) {
            case "-m":
                if (file.toString().endsWith(fileName)) {
                    pathList.add(file);
                }
                break;
            case "-f":
                if (file.getFileName().toString().equals(fileName)) {
                    pathList.add(file);
                }
                break;
            case "-r":
                String tmp = file.toString();
                if (tmp.matches(fileName)) {
                    pathList.add(file);
                }
                break;
            default:
                System.out.println("Вы задали не правильна формат для поиска файла.");
        }
    }

    public void writeFiles() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            for (Path tmp : pathList) {
                writer.write(tmp.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        checkFile(file);
        return FileVisitResult.CONTINUE;
    }
}
