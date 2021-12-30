package com.naidiuk.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    private final Stack<String> noSizedStack = new ArrayStack<>();
    private final Stack<String> sizedStack = new ArrayStack<>(2);

    @BeforeEach
    void setup() {
        noSizedStack.push("Hi");
        noSizedStack.push("Stas!");
        noSizedStack.push("There");
        noSizedStack.push("are");

        sizedStack.push("3.22");
        sizedStack.push("123");
    }

    @Test
    void testNoSizeStackPushAndPop() {
        //When
        noSizedStack.push("my");
        noSizedStack.push("tests.");
        String lastElement = noSizedStack.pop();
        String prelastElement = noSizedStack.pop();

        //Then
        assertEquals("tests.", lastElement);
        assertEquals("my", prelastElement);
    }

    @Test
    void testNoSizeStackIsEmpty() {
        //When
        boolean no = noSizedStack.isEmpty();
        noSizedStack.pop();
        noSizedStack.pop();
        noSizedStack.pop();
        noSizedStack.pop();
        boolean yes = noSizedStack.isEmpty();

        //Then
        assertFalse(no);
        assertTrue(yes);
    }

    @Test
    void testNoSizeStackGetSize() {
        //When
        int size = noSizedStack.getSize();
        noSizedStack.pop();
        noSizedStack.pop();
        noSizedStack.pop();
        int sizeAfterPop = noSizedStack.getSize();

        //Then
        assertEquals(4, size);
        assertEquals(1, sizeAfterPop);
    }

    @Test
    void testSizedStackPushAndPop() {
        //When
        sizedStack.push("Hi");
        sizedStack.push("Stas!");
        sizedStack.push("This is");
        sizedStack.push("Oleh.");

        //Then
        assertEquals(6, sizedStack.getSize());
        assertEquals("Oleh.", sizedStack.pop());
        assertEquals("This is", sizedStack.pop());
        assertEquals(4, sizedStack.getSize());
        assertEquals("Stas!", sizedStack.pop());
    }

    @Test
    void testSizedStackIsEmpty() {
        assertFalse(sizedStack.isEmpty());

        //When
        sizedStack.pop();
        sizedStack.pop();

        //Then
        assertTrue(sizedStack.isEmpty());
    }

    @Test
    void testSizedStackGetSize() {
        assertEquals(2, sizedStack.getSize());

        //When
        sizedStack.push("There are my");
        sizedStack.push("tests.");
        sizedStack.pop();

        //Then
        assertEquals(3, sizedStack.getSize());
    }
}