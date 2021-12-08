package com.naidiuk.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    private final Stack<String> linkedStack = new LinkedStack<>();

    @BeforeEach
    void setup() {
        linkedStack.push("Hi");
        linkedStack.push("Stas!");
        linkedStack.push("There");
        linkedStack.push("are");
        linkedStack.push("my");
        linkedStack.push("tests.");
    }

    @Test
    void testPushAndPop() {
        //When
        String last = linkedStack.pop();
        String preLast = linkedStack.pop();
        int size = linkedStack.getSize();

        //Then
        assertEquals("tests.", last);
        assertEquals("my", preLast);
        assertEquals(4, size);
    }

    @Test
    void testIsEmpty() {
        //When
        boolean isEmpty = linkedStack.isEmpty();

        //Then
        assertFalse(isEmpty);

        //When
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        linkedStack.pop();
        isEmpty = linkedStack.isEmpty();

        //Then
        assertTrue(isEmpty);
    }

    @Test
    void testGetSize() {
        //When
        int size = linkedStack.getSize();

        //Then
        assertEquals(6, size);

        //When
        linkedStack.pop();
        linkedStack.pop();
        size = linkedStack.getSize();

        //Then
        assertEquals(4, size);
    }
}