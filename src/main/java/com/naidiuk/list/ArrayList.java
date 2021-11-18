package com.naidiuk.list;

import java.util.NoSuchElementException;

public class ArrayList implements List {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        array = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int size) {
        array = new Object[size];
    }

    public void add(Object element) {
        if (size == array.length) {
            reSize();
        }
        array[size] = element;
        size++;
    }

    public void add(Object element, int index) {
        if (size == array.length) {
            reSize();
        }
        checkIndexBounds(index);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    public Object remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("There are no elements in the list that can be removed!");
        } else {
            checkIndexBounds(index);
        }
        Object removedElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
        size--;
        return removedElement;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object getElement(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("There are no elements in the list!");
        } else {
            checkIndexBounds(index);
        }
        return array[index];
    }

    public boolean contains(Object element) {
        if (element == null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if (element.equals(array[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < array.length; i++) {
            result.append(array[i]);
            if (i == array.length - 1) {
                result.append("]");
                break;
            } else {
                result.append(", ");
            }
        }
        return result.toString();
    }

    private void reSize() {
        if (array.length == 0) {
            array = new Object[array.length + 1];
        } else {
            Object[] resizedArray = new Object[size * 2];
            System.arraycopy(array, 0, resizedArray, 0, array.length);
            array = resizedArray;
        }
    }

    private void checkIndexBounds(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index does not exist! "
                    + "Please enter index between 0 and " + (array.length - 1) + ".");
        }
    }
}