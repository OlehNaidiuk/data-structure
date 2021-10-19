package com.naidiuk.stack;

public class Components implements Stack {
    private Object[] array;
    private int size;

    public Components() {
        array = new Object[20];
    }

    public Components(int size) {
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
        for (Object object : array) {
            result.append(object).append(", ");
        }
        return result.toString();
    }

    private void reSize() {
        Object[] arrayCopy = new Object[size * 2];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        array = arrayCopy;
    }
}
