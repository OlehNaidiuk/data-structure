package com.naidiuk.queue;

public interface Queue<T> {
    T pop();
    void push(T object);
    boolean isEmpty();
    int getSize();
}
