package com.naidiuk.list;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayListTest {

    private final List<String> noSizedList = new ArrayList<>();
    private final List<String> sizedList = new ArrayList<>(3);

    @BeforeEach
    void setup() {
        noSizedList.add("123");
        noSizedList.add("3.21", 1);
        noSizedList.add(null, 1);
        noSizedList.add("hello");

        sizedList.add("789");
        sizedList.add("33.4567", 1);
        sizedList.add(null, 1);
    }

    @Test
    void testNoSizedListAdd() {
        //When
        int size = noSizedList.getSize();
        String noSizedListRetain = noSizedList.toString();
        noSizedList.add("789");
        noSizedList.add("33.4567", 1);
        int sizeAfterAdd = noSizedList.getSize();

        //Then
        assertEquals(4, size);
        assertEquals("{123, null, 3.21, hello, null, null, null, null, null, null}", noSizedListRetain);
        assertEquals(6, sizeAfterAdd);
        assertEquals("{123, 33.4567, null, 3.21, hello, 789, null, null, null, null}", noSizedList.toString());
    }

    @Test
    void testNoSizedListRemove() {
        //When
        int size = noSizedList.getSize();
        String firstRemoved = noSizedList.remove(1);
        String secondRemoved = noSizedList.remove(1);
        int sizeAfterRemove = noSizedList.getSize();

        //Then
        assertEquals(4, size);
        assertEquals(null, firstRemoved);
        assertEquals("3.21", secondRemoved);
        assertEquals(2, sizeAfterRemove);
    }

    @Test
    void testNoSizedListGetSize() {
        //When
        int size = noSizedList.getSize();
        noSizedList.remove(1);
        noSizedList.remove(1);
        noSizedList.remove(1);
        int sizeAfterRemove = noSizedList.getSize();
        String noSizedListRetain = noSizedList.toString();

        //Then
        assertEquals(4, size);
        assertEquals(1, sizeAfterRemove);
        assertEquals("{123, hello, hello, hello, null, null, null, null, null, null}", noSizedListRetain);
    }

    @Test
    void testNoSizedListIsEmpty() {
        //When
        boolean no = noSizedList.isEmpty();
        noSizedList.remove(0);
        noSizedList.remove(0);
        noSizedList.remove(0);
        noSizedList.remove(0);
        boolean yes = noSizedList.isEmpty();

        //Then
        assertEquals(false, no);
        assertEquals(true, yes);
    }

    @Test
    void testNoSizedListGetElement() {
        //When
        String first = noSizedList.getElement(0);
        String second = noSizedList.getElement(1);
        String third = noSizedList.getElement(2);
        String fourth = noSizedList.getElement(3);

        //Then
        assertEquals("123", first);
        assertEquals(null, second);
        assertEquals("3.21", third);
        assertEquals("hello", fourth);
    }

    @Test
    void testNoSizedListContains() {
        //When
        boolean yes = noSizedList.contains(null);
        boolean no = noSizedList.contains("789");

        //Then
        assertEquals(true, yes);
        assertEquals(false, no);
    }

    @Test
    void testSizedListAdd() {
        //When
        int size = sizedList.getSize();
        String sizedListRentain = sizedList.toString();
        sizedList.add("danger");
        int sizeAfterAdd = sizedList.getSize();
        String overSizedListRetain = sizedList.toString();

        //Then
        assertEquals(3, size);
        assertEquals("{789, null, 33.4567}", sizedListRentain);
        assertEquals(4, sizeAfterAdd);
        assertEquals("{789, null, 33.4567, danger, null, null}", overSizedListRetain);
    }

    @Test
    void testSizedListRemove() {
        //When
        String removed = sizedList.remove(2);
        String sizedListRetain = sizedList.toString();

        //Then
        assertEquals("33.4567", removed);
        assertEquals("{789, null, 33.4567}", sizedListRetain);
    }

    @Test
    void testSizedListGetSize() {
        //When
        int size = sizedList.getSize();
        sizedList.remove(2);
        sizedList.remove(1);
        sizedList.remove(0);
        int sizeAfterRemove = sizedList.getSize();

        //Then
        assertEquals(3, size);
        assertEquals(0, sizeAfterRemove);
    }

    @Test
    void testSizedListIsEmpty() {
        //When
        boolean no = sizedList.isEmpty();
        sizedList.remove(2);
        sizedList.remove(1);
        sizedList.remove(0);
        boolean yes = sizedList.isEmpty();

        //Then
        assertEquals(false, no);
        assertEquals(true, yes);
    }

    @Test
    void testSizedListGetElement() {
        //When
        String second = sizedList.getElement(1);

        //Then
        assertEquals(null, second);
    }

    @Test
    void testSizedListContains() {
        //When
        boolean yes = sizedList.contains(null);
        boolean no = sizedList.contains("123");

        //Then
        assertTrue(yes);
        assertFalse(no);
    }
}
