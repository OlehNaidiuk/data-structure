package com.naidiuk.list;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class LinkedList implements List {
    private Node first;
    private Node last;
    private int size;

    public void add(Object element) {
        Node justCreated = new Node(element);
        if (isEmpty()) {
            first = justCreated;
            last = first;
        } else {
            last.setLinkToNext(justCreated);
            justCreated.setLinkToPrevious(last);
            last = justCreated;
        }
        size++;
    }

    public void add(Object element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index does not exist! " +
                    "Please enter index between 0 and " + size + ".");
        }
        Node justCreated = new Node(element);
        if (index == 0) {
            justCreated.setLinkToNext(first);
            first.setLinkToPrevious(justCreated);
            first = justCreated;
        } else if (index == size) {
            last.setLinkToNext(justCreated);
            justCreated.setLinkToPrevious(last);
            last = justCreated;
        } else if (index < size / 2) {
            Node next = first;
            for (int i = 0; i < index; i++) {
                next = next.getLinkToNext();
            }
            next.setLinkToPrevious(justCreated);
            justCreated.setLinkToNext(next);
            Node previous = first;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.getLinkToNext();
            }
            previous.setLinkToNext(justCreated);
            justCreated.setLinkToPrevious(previous);
        } else {
            Node previous = last;
            for (int i = index; i < size; i++) {
                previous = previous.getLinkToPrevious();
            }
            previous.setLinkToNext(justCreated);
            justCreated.setLinkToPrevious(previous);
            Node next = last;
            for (int i = index + 1; i < size; i++) {
                next = next.getLinkToPrevious();
            }
            next.setLinkToPrevious(justCreated);
            justCreated.setLinkToNext(next);
        }
        size++;
    }

    public Object remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("There are no elements in the list that can be removed!");
        } else {
            checkIndexBounds(index);
        }
        Object removedElement;
        if (index == 0) {
            removedElement = first.getElement();
            first = first.getLinkToNext();
        } else if (index == size - 1) {
            removedElement = last.getElement();
            last = last.getLinkToPrevious();
        } else {
            Node previous = last;
            for (int i = index; i < size - 1; i++) {
                previous = previous.getLinkToPrevious();
            }
            removedElement = previous.getElement();
            Node next = previous.getLinkToNext();
            previous = previous.getLinkToPrevious();
            previous.setLinkToNext(next);
            next.setLinkToPrevious(previous);
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
            Node previous = last;
            for (int i = index; i < size - 1; i++) {
                previous = previous.getLinkToPrevious();
            }
            return previous.getElement();
        } else {
            Node next = first;
            for (int i = 0; i < index; i++) {
                next = next.getLinkToNext();
            }
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

    private void checkIndexBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index does not exist! " +
                    "Please enter index between 0 and " + (size - 1) + ".");
        }
    }
}
