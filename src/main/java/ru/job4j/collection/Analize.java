package ru.job4j.collection;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {

        if (previous.size() == 0 || current.size() == 0) {
            throw new NoSuchElementException();
        }

        int added = 0;
        int changed = 0;
        int deleted = 0;
        User prev;
        User curr;

        for (int i = 0; i < previous.size(); i++) {
            prev = previous.get(i);
            for (int j = 0; j < current.size(); j++) {
                curr = current.get(j);

                if (current.contains(prev)) {
                    break;
                }

                if (prev.id == curr.id && !prev.equals(curr)) {
                    changed++;
                    break;
                }

                if (j == current.size() - 1) {
                    deleted++;
                }
            }
        }

        for (int i = 0; i < current.size(); i++) {
            curr = current.get(i);
            if (!previous.contains(curr)) {
                added++;
            }
        }

        return new Info(added - changed, changed, deleted);
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id &&
                    Objects.equals(name, user.name);
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
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Info info = (Info) o;
            return added == info.added &&
                    changed == info.changed &&
                    deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }

        @Override
        public String toString() {
            return "Info{" +
                    "added=" + added +
                    ", changed=" + changed +
                    ", deleted=" + deleted +
                    '}';
        }
    }

}
