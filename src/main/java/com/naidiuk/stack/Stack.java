package com.naidiuk.stack;

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
            Object[] arrayCopy = new Object[stackSize * 2];
            System.arraycopy(arrayOfObjects, 0, arrayCopy, 0, arrayOfObjects.length);
            arrayOfObjects = arrayCopy;
        }
        arrayOfObjects[stackSize] = object;
        stackSize++;
    }

    public boolean isEmpty() {
        return getStackSize() == 0;
    }

    public int getStackSize() {
        return stackSize;
    }

    @Override
    public String toString() {
        String result = "";
        for (Object object : arrayOfObjects) {
            result += object + ", ";
        }
        return result;
    }
}
