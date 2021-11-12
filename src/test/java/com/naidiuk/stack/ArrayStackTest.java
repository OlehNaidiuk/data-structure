package com.naidiuk.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    private final StackInterface noSizedStack = new ArrayStack();
    private final StackInterface sizedStack = new ArrayStack(2);

    @Test
    void testNoSizeStackPushAndPop() {
        //When
        noSizedStack.push("Hi");
        noSizedStack.push("Stas!");
        noSizedStack.push("There");
        noSizedStack.push("are");
        noSizedStack.push("my");
        noSizedStack.push("tests.");

        //Then
        assertEquals("tests.", noSizedStack.pop());
        assertEquals("my", noSizedStack.pop());
        assertEquals(4, noSizedStack.getSize());
    }

    @Test
    void testNoSizeStackIsEmpty() {
        assertTrue(noSizedStack.isEmpty());

        //When
        noSizedStack.push("Hi");
        noSizedStack.push("Stas!");

        //Then
        assertFalse(noSizedStack.isEmpty());
    }

    @Test
    void testNoSizeStackGetSize() {
        assertEquals(0, noSizedStack.getSize());

        //When
        noSizedStack.push("There");
        noSizedStack.push("are");
        noSizedStack.push("my");
        noSizedStack.push("tests.");
        noSizedStack.pop();
        noSizedStack.pop();
        noSizedStack.pop();

        //Then
        assertEquals(1, noSizedStack.getSize());
    }

    @Test
    void testSizedStackPushAndPop() {
        //When
        sizedStack.push(123);
        sizedStack.push(3.22);

        //Then
        assertEquals(2, sizedStack.getSize());
        assertEquals(3.22, sizedStack.pop());
        assertEquals(123, sizedStack.pop());
        sizedStack.push("Hi");
        sizedStack.push("Stas!");
        sizedStack.push("This is");
        sizedStack.push("Oleh.");
        assertEquals(4, sizedStack.getSize());
        assertEquals("Oleh.", sizedStack.pop());
    }

    @Test
    void testSizedStackIsEmpty() {
        assertTrue(sizedStack.isEmpty());

        //When
        sizedStack.push("Hi");

        //Then
        assertFalse(sizedStack.isEmpty());
    }

    @Test
    void testSizedStackGetSize() {
        assertEquals(0, sizedStack.getSize());

        //When
        sizedStack.push("There are my");
        sizedStack.push("tests.");
        sizedStack.pop();

        //Then
        assertEquals(1, sizedStack.getSize());
    }
}