package ru.job4j.searcher;

import java.io.IOException;
import java.nio.file.Files;

public class SearchFilesByCriterion {
    public static void main(String[] args) throws IOException {
        FileHelper fileHelper = new FileHelper(args);
        Files.walkFileTree(fileHelper.getSourse(), fileHelper);
        fileHelper.writeFiles();
    }
}
