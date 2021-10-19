package com.naidiuk.stack;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import static org.junit.jupiter.api.Assertions.*;

class QStackTest {

    //Prepare
    QStack qStack = new QStack(3);

    @Test
    void testPushAndPop() {

        //When
        qStack.push(123);
        qStack.push("you");
        qStack.push('A');

        //Then
        assertEquals(3, qStack.getStackSize());
        assertFalse(qStack.isEmpty());
        assertEquals("123, you, A, ", qStack.toString());

        //When
        qStack.pop();

        //Then
        assertEquals(2, qStack.getStackSize());
        assertEquals("you, A, A, ", qStack.toString());

        //When
        qStack.push(1.23);
        qStack.push("hello");

        //Then
        assertEquals("you, A, 1.23, hello, null, null, ", qStack.toString());
        assertEquals(4, qStack.getStackSize());
    }

    @Test
    void testIsEmpty() {

        //When
        qStack.isEmpty();

        //Then
        assertTrue(qStack.isEmpty());

        //When
        qStack.push(123);
        qStack.push("you");
        qStack.push('A');

        //Then
        assertFalse(qStack.isEmpty());
    }

    @Test
    void testGetStackSize() {

        //When
        qStack.push(123);
        qStack.push("you");
        qStack.push('A');

        //Then
        assertEquals(3, qStack.getStackSize());
    }

    @Test
    void testToString() {

        //When
        qStack.push(123);
        qStack.push("you");
        qStack.push('A');

        //Then
        assertEquals("123, you, A, ", qStack.toString());
    }
}