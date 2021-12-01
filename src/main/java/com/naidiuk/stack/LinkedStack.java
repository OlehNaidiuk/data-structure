package com.naidiuk.stack;

public class LinkedStack<T> implements Stack<T> {

    private Node<T> last;
    private int size;

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T lastElement = last.getElement();
        last = last.getLink();
        size--;
        return lastElement;
    }

    @Override
    public void push(T element) {
        Node<T> createdNode = new Node<>();
        createdNode.setElement(element);
        createdNode.setLinkToPrevious(last);
        last = createdNode;
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
