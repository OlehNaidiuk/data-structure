package com.naidiuk.stack;

public class ArrayStack implements StackInterface {
    private Object[] array;
    private int size;

    public ArrayStack() {
        array = new Object[20];
    }

    public ArrayStack(int size) {
        array = new Object[size];
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        size--;
        return array[size];
    }

    public void push(Object object) {
        if (size == array.length) {
            reSize();
        }
        array[size] = object;
        size++;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('[');
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i == array.length - 1) {
                result.append(']');
                break;
            } else {
                result.append(", ");
            }
        }
        return result.toString();
    }

    private void reSize() {
        Object[] arrayCopy = new Object[size * 2];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        array = arrayCopy;
    }
}
