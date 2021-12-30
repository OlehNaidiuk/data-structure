package com.naidiuk.stack;

import java.util.StringJoiner;

public class ArrayStack<T> implements Stack<T> {

    private T[] array;
    private int size;

    public ArrayStack() {
        array = (T[]) new Object[10];
    }

    public ArrayStack(int size) {
        array = (T[]) new Object[size];
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        size--;
        return array[size];
    }

    @Override
    public void push(T element) {
        if (size == array.length) {
            reSize();
        }
        array[size] = element;
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
        for (Object o : array) {
            result.add(String.valueOf(o));
        }
        return result.toString();
    }

    private void reSize() {
        T[] arrayCopy = (T[]) new Object[size * 2];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        array = arrayCopy;
    }
}
