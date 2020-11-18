package ru.job4j.additional.tasks;

import java.util.*;

public class Mail {

    public Map<String, List<String>> mergerMail(Map<String, List<String>> users) {
        if (users.isEmpty()) {
            throw new NoSuchElementException();
        }
        Map<String, String> emailAndUser = new HashMap<>();
        Map<String, String> userAndUser = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : users.entrySet()) {
            String user = entry.getKey();
            for (String mail : entry.getValue()) {
                String otherUser = emailAndUser.putIfAbsent(mail, user);
                if (otherUser != null) {
                    userAndUser.put(user, Optional.ofNullable(userAndUser.get(otherUser))
                            .orElse(otherUser));
                }
            }
        }
        Map<String, List<String>> result = new HashMap<>();
        for (Map.Entry<String, String> entry : emailAndUser.entrySet()) {
            String key = Optional.ofNullable(userAndUser.get(entry.getValue()))
                    .orElse(entry.getValue());
            String value = entry.getKey();
            if (result.containsKey(key)) {
                result.get(key).add(value);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(value);
                result.put(key, tmp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, List<String>> input = new HashMap<>();

        input.put("user1", List.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        input.put("user2", List.of("foo@gmail.com", "ups@pisem.net"));
        input.put("user3", List.of("xyz@pisem.net", "vasya@pupkin.com"));
        input.put("user4", List.of("ups@pisem.net", "aaa@bbb.ru"));
        input.put("user5", List.of("xyz@pisem.net"));

        Mail mail = new Mail();
        Map<String, List<String>> array = mail.mergerMail(input);
        array.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
