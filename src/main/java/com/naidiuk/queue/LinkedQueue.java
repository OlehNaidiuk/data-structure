package com.naidiuk.queue;

public class LinkedQueue implements QueueInterface {
    private Node first, last;
    private int size;

    public Object pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        Object firstElement = first.getElement();
        first = first.getLink();
        size--;
        return firstElement;
    }

    public void push(Object object) {
        Node createdNode = new Node();
        createdNode.setElement(object);
        if (isEmpty()) {
            first = createdNode;
            last = first;
        } else {
            last.setLinkToTheNext(createdNode);
            last = createdNode;
        }
        size++;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getSize() {
        return size;
    }
}
