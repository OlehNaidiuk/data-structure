package com.naidiuk.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ArrayListTest {

    private final ListInterface noSizedList = new ArrayList();
    private final ListInterface sizedList = new ArrayList(3);

    @Test
    void testNoSizedListAdd() {
        //Prepare
        noSizedList.add(123);
        noSizedList.add(3.21, 1);
        noSizedList.add(null, 1);
        noSizedList.add("hello");

        //When
        String noSizedListContains = noSizedList.toString();
        int size = noSizedList.getSize();

        //Then
        assertEquals("[123, null, 3.21, hello, null, null, null, null, null, null]", noSizedListContains);
        assertEquals(4, size);
    }

    @Test
    void testNoSizedListRemove() {
        //Prepare
        noSizedList.add(123);
        noSizedList.add(3.21, 1);
        noSizedList.add(null, 1);
        noSizedList.add("hello");

        //When
        int size = noSizedList.getSize();
        Object removed = noSizedList.remove(1);
        int sizeAfterRemove = noSizedList.getSize();
        Object second = noSizedList.getElement(1);


        //Then
        assertEquals(4, size);
        assertEquals(null, removed);
        assertEquals(3, sizeAfterRemove);
        assertEquals(3.21, second);
    }

    @Test
    void testNoSizedListGetSize() {
        //Prepare
        noSizedList.add(123);
        noSizedList.add(3.21, 1);
        noSizedList.add(null, 1);
        noSizedList.add("hello");

        //When
        int size = noSizedList.getSize();
        noSizedList.remove(1);
        noSizedList.remove(1);
        noSizedList.remove(1);
        int sizeAfterRemove = noSizedList.getSize();
        String noSizedListContains = noSizedList.toString();

        //Then
        assertEquals(4, size);
        assertEquals(1, sizeAfterRemove);
        assertEquals("[123, null, null, null, null, null, null, null, null, null]", noSizedListContains);
    }

    @Test
    void testNoSizedListIsEmpty() {
        //Prepare
        noSizedList.add(123);
        noSizedList.add(3.21, 1);
        noSizedList.add(null, 1);
        noSizedList.add("hello");

        //When
        boolean no = noSizedList.isEmpty();
        noSizedList.remove(0);
        noSizedList.remove(0);
        noSizedList.remove(0);
        noSizedList.remove(0);
        boolean yes = noSizedList.isEmpty();

        //Then
        assertFalse(no);
        assertTrue(yes);
    }

    @Test
    void testNoSizedListGetElement() {
        //Prepare
        noSizedList.add(123);
        noSizedList.add(3.21, 1);
        noSizedList.add(null, 1);
        noSizedList.add("hello");

        //When
        Object first = noSizedList.getElement(0);
        Object second = noSizedList.getElement(1);
        Object third = noSizedList.getElement(2);
        Object fourth = noSizedList.getElement(3);
        int size = noSizedList.getSize();

        //Then
        assertEquals(123, first);
        assertEquals(null, second);
        assertEquals(3.21, third);
        assertEquals("hello", fourth);
        assertEquals(4, size);
    }

    @Test
    void testNoSizedListContains() {
        //Prepare
        noSizedList.add(123);
        noSizedList.add(3.21, 1);
        noSizedList.add(null, 1);
        noSizedList.add("hello");

        //When
        boolean yes = noSizedList.contains("hello");
        boolean offcourse = noSizedList.contains(null);
        boolean no = noSizedList.contains(789);

        //Then
        assertTrue(yes);
        assertTrue(offcourse);
        assertFalse(no);
    }

    @Test
    void testSizedListAdd() {
        //Prepare
        sizedList.add(789);
        sizedList.add(33.4567, 1);
        sizedList.add(null, 1);

        //When
        int size = sizedList.getSize();
        String sizedListContains = sizedList.toString();
        sizedList.add("danger");
        String overSizedListContains = sizedList.toString();

        //Then
        assertEquals(3, size);
        assertEquals("[789, null, 33.4567]", sizedListContains);
        assertEquals("[789, null, 33.4567, danger, null, null]", overSizedListContains);
    }

    @Test
    void testSizedListRemove() {
        //Prepare
        sizedList.add(789);
        sizedList.add(33.4567, 1);
        sizedList.add(null, 1);

        //When
        Object removed = sizedList.remove(2);
        int size = sizedList.getSize();

        //Then
        assertEquals(33.4567, removed);
        assertEquals(2, size);
    }

    @Test
    void testSizedListGetSize() {
        //Prepare
        sizedList.add(789);

        //When
        int size = sizedList.getSize();

        //Then
        assertEquals(1, size);
    }

    @Test
    void testSizedListIsEmpty() {
        //When
        boolean flag = sizedList.isEmpty();
        sizedList.add(789);
        boolean no = sizedList.isEmpty();

        //Then
        assertTrue(flag);
        assertFalse(no);
    }

    @Test
    void testSizedListGetElement() {
        //Prepare
        sizedList.add(789);
        sizedList.add(33.4567, 1);
        sizedList.add(null, 1);

        //When
        Object second = sizedList.getElement(1);

        //Then
        assertEquals(null, second);
    }

    @Test
    void testSizedListContains() {
        //Prepare
        sizedList.add(789);
        sizedList.add(33.4567, 1);
        sizedList.add(null, 1);

        //When
        boolean flag = sizedList.contains(null);
        boolean no = sizedList.contains(123);

        //Then
        assertTrue(flag);
        assertFalse(no);
    }
}
