package ru.job4j.collection;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;
import java.util.NoSuchElementException;

public class AnalizeTest {
    @Test
    public void whenAllNormal() {
        List<Analize.User> previous = List.of(new Analize.User(1, "Вася"),
                new Analize.User(2, "Дима"),
                new Analize.User(3, "Валера"),
                new Analize.User(4, "Али"));

        List<Analize.User> current = List.of(new Analize.User(1, "Вася"),
                new Analize.User(221, "Коля"),
                new Analize.User(3, "Лена"),
                new Analize.User(14, "Галина"));

        Analize.Info info = new Analize().diff(previous, current);
        Analize.Info result = new Analize.Info(2, 1, 2);
        assertThat(info, is(result));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenListEmpty() {
        List<Analize.User> previous = List.of(new Analize.User(1, "Вася"),
                new Analize.User(2, "Дима"));
        List<Analize.User> current = List.of();

        Analize.Info info = new Analize().diff(previous, current);
    }
}
