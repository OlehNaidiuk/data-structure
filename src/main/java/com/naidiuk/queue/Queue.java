package com.naidiuk.queue;

public interface Queue {
    Object pop();
    void push(Object object);
    boolean isEmpty();
    int getSize();
}
