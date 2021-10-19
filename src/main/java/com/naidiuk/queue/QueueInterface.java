package com.naidiuk.queue;

public interface QueueInterface {
    Object pop();
    void push(Object object);
    boolean isEmpty();
    int getSize();
}
