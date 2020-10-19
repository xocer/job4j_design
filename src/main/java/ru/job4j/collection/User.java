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
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<User, Object>();
        Calendar calendar = Calendar.getInstance();
        User user1 = new User("Bob", 2, calendar);
        User user2 = new User("Bob", 2, calendar);
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (Map.Entry<User, Object> q : map.entrySet()) {
            System.out.println(q.getKey() + " " + q.getValue());
        }
    }
}
