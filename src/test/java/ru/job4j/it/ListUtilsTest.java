package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 0, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 2, 2);
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        Predicate<Integer> predicate = (i) -> i == 2;
        list = ListUtils.removeIf(list, predicate);
        assertThat(Arrays.asList(1, 3), Is.is(list));
    }

    @Test
    public void whenReplaceIf() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2));
        Predicate<Integer> predicate = (i) -> i == 2;
        list = ListUtils.replaceIf(list, predicate, 5);
        assertThat(Arrays.asList(1, 5, 3, 4, 5), Is.is(list));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> list = new ArrayList<>(Arrays.asList(11, 22, 33, 44));
        List<Integer> elements = new ArrayList<>(Arrays.asList(33));
        list = ListUtils.removeAll(list, elements);
        assertThat(Arrays.asList(11, 22, 44), Is.is(list));
    }

}