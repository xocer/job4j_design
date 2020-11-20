package ru.job4j.searcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;

public class SearchSupport {
    private final String[] keys;

    public SearchSupport(String[] keys) {
        if (keys.length < 6) {
            throw new NoSuchElementException("Не хватает параметров для поиска и записи файлов");
        }
        this.keys = keys;
    }

    public String getRule() {
        return keys[4];
    }

    public String getFileName() {
        return keys[3];
    }

    public Path getPath() throws IOException {
        Path tmp = Paths.get(keys[1]);
        if (!Files.isDirectory(tmp)) {
            throw new IOException("Путь не является директорией");
        }
        return tmp;
    }

    public String getOutputFileName() {
        return keys[6];
    }
}
