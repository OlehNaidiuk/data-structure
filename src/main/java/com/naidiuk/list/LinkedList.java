package com.naidiuk.list;

import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class LinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public void add(T element) {
        if (isEmpty()) {
            createFirstNode(element);
        } else {
            addToTheEnd(element);
        }
        size++;
    }

    public void add(T element, int index) {
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

    public T remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("There are no elements in the list that can be removed!");
        } else {
            checkIndexBounds(index);
        }
        T removedElement;
        if (index == 0) {
            removedElement = first.getElement();
            first = first.getLinkToNext();
        } else if (index == size - 1) {
            removedElement = last.getElement();
            last = last.getLinkToPrevious();
        } else if (index > size / 2) {
            Node<T> removed = searchFromTheEnd(index);
            removedElement = removed.getElement();
            setLinks(removed.getLinkToPrevious(), removed.getLinkToNext());
        } else {
            Node<T> removed = searchFromTheBeginning(index);
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

    public T getElement(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("There are no elements in the list!");
        } else {
            checkIndexBounds(index);
        }
        if (index > size / 2) {
            Node<T> previous = searchFromTheEnd(index);
            return previous.getElement();
        } else {
            Node<T> next = searchFromTheBeginning(index);
            return next.getElement();
        }
    }

    public boolean contains(T element) {
        boolean flag = false;
        Node<T> next = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                T linkedListElement = next.getElement();
                next = next.getLinkToNext();
                if (linkedListElement == null) {
                    flag = true;
                    break;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                T linkedListElement = next.getElement();
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
        StringJoiner result = new StringJoiner(", ", "{", "}");
        Node<T> next = first;
        for (int i = 0; i < size; i++) {
            Object element = next.getElement();
            next = next.getLinkToNext();
            result.add(String.valueOf(element));
        }
        return result.toString();
    }

    private void createFirstNode(T element) {
        first = new Node<>(element);
        last = first;
    }

    private void addToTheEnd(T element) {
        Node<T> created = new Node<>(element);
        last.setLinkToNext(created);
        created.setLinkToPrevious(last);
        last = created;
    }

    private void addToTheBeginning(T element) {
        Node<T> created = new Node<>(element);
        created.setLinkToNext(first);
        first.setLinkToPrevious(created);
        first = created;
    }

    private void addFromTheBeginning(T element, int index) {
        Node<T> created = new Node<>(element);
        Node<T> next = first;
        for (int i = 0; i < index; i++) {
            next = next.getLinkToNext();
        }
        next.setLinkToPrevious(created);
        created.setLinkToNext(next);
        Node<T> previous = first;
        for (int i = 0; i < index - 1; i++) {
            previous = previous.getLinkToNext();
        }
        previous.setLinkToNext(created);
        created.setLinkToPrevious(previous);
    }

    private void addFromTheEnd(T element, int index) {
        Node<T> created = new Node<>(element);
        Node<T> previous = last;
        for (int i = index; i < size; i++) {
            previous = previous.getLinkToPrevious();
        }
        previous.setLinkToNext(created);
        created.setLinkToPrevious(previous);
        Node<T> next = last;
        for (int i = index + 1; i < size; i++) {
            next = next.getLinkToPrevious();
        }
        next.setLinkToPrevious(created);
        created.setLinkToNext(next);
    }

    private Node<T> searchFromTheBeginning(int index) {
        Node<T> next = first;
        for (int i = 0; i < index; i++) {
            next = next.getLinkToNext();
        }
        return next;
    }

    private Node<T> searchFromTheEnd(int index) {
        Node<T> previous = last;
        for (int i = index; i < size - 1; i++) {
            previous = previous.getLinkToPrevious();
        }
        return previous;
    }

    private void setLinks(Node<T> previousBeforeRemoved, Node<T> nextAfterRemoved) {
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
