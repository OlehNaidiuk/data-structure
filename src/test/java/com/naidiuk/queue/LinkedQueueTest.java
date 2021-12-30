package com.naidiuk.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {

    private final Queue<String> linkedQueue = new LinkedQueue<>();

    @Test
    void testPushAndPop() {
        //Prepare
        int size;
        linkedQueue.push("Hi");
        linkedQueue.push("Stas!");
        linkedQueue.push("There");
        linkedQueue.push("are");
        linkedQueue.push("my");
        linkedQueue.push("tests.");

        //When
        String first = linkedQueue.pop();
        String second = linkedQueue.pop();
        size = linkedQueue.getSize();

        //Then
        assertEquals("Hi", first);
        assertEquals("Stas!", second);
        assertEquals(4, size);
    }

    @Test
    void testIsEmpty() {
        //Prepare
        boolean isEmpty;

        //When
        isEmpty = linkedQueue.isEmpty();

        //Then
        assertTrue(isEmpty);

        //When
        linkedQueue.push("Hi");
        linkedQueue.push("Stas!");
        isEmpty = linkedQueue.isEmpty();

        //Then
        assertFalse(isEmpty);
    }

    @Test
    void testGetSize() {
        //Prepare
        int size;

        //When
        size = linkedQueue.getSize();

        //Then
        assertEquals(0, size);

        //When
        linkedQueue.push("Hi");
        linkedQueue.push("Stas!");
        size = linkedQueue.getSize();

        //Then
        assertEquals(2, size);
    }
}