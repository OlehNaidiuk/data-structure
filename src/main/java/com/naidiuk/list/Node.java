package com.naidiuk.list;

public class Node {
    private final Object element;
    private Node linkToPrevious;
    private Node linkToNext;

    public Node(Object element) {
        this.element = element;
    }

    public void setLinkToNext(Node linkToNext) {
        this.linkToNext = linkToNext;
    }

    public void setLinkToPrevious(Node linkToPrevious) {
        this.linkToPrevious = linkToPrevious;
    }

    public Object getElement() {
        return element;
    }

    public Node getLinkToNext() {
        return linkToNext;
    }

    public Node getLinkToPrevious() {
        return linkToPrevious;
    }
}
