package com.naidiuk.stack;

import java.util.Arrays;

public class Stack {
    private Object[] arrayOfObjects;
    private int stackSize;

    public Stack() {
        arrayOfObjects = new Object[20];
    }

    public Stack(int size) {
        arrayOfObjects = new Object[size];
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("Стэк пуст");
        }
        stackSize--;
        return arrayOfObjects[stackSize];
    }

    public void push(Object object) {
        if (stackSize == arrayOfObjects.length) {
            Object[] arrayCopy = new Object[stackSize + 1];
            System.arraycopy(arrayOfObjects, 0, arrayCopy, 0, arrayOfObjects.length);
            arrayOfObjects = arrayCopy;
        }
        arrayOfObjects[stackSize] = object;
        stackSize++;
    }

    public boolean isEmpty() {
        return stackSize == 0;
    }

    public String toString() {
        return Arrays.toString(arrayOfObjects);
    }
}
