package com.naidiuk.stack;

public interface Stack<T> {
    T pop();
    void push(T element);
    boolean isEmpty();
    int getSize();
}
