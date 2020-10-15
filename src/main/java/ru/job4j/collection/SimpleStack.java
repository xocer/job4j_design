package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();
    int count;

    public T pop() {
        count--;
        return linked.deleteFirst();
    }

    public void push(T value) {
        count++;
        linked.addFirst(value);
    }
}
