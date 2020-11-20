package ru.job4j.searcher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;

public class SearchFilesByCriterion {
    public static void main(String[] args) throws IOException {
        SearchSupport support = new SearchSupport(args);
        PredicateHelper helper = new PredicateHelper(support.getRule(), support.getFileName());
        Predicate<Path> predicate = helper.getPredicate();
        FileHelper fileHelper = new FileHelper(predicate);
        Files.walkFileTree(support.getPath(), fileHelper);
        fileHelper.writeFiles(support.getOutputFileName());
    }
}
