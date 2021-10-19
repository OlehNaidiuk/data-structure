package com.naidiuk.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private final Queue noSizeQueue = new Elements();
    private final Queue withSizeQueue = new Elements(2);

    @Test
    void testPushAndPopNoSizeQueue() {
        //When
        noSizeQueue.push("Hi");
        noSizeQueue.push("Stats!");
        noSizeQueue.push("There");
        noSizeQueue.push("are");
        noSizeQueue.push("my");
        noSizeQueue.push("tests.");

        //Then
        assertEquals("Hi", noSizeQueue.pop());
        assertEquals("Stas!", noSizeQueue.pop());
        assertEquals(4, noSizeQueue.getSize());
    }

    @Test
    void testIsEmptyNoSizeQueue() {
        assertTrue(noSizeQueue.isEmpty());

        //When
        noSizeQueue.push(123);
        noSizeQueue.push("you");

        //Then
        assertFalse(noSizeQueue.isEmpty());
    }

    @Test
    void testGetSizeNoSizeQueue() {
        //When
        noSizeQueue.push(123);

        //Then
        assertEquals(1, noSizeQueue.getSize());
    }

    @Test
    void testPushAndPopWithSizeQueue() {
        //When
        withSizeQueue.push("Hi");
        withSizeQueue.push("Stats!");
        withSizeQueue.push("There are my tests.");

        //Then
        assertEquals(3, withSizeQueue.getSize());
        assertEquals("Hi", withSizeQueue.pop());
        assertEquals(2, withSizeQueue.getSize());
    }

    @Test
    void testIsEmptyWithSizeQueue() {
        assertTrue(withSizeQueue.isEmpty());
    }

    @Test
    void testGetSizeWithSizeQueue() {
        //When
        withSizeQueue.push("Hi");
        withSizeQueue.push("Stats!");
        withSizeQueue.push("There are my tests.");

        //Then
        assertEquals(3, withSizeQueue.getSize());
    }
}