package com.naidiuk.list;

import org.jetbrains.annotations.NotNull;
import java.util.StringJoiner;

public class LinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    @Override
    public void add(T element) {
        if (isEmpty()) {
            createFirstNode(element);
        } else {
            addToTheEnd(element);
        }
        size++;
    }

    @Override
    public void add(T element, int index) {
        checkAddIndexBounds(index);
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

    @Override
    public T remove(int index) {
        checkIndexBounds(index);
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
            setLinksToEachOther(removed.getLinkToPrevious(), removed.getLinkToNext());
        } else {
            Node<T> removed = searchFromTheBeginning(index);
            removedElement = removed.getElement();
            setLinksToEachOther(removed.getLinkToPrevious(), removed.getLinkToNext());
        }
        size--;
        return removedElement;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T getElement(int index) {
        checkIndexBounds(index);
        if (index > size / 2) {
            Node<T> previous = searchFromTheEnd(index);
            return previous.getElement();
        } else {
            Node<T> next = searchFromTheBeginning(index);
            return next.getElement();
        }
    }

    @Override
    public boolean contains(T element) {
        Node<T> next = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                T linkedListElement = next.getElement();
                next = next.getLinkToNext();
                if (linkedListElement == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                T linkedListElement = next.getElement();
                next = next.getLinkToNext();
                if (element.equals(linkedListElement)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
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
        setLinksToEachOther(last, created);
        last = created;
    }

    private void addToTheBeginning(T element) {
        Node<T> created = new Node<>(element);
        setLinksToEachOther(created, first);
        first = created;
    }

    private void addFromTheBeginning(T element, int index) {
        Node<T> created = new Node<>(element);
        Node<T> next = first;
        Node<T> previous = first;
        for (int i = 0; i < index; i++) {
            next = next.getLinkToNext();
        }
        for (int i = 0; i < index - 1; i++) {
            previous = previous.getLinkToNext();
        }
        setLinksToEachOther(created, next);
        setLinksToEachOther(previous, created);
    }

    private void addFromTheEnd(T element, int index) {
        Node<T> created = new Node<>(element);
        Node<T> previous = last;
        Node<T> next = last;
        for (int i = index; i < size; i++) {
            previous = previous.getLinkToPrevious();
        }
        for (int i = index + 1; i < size; i++) {
            next = next.getLinkToPrevious();
        }
        setLinksToEachOther(previous, created);
        setLinksToEachOther(created, next);
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

    private void setLinksToEachOther(@NotNull Node<T> previous, Node<T> next) {
        previous.setLinkToNext(next);
        next.setLinkToPrevious(previous);
    }

    private void checkIndexBounds(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index does not exist!\n"
                    + "Please enter index between 0 and " + (size - 1) + ".");
        }
    }

    private void checkAddIndexBounds(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index does not exist!\n"
                    + "Please enter index between 0 and " + size + ".");
        }
    }
}
