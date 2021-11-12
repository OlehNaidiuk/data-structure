package com.naidiuk.list;

public interface ListInterface {
    void add(Object element);
    void add(Object element, int index);
    Object remove(int index);
    int getSize();
    boolean isEmpty();
    Object getElement(int index);
    boolean contains(Object element);
}
