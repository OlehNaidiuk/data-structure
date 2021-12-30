package com.naidiuk.list;

public class Node<T> {

    private final T element;
    private Node<T> linkToPrevious;
    private Node<T> linkToNext;

    public Node(T element) {
        this.element = element;
    }

    public void setLinkToNext(Node<T> linkToNext) {
        this.linkToNext = linkToNext;
    }

    public void setLinkToPrevious(Node<T> linkToPrevious) {
        this.linkToPrevious = linkToPrevious;
    }

    public T getElement() {
        return element;
    }

    public Node<T> getLinkToNext() {
        return linkToNext;
    }

    public Node<T> getLinkToPrevious() {
        return linkToPrevious;
    }
}
