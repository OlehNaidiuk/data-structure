package com.naidiuk.queue;

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> first, last;
    private int size;

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T firstElement = first.getElement();
        first = first.getLink();
        size--;
        return firstElement;
    }

    @Override
    public void push(T object) {
        Node<T> createdNode = new Node<>();
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

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public int getSize() {
        return size;
    }
}
