package com.naidiuk.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    private final StackInterface noSizeStackInterface = new ArrayStack();
    private final StackInterface withSizeStackInterface = new ArrayStack(2);

    @Test
    void testPushAndPopNoSizeStack() {
        //When
        noSizeStackInterface.push("Hi");
        noSizeStackInterface.push("Stas!");
        noSizeStackInterface.push("There");
        noSizeStackInterface.push("are");
        noSizeStackInterface.push("my");
        noSizeStackInterface.push("tests.");

        //Then
        assertEquals("tests.", noSizeStackInterface.pop());
        assertEquals("my", noSizeStackInterface.pop());
        assertEquals(4, noSizeStackInterface.getSize());
    }

    @Test
    void testIsEmptyNoSizeStack() {
        assertTrue(noSizeStackInterface.isEmpty());

        //When
        noSizeStackInterface.push("Hi");
        noSizeStackInterface.push("Stas!");

        //Then
        assertFalse(noSizeStackInterface.isEmpty());
    }

    @Test
    void testGetSizeNoSizeStack() {
        assertEquals(0, noSizeStackInterface.getSize());

        //When
        noSizeStackInterface.push("There");
        noSizeStackInterface.push("are");
        noSizeStackInterface.push("my");
        noSizeStackInterface.push("tests.");
        noSizeStackInterface.pop();
        noSizeStackInterface.pop();
        noSizeStackInterface.pop();

        //Then
        assertEquals(1, noSizeStackInterface.getSize());
    }

    @Test
    void testPushAndPopWithSizeStack() {
        //When
        withSizeStackInterface.push(123);
        withSizeStackInterface.push(3.22);

        //Then
        assertEquals(2, withSizeStackInterface.getSize());
        assertEquals(3.22, withSizeStackInterface.pop());
        assertEquals(123, withSizeStackInterface.pop());
        withSizeStackInterface.push("Hi");
        withSizeStackInterface.push("Stas!");
        withSizeStackInterface.push("This is");
        withSizeStackInterface.push("Oleh.");
        assertEquals(4, withSizeStackInterface.getSize());
        assertEquals("Oleh.", withSizeStackInterface.pop());
    }

    @Test
    void testIsEmptyWithSizeStack() {
        assertTrue(withSizeStackInterface.isEmpty());

        //When
        withSizeStackInterface.push("Hi");

        //Then
        assertFalse(withSizeStackInterface.isEmpty());
    }

    @Test
    void testGetSizeWithSizeStack() {
        assertEquals(0, noSizeStackInterface.getSize());

        //When
        noSizeStackInterface.push("There are my");
        noSizeStackInterface.push("tests.");
        noSizeStackInterface.pop();

        //Then
        assertEquals(1, noSizeStackInterface.getSize());
    }
}