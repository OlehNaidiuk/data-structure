package com.naidiuk.stack;

public class QStack {
    private Object[] objectsArray;
    private int stackSize;
    private Object first;

    public QStack() {
        objectsArray = new Object[20];
    }

    public QStack(int size) {
        objectsArray = new Object[size];
    }

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("Стэк пуст");
        }
        if (stackSize > 1) {
            first = objectsArray[0];
            System.arraycopy(objectsArray, 1, objectsArray, 0, objectsArray.length - 1);
            stackSize--;
            return first;
        }
        stackSize--;
        return objectsArray[0];
    }

    public void push(Object object) {
        if (stackSize == objectsArray.length) {
            Object[] arrayCopy = new Object[stackSize * 2];
            System.arraycopy(objectsArray, 0, arrayCopy, 0, objectsArray.length);
            objectsArray = arrayCopy;
        }
        objectsArray[stackSize] = object;
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
        for (Object object : objectsArray) {
            result += object + ", ";
        }
        return result;
    }
}