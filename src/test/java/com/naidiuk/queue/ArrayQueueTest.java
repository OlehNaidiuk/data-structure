package com.naidiuk.queue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {

    private final Queue<String> noSizedQueue = new ArrayQueue<>();
    private final Queue<String> sizedQueue = new ArrayQueue<>(2);

    @Test
    void testNoSizeQueuePushAndPop() {
        //When
        noSizedQueue.push("Hi");
        noSizedQueue.push("Stas!");
        noSizedQueue.push("There");
        noSizedQueue.push("are");
        noSizedQueue.push("my");
        noSizedQueue.push("tests.");

        //Then
        assertEquals("Hi", noSizedQueue.pop());
        assertEquals("Stas!", noSizedQueue.pop());
        assertEquals(4, noSizedQueue.getSize());
    }

    @Test
    void testNoSizeQueueIsEmpty() {
        assertTrue(noSizedQueue.isEmpty());

        //When
        noSizedQueue.push("123");
        noSizedQueue.push("you");

        //Then
        assertFalse(noSizedQueue.isEmpty());
    }

    @Test
    void testNoSizeQueueGetSize() {
        //When
        noSizedQueue.push("123");

        //Then
        assertEquals(1, noSizedQueue.getSize());
    }

    @Test
    void testSizedQueuePushAndPop() {
        //When
        sizedQueue.push("Hi");
        sizedQueue.push("Stas!");
        sizedQueue.push("There are my tests.");

        //Then
        assertEquals(3, sizedQueue.getSize());
        assertEquals("Hi", sizedQueue.pop());
        assertEquals(2, sizedQueue.getSize());
    }

    @Test
    void testSizedQueueIsEmpty() {
        assertTrue(sizedQueue.isEmpty());
    }

    @Test
    void testSizedQueueGetSize() {
        //When
        sizedQueue.push("Hi");
        sizedQueue.push("Stas!");
        sizedQueue.push("There are my tests.");

        //Then
        assertEquals(3, sizedQueue.getSize());
    }
}