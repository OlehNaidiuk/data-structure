package com.naidiuk.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    private final StackInterface linkedStack = new LinkedStack();

    @Test
    void testPushAndPop() {
        //Preapare
        int size;
        linkedStack.push("Hi");
        linkedStack.push("Stas!");
        linkedStack.push("There");
        linkedStack.push("are");
        linkedStack.push("my");
        linkedStack.push("tests.");

        //When
        Object last = linkedStack.pop();
        Object preLast = linkedStack.pop();
        size = linkedStack.getSize();

        //Then
        assertEquals("tests.", last);
        assertEquals("my", preLast);
        assertEquals(4, size);
    }

    @Test
    void testIsEmpty() {
        //Prepare
        boolean isEmpty;

        //When
        isEmpty = linkedStack.isEmpty();

        //Then
        assertTrue(isEmpty);

        //When
        linkedStack.push("Hi");
        linkedStack.push("Stas!");
        isEmpty = linkedStack.isEmpty();

        //Then
        assertFalse(isEmpty);
    }

    @Test
    void testGetSize() {
        //Prepare
        int size;

        //When
        size = linkedStack.getSize();

        //Then
        assertEquals(0, size);

        //When
        linkedStack.push("Hi");
        linkedStack.push("Stas!");
        size = linkedStack.getSize();

        //Then
        assertEquals(2, size);
    }
}