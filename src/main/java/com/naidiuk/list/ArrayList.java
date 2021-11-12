package com.naidiuk.list;

public class ArrayList implements ListInterface {
    private Object[] list;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        list = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int size) {
        list = new Object[size];
    }

    public void add(Object element) {
        if (size == list.length) {
            reSize();
        }
        list[size] = element;
        size++;
    }

    public void add(Object element, int index) {
        if (index < 0 || index >= list.length) {
            throw new RuntimeException("Entered index does not exist! "
                    + "Please enter an index between 0 and " + (list.length - 1) + ".");
        }
        if (size == list.length) {
            reSize();
        }
        System.arraycopy(list, index, list, index + 1, list.length - 1 - index);
        list[index] = element;
        size++;
    }

    public Object remove(int index) {
        if (index < 0 || index >= list.length) {
            throw new RuntimeException("Entered index does not exist. "
                    + "Please enter an index between 0 and " + (list.length - 1) + ".");
        }
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        Object removedElement = list[index];
        System.arraycopy(list, index + 1, list, index, list.length - 1 - index);
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
        if (index < 0 || index >= list.length) {
            throw new RuntimeException("The element with this index does not exist. "
                    + "Please enter an index between 0 and " + (list.length - 1) + ".");
        }
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        return list[index];
    }

    public boolean contains(Object element) {
        if (isEmpty()) {
            throw new RuntimeException("List is empty!");
        }
        if (element == null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < list.length; i++) {
                if (element.equals(list[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('[');
        for (int i = 0; i < list.length; i++) {
            result.append(list[i]);
            if (i == list.length - 1) {
                result.append(']');
                break;
            } else {
                result.append(", ");
            }
        }
        return result.toString();
    }

    private void reSize() {
        Object[] resizedList = new Object[size * 2];
        System.arraycopy(list, 0, resizedList, 0, list.length);
        list = resizedList;
    }
}