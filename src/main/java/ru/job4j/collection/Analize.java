package ru.job4j.collection;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int added = 0;
        int changed = 0;
        int deleted;

        if (previous.size() == 0 || current.size() == 0) {
            throw new NoSuchElementException();
        }
        Map<Integer, String> users = previous.stream()
                .collect(Collectors
                        .toMap(User::getId, User::getName));
        for (int i = 0; i < current.size(); i++) {
            int id = current.get(i).getId();
            if (!users.containsKey(id)) {
                added++;
            } else {
                if (!users.get(id).equals(current.get(i).getName())) {
                    changed++;
                }
            }
        }
        deleted = previous.size() + added - current.size();

        return new Info(added, changed, deleted);
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        private int added;
        private int changed;
        private int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }

        @Override
        public String toString() {
            return "Info{"
                    + "added=" + added
                    + ", changed=" + changed
                    + ", deleted=" + deleted
                    + '}';
        }
    }

    public static void main(String[] args) {
        List<User> previos = List.of(new User(1, "Вася"),
                new User(2, "Петя"),
                new User(3, "Игнат"),
                new User(4, "Максим"));
        List<User> current = List.of(new User(1, "Вася"),
                new User(2, "Даша"),
                new User(15, "Саша"),
                new User(19, "Володя"));

        Analize analize = new Analize();
        Info info = analize.diff(previos, current);
        System.out.println(info);
    }

}
