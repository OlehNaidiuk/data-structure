package com.naidiuk.list;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class ArrayList<T> implements List<T> {

    private T[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int size) {
        array = (T[]) new Object[size];
    }

    public void add(T element) {
        if (size == array.length) {
            reSize();
        }
        array[size] = element;
        size++;
    }

    public void add(T element, int index) {
        if (size == array.length) {
            reSize();
        }
        checkIndexBounds(index);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    public T remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("There are no elements in the list that can be removed!");
        } else {
            checkIndexBounds(index);
        }
        T removedElement = array[index];
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

    public T getElement(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("There are no elements in the list!");
        } else {
            checkIndexBounds(index);
        }
        return array[index];
    }

    public boolean contains(T element) {
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
        StringJoiner result = new StringJoiner(", ", "{", "}");
        for (int i = 0; i < array.length; i++) {
            result.add(String.valueOf(array[i]));
        }
        return result.toString();
    }

    private void reSize() {
        if (array.length == 0) {
            array = (T[]) new Object[array.length + 1];
        } else {
            T[] resizedArray = (T[]) new Object[size * 2];
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