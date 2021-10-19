package com.naidiuk.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private final Stack noSizeStack = new Components();
    private final Stack withSizeStack = new Components(2);

    @Test
    void testPushAndPopNoSizeStack() {
        //When
        noSizeStack.push("Hi");
        noSizeStack.push("Stats!");
        noSizeStack.push("There");
        noSizeStack.push("are");
        noSizeStack.push("my");
        noSizeStack.push("tests.");

        //Then
        assertEquals("tests.", noSizeStack.pop());
        assertEquals("my", noSizeStack.pop());
        assertEquals(4, noSizeStack.getSize());
    }

    @Test
    void testIsEmptyNoSizeStack() {
        assertTrue(noSizeStack.isEmpty());

        //When
        noSizeStack.push("Hi");
        noSizeStack.push("Stats!");

        //Then
        assertFalse(noSizeStack.isEmpty());
    }

    @Test
    void testGetSizeNoSizeStack() {
        assertEquals(0, noSizeStack.getSize());

        //When
        noSizeStack.push("There");
        noSizeStack.push("are");
        noSizeStack.push("my");
        noSizeStack.push("tests.");
        noSizeStack.pop();
        noSizeStack.pop();
        noSizeStack.pop();

        //Then
        assertEquals(1, noSizeStack.getSize());
    }

    @Test
    void testPushAndPopWithSizeStack() {
        //When
        withSizeStack.push(123);
        withSizeStack.push(3.22);

        //Then
        assertEquals(2, withSizeStack.getSize());
        assertEquals(3.22, withSizeStack.pop());
        assertEquals(123, withSizeStack.pop());
        withSizeStack.push("Hi");
        withSizeStack.push("Stas!");
        withSizeStack.push("This is");
        withSizeStack.push("Oleh.");
        assertEquals(4, withSizeStack.getSize());
        assertEquals("Oleh.", withSizeStack.pop());
    }

    @Test
    void testIsEmptyWithSizeStack() {
        assertTrue(withSizeStack.isEmpty());

        //When
        withSizeStack.push("Hi");

        //Then
        assertFalse(withSizeStack.isEmpty());
    }

    @Test
    void testGetSizeWithSizeStack() {
        assertEquals(0, noSizeStack.getSize());

        //When
        noSizeStack.push("There are my");
        noSizeStack.push("tests.");
        noSizeStack.pop();

        //Then
        assertEquals(1, noSizeStack.getSize());
    }
}