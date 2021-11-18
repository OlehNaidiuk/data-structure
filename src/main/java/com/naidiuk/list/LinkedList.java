package com.naidiuk.list;

import java.util.NoSuchElementException;

public class LinkedList implements List {
    private Node first;
    private Node last;
    private int size;

    public void add(Object element) {
        if (isEmpty()) {
            createFirstNode(element);
        } else {
            addToTheEnd(element);
        }
        size++;
    }

    public void add(Object element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index does not exist! " +
                    "Please enter index between 0 and " + size + ".");
        }
        if (isEmpty()) {
            createFirstNode(element);
        } else if (index == 0) {
            addToTheBeginning(element);
        } else if (index == size) {
            addToTheEnd(element);
        } else if (index < size / 2) {
            addFromTheBeginning(element, index);
        } else {
            addFromTheEnd(element, index);
        }
        size++;
    }

    public Object remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("There are no elements in the list that can be removed!");
        } else {
            checkIndexBounds(index);
        }
        Node removed;
        Object removedElement;
        if (index == 0) {
            removedElement = first.getElement();
            first = first.getLinkToNext();
        } else if (index == size - 1) {
            removedElement = last.getElement();
            last = last.getLinkToPrevious();
        } else if (index > size / 2) {
            removed = searchFromTheEnd(index);
            removedElement = removed.getElement();
            setLinks(removed.getLinkToPrevious(), removed.getLinkToNext());
        } else {
            removed = searchFromTheBeginning(index);
            removedElement = removed.getElement();
            setLinks(removed.getLinkToPrevious(), removed.getLinkToNext());
        }
        size--;
        return removedElement;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object getElement(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("There are no elements in the list!");
        } else {
            checkIndexBounds(index);
        }
        if (index > size / 2) {
            Node previous = searchFromTheEnd(index);
            return previous.getElement();
        } else {
            Node next = searchFromTheBeginning(index);
            return next.getElement();
        }
    }

    public boolean contains(Object element) {
        boolean flag = false;
        Node next = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                Object linkedListElement = next.getElement();
                next = next.getLinkToNext();
                if (linkedListElement == null) {
                    flag = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                Object linkedListElement = next.getElement();
                next = next.getLinkToNext();
                if (element.equals(linkedListElement)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "List is empty.";
        }
        StringBuilder result = new StringBuilder();
        Node next = first;
        result.append("{");
        for (int i = 0; i < size; i++) {
            Object linkedListElement = next.getElement();
            next = next.getLinkToNext();
            result.append(linkedListElement);
            if (i == size - 1) {
                result.append("}");
                break;
            } else {
                result.append(", ");
            }
        }
        return result.toString();
//        StringJoiner result = new StringJoiner(", ", "{", "}");
//        Node next = first;
//        for (int i = 0; i < size; i++) {
//            Object element = next.getElement();
//            result.add(element.toString());
//            next = next.getLinkToNext();
//        }
//        return result.toString();
    }

    private void createFirstNode(Object element) {
        first = new Node(element);
        last = first;
    }

    private void addToTheEnd(Object element) {
        Node created = new Node(element);
        last.setLinkToNext(created);
        created.setLinkToPrevious(last);
        last = created;
    }

    private void addToTheBeginning(Object element) {
        Node created = new Node(element);
        created.setLinkToNext(first);
        first.setLinkToPrevious(created);
        first = created;
    }

    private void addFromTheBeginning(Object element, int index) {
        Node created = new Node(element);
        Node next = first;
        for (int i = 0; i < index; i++) {
            next = next.getLinkToNext();
        }
        next.setLinkToPrevious(created);
        created.setLinkToNext(next);
        Node previous = first;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.getLinkToNext();
        }
        previous.setLinkToNext(created);
        created.setLinkToPrevious(previous);
    }

    private void addFromTheEnd(Object element, int index) {
        Node created = new Node(element);
        Node previous = last;
        for (int i = index; i < size; i++) {
            previous = previous.getLinkToPrevious();
        }
        previous.setLinkToNext(created);
        created.setLinkToPrevious(previous);
        Node next = last;
        for (int i = index + 1; i < size; i++) {
            next = next.getLinkToPrevious();
        }
        next.setLinkToPrevious(created);
        created.setLinkToNext(next);
    }

    private Node searchFromTheBeginning(int index) {
        Node next = first;
        for (int i = 0; i < index; i++) {
            next = next.getLinkToNext();
        }
        return next;
    }

    private Node searchFromTheEnd(int index) {
        Node previous = last;
        for (int i = index; i < size - 1; i++) {
            previous = previous.getLinkToPrevious();
        }
        return previous;
    }

    private void setLinks(Node previousBeforeRemoved, Node nextAfterRemoved) {
        previousBeforeRemoved.setLinkToNext(nextAfterRemoved);
        nextAfterRemoved.setLinkToPrevious(previousBeforeRemoved);
    }

    private void checkIndexBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index does not exist! " +
                    "Please enter index between 0 and " + (size - 1) + ".");
        }
    }
}
