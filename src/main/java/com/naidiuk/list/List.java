package com.naidiuk.list;

public interface List<T> {
    void add(T element);
    void add(T element, int index);
    T remove(int index);
    int getSize();
    boolean isEmpty();
    T getElement(int index);
    boolean contains(T element);
}
