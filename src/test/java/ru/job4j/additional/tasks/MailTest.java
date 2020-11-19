package ru.job4j.additional.tasks;

import org.junit.Test;
import ru.job4j.additional.tasks.Mail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class MailTest {

    @Test
    public void whenAllOk() {
        Map<String, List<String>> input = new HashMap<>();

        input.put("user1", List.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        input.put("user2", List.of("foo@gmail.com", "ups@pisem.net"));
        input.put("user3", List.of("xyz@pisem.net", "vasya@pupkin.com"));
        input.put("user4", List.of("ups@pisem.net", "aaa@bbb.ru"));
        input.put("user5", List.of("xyz@pisem.net"));

        Mail mail = new Mail();
        input = mail.mergerMail(input);

        Map<String, List<String>> tmp = new HashMap<>();
        tmp.put("user1", List.of("aaa@bbb.ru",
                "ups@pisem.net",
                "lol@mail.ru", "xxx@ya.ru",
                "foo@gmail.com"));
        tmp.put("user5", List.of("vasya@pupkin.com", "xyz@pisem.net"));

        assertThat(input.equals(tmp), is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenMapIsEmpty() {
        Map<String, List<String>> input = new HashMap<>();
        Mail mail = new Mail();
        input = mail.mergerMail(input);
    }
}
