package com.naidiuk.stack;

public class Node {
    private Object element;
    private Node link;

    public void setElement(Object element) {
        this.element = element;
    }

    public Object getElement() {
        return element;
    }

    public void setLinkToThePrevious(Node node) {
        this.link = node;
    }

    public Node getLink() {
        return link;
    }
}