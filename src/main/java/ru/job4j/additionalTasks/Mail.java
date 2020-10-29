package ru.job4j.additionalTasks;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mail {

    public static class User {
        private String name;
        private Set<String> mail;

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", mail=" + mail +
                    '}';
        }

        public User(String name, Set<String> eMail) {
            this.name = name;
            this.mail = eMail;
        }

        public String getName() {
            return name;
        }

        public void setMail(Set<String> mail) {
            this.mail = mail;
        }

        public Set<String> getMail() {
            return mail;
        }
    }

    public List<User> mergerMail(List<User> users) {
        if (users != null) {
            for (int i = 0; i < users.size(); i++) {
                for (int j = i + 1; j < users.size(); j++) {
                    Set<String> one = users.get(i).getMail();
                    Set<String> two = users.get(j).getMail();
                    if (!Collections.disjoint(one, two)) {
                        users.get(i).setMail(Stream.concat(one.stream(), two.stream()).collect(Collectors.toSet()));
                        users.remove(j--);
                    }
                }
            }
        }
        return users;
    }

    public static void main(String[] args) {
        User user1 = new User("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        User user2 = new User("user2", Set.of("foo@gmail.com", "ups@pisem.net"));
        User user3 = new User("user3", Set.of("xyz@pisem.net", "vasya@pupkin.com"));
        User user4 = new User("user4", Set.of("ups@pisem.net", "aaa@bbb.ru"));
        User user5 = new User("user5", Set.of("xyz@pisem.net"));

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        Mail mail = new Mail();
        List<User> array = mail.mergerMail(list);
        for (User s :
                array) {
            System.out.println(s.getName() + s.getMail().toString());
        }
    }
}
