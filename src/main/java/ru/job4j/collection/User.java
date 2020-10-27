package ru.job4j.collection;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                name.equals(user.name) &&
                birthday.equals(user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<User, Object>();
        Calendar calendar = Calendar.getInstance();
        User user1 = new User("Bob", 2, calendar);
        User user2 = new User("Bob", 2, calendar);
        map.put(user1, new Object());
        map.put(user2, new Object());

        System.out.println(123456789 & 15);

//        String test = binary(123456789);
//
//        System.out.println(test);
//        System.out.println(binary(123456789 >>> 16));
//        System.out.println(0000111010110111100110100010101 ^ 00000000000000000000111 01011011 >>> 16);

//        System.out.println(user1.hashCode());
//        for (Map.Entry<User, Object> q : map.entrySet()) {
//            System.out.println(q.getKey() + " " + q.getValue());
//        }
    }
}
