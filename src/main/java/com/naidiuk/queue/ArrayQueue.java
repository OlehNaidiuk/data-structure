package com.naidiuk.queue;

import java.util.StringJoiner;

public class ArrayQueue<T> implements Queue<T> {

    private T[] array;
    private int size;

    public ArrayQueue() {
        array = (T[]) new Object[20];
    }

    public ArrayQueue(int size) {
        array = (T[]) new Object[size];
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T first = array[0];
        System.arraycopy(array, 1, array, 0, array.length - 1);
        size--;
        return first;
    }

    @Override
    public void push(T object) {
        if (size == array.length) {
            reSize();
        }
        array[size] = object;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringJoiner result = new StringJoiner(", ", "{", "}");
        for (T t : array) {
            result.add(String.valueOf(t));
        }
        return result.toString();
    }

    private void reSize() {
        T[] arrayCopy = (T[]) new Object[size * 2];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        array = arrayCopy;
    }
}