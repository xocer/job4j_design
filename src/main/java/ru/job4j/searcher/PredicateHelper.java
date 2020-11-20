package ru.job4j.searcher;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class PredicateHelper {
    private String rule;
    private String fileName;
    private Predicate<Path> predicate;

    public PredicateHelper(String rule, String fileName) {
        this.rule = rule;
        this.fileName = fileName;
    }

    public Predicate<Path> getPredicate() {
        switch (rule) {
            case "-m":
                predicate = p -> p.toFile().getName().endsWith(fileName);
                return predicate;
            case "-f":
                predicate = p -> p.toFile().getName().equals(fileName);
                return predicate;
            case "-r":
                Pattern pattern = Pattern.compile(fileName);
                predicate = p -> pattern.matcher(p.toString()).find();
                return predicate;
            default:
                System.out.println("Вы задали не правильна формат для поиска файла.");
                return predicate;
        }
    }
}
