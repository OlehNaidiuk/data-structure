package com.naidiuk.queue;

public class Node<T> {

    private T element;
    private Node<T> link;

    public void setElement(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setLinkToTheNext(Node<T> node) {
        this.link = node;
    }

    public Node<T> getLink() {
        return link;
    }
}