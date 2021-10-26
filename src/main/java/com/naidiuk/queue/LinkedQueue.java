package com.naidiuk.queue;

public class LinkedQueue implements QueueInterface {
    private Node first, last;
    private int size;

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (size == 1) {
            size--;
            return first.getElement();
        }
        Object firstElement = first.getElement();
        first = first.getLink();
        size--;
        return firstElement;
    }

    public void push(Object object) {
        Node createdNode = new Node();
        createdNode.setElement(object);
        if (size == 0) {
            first = createdNode;
        } else if (size == 1) {
            first.setLink(createdNode);
        } else if (size > 1) {
            last.setLink(createdNode);
        }
        last = createdNode;
        size++;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return size;
    }
}
