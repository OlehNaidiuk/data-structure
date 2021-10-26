package com.naidiuk.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    private final QueueInterface noSizeQueueInterface = new ArrayQueue();
    private final QueueInterface withSizeQueueInterface = new ArrayQueue(2);

    @Test
    void testPushAndPopNoSizeQueue() {
        //When
        noSizeQueueInterface.push("Hi");
        noSizeQueueInterface.push("Stas!");
        noSizeQueueInterface.push("There");
        noSizeQueueInterface.push("are");
        noSizeQueueInterface.push("my");
        noSizeQueueInterface.push("tests.");

        //Then
        assertEquals("Hi", noSizeQueueInterface.pop());
        assertEquals("Stas!", noSizeQueueInterface.pop());
        assertEquals(4, noSizeQueueInterface.getSize());
    }

    @Test
    void testIsEmptyNoSizeQueue() {
        assertTrue(noSizeQueueInterface.isEmpty());

        //When
        noSizeQueueInterface.push(123);
        noSizeQueueInterface.push("you");

        //Then
        assertFalse(noSizeQueueInterface.isEmpty());
    }

    @Test
    void testGetSizeNoSizeQueue() {
        //When
        noSizeQueueInterface.push(123);

        //Then
        assertEquals(1, noSizeQueueInterface.getSize());
    }

    @Test
    void testPushAndPopWithSizeQueue() {
        //When
        withSizeQueueInterface.push("Hi");
        withSizeQueueInterface.push("Stas!");
        withSizeQueueInterface.push("There are my tests.");

        //Then
        assertEquals(3, withSizeQueueInterface.getSize());
        assertEquals("Hi", withSizeQueueInterface.pop());
        assertEquals(2, withSizeQueueInterface.getSize());
    }

    @Test
    void testIsEmptyWithSizeQueue() {
        assertTrue(withSizeQueueInterface.isEmpty());
    }

    @Test
    void testGetSizeWithSizeQueue() {
        //When
        withSizeQueueInterface.push("Hi");
        withSizeQueueInterface.push("Stas!");
        withSizeQueueInterface.push("There are my tests.");

        //Then
        assertEquals(3, withSizeQueueInterface.getSize());
    }
}