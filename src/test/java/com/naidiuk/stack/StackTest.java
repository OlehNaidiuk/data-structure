package com.naidiuk.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack stack = new Stack(3);

    @BeforeEach
    public void setUp() {
        stack.push("gfgjfdhj");
        stack.push(23452345);
        stack.push('H');
    }

    @Test
    void testPop() {
        stack.pop();
        assertEquals(2, stack.getStackSize());
        assertFalse(stack.isEmpty());
        stack.pop();
        stack.pop();
        assertEquals(0, stack.getStackSize());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPush() {
        stack.push(5345.12);
        assertFalse(stack.isEmpty());
        assertEquals(4, stack.getStackSize());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(stack.isEmpty());
        stack.pop();
        stack.pop();
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testGetStackSize() {
        assertEquals(3, stack.getStackSize());
        stack.pop();
        stack.pop();
        stack.pop();
        assertEquals(0, stack.getStackSize());
    }

    @Test
    public void testToString() {
        assertEquals("gfgjfdhj, 23452345, H, ", stack.toString());
    }
}