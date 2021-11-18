package com.naidiuk.list;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {
    private final List linkedList = new LinkedList();

    @BeforeEach
    void setup() {
        linkedList.add(123);
        linkedList.add(null, 1);
    }

    @Test
    void testAdd() {
        //When
        int size = linkedList.getSize();
        linkedList.add("hello");
        linkedList.add('a', 3);
        int sizeAfterAdd = linkedList.getSize();

        //Then
        assertEquals(2, size);
        assertEquals(4, sizeAfterAdd);
        assertEquals("{123, null, hello, a}", linkedList.toString());
    }

    @Test
    void testRemove() {
        //When
        Object firstRemoved = linkedList.remove(0);
        Object secondRemoved = linkedList.remove(0);

        //Then
        assertEquals(123, firstRemoved);
        assertEquals(null, secondRemoved);
    }

    @Test
    void testGetSize() {
        //When
        int size = linkedList.getSize();
        linkedList.remove(1);
        linkedList.remove(0);
        int sizeAfterRemove = linkedList.getSize();
        linkedList.add("hello");
        int sizeAfterAdd = linkedList.getSize();

        //Then
        assertEquals(2, size);
        assertEquals(0, sizeAfterRemove);
        assertEquals(1, sizeAfterAdd);
    }

    @Test
    void testIsEmpty() {
        //When
        boolean flag = linkedList.isEmpty();
        linkedList.remove(0);
        linkedList.remove(0);
        boolean yes = linkedList.isEmpty();

        //Then
        assertEquals(false, flag);
        assertEquals(true, yes);
    }

    @Test
    void testGetElement() {
        //When
        Object firstElement = linkedList.getElement(0);
        Object secondElement = linkedList.getElement(1);

        //Then
        assertEquals(123, firstElement);
        assertEquals(null, secondElement);
    }

    @Test
    void testContains() {
        //When
        boolean yes = linkedList.contains(null);
        boolean no = linkedList.contains(999);

        //Then
        assertEquals(true, yes);
        assertEquals(false, no);
    }
}