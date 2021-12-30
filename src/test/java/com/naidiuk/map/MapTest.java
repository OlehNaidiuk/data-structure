package com.naidiuk.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    private final Map<String, Integer> map = new HashMap<>();

    @BeforeEach
    void setup(){
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
    }

    @Test
    void testPut() {
        //prepare
        Object val, val1, val2, val3, val4, val5;
        String toString;

        //when
        val = map.put("five", 5);
        val1 = map.put("six", 6);
        val2 = map.put("seven", 7);
        val3 = map.put(null, 8);
        val4 = map.put("nine", 9);
        val5 = map.put(null, null);
        toString = map.toString();

        //then
        assertNull(val);
        assertNull(val1);
        assertNull(val2);
        assertNull(val3);
        assertNull(val4);
        assertEquals(8, val5);
        assertEquals("{null=null, six=6, one=1, seven=7, nine=9, five=5, three=3, two=2, zero=0, four=4}", toString);
    }

    @Test
    void testPutIfAbsent() {
        //prepare
        Object val, val1, val2, val3;

        //when
        val = map.putIfAbsent("five", 5);
        val1 = map.putIfAbsent(null, null);
        val2 = map.putIfAbsent("zero", 10);
        val3 = map.putIfAbsent("four", 22);

        //then
        assertNull(val);
        assertNull(val1);
        assertEquals(0, val2);
        assertEquals(4, val3);
    }

    @Test
    void testGet() {
        //prepare
        Object val, val1, val2, val3, val4;

        //when
        val = map.get("zero");
        val1 = map.get("one");
        val2 = map.get("two");
        val3 = map.get("three");
        val4 = map.get("ten");

        //then
        assertEquals(0, val);
        assertEquals(1, val1);
        assertEquals(2, val2);
        assertEquals(3, val3);
        assertNull(val4);
    }

    @Test
    void testSize() {
        //prepare
        int size, sizeAfterRemove;

        //when
        size = map.size();
        map.remove("zero");
        map.remove("four");
        sizeAfterRemove = map.size();

        //then
        assertEquals(5, size);
        assertEquals(3, sizeAfterRemove);
    }

    @Test
    void testIsEmpty() {
        //prepare
        boolean empty, notEmpty;

        //when
        notEmpty = map.isEmpty();
        map.clear();
        empty = map.isEmpty();

        //then
        assertFalse(notEmpty);
        assertTrue(empty);
    }

    @Test
    void testRemove() {
        //prepare
        Object val, val1, val2, val3, val4, val5;

        //when
        val = map.remove("zero");
        val1 = map.remove("one");
        val2 = map.remove("two");
        val3 = map.remove("three");
        val4 = map.remove("four");
        val5 = map.remove(null);

        //then
        assertEquals(0, val);
        assertEquals(1, val1);
        assertEquals(2, val2);
        assertEquals(3, val3);
        assertEquals(4, val4);
        assertNull(val5);
    }

    @Test
    void testContainsKey() {
        assertTrue(map.containsKey("zero"));
        assertTrue(map.containsKey("one"));
        assertTrue(map.containsKey("two"));
        assertTrue(map.containsKey("three"));
        assertFalse(map.containsKey("five"));
        assertFalse(map.containsKey(null));
        assertFalse(map.containsKey("six"));
    }

    @Test
    void testContainsValue() {
        assertTrue(map.containsValue(0));
        assertTrue(map.containsValue(1));
        assertTrue(map.containsValue(2));
        assertTrue(map.containsValue(3));
        assertFalse(map.containsValue(null));
        assertFalse(map.containsValue(22));
    }

    @Test
    void testClear() {
        //prepare
        int size, sizeAfterClear;
        String toString;

        //when
        size = map.size();
        map.clear();
        sizeAfterClear = map.size();
        toString = map.toString();

        //then
        assertEquals(5, size);
        assertEquals(0, sizeAfterClear);
        assertEquals("{}", toString);
    }

    @Test
    void testPutAll() {
        //prepare
        Object val, val1, val2;
        String toString;
        Map<String, Integer> destinationMap = new HashMap<>();
        destinationMap.put("zero", 110);
        destinationMap.put("three", 33);
        destinationMap.put("five", 5);
        destinationMap.put("six", 6);
        destinationMap.put(null, null);
        destinationMap.put("eight", 8);
        destinationMap.put("nine", 9);
        destinationMap.put("ten", 10);

        //when
        map.putAll(destinationMap);
        val = map.get("zero");
        val1 = map.get("three");
        val2 = map.get("ten");
        toString = map.toString();

        //then
        assertEquals(110, val);
        assertEquals(33, val1);
        assertEquals(10, val2);
        assertEquals("{null=null, six=6, one=1, nine=9, five=5, three=33, two=2, zero=110, four=4, ten=10, eight=8}", toString);
    }

    @Test
    void testEntrySet() {
        //prepare
        Set<Entry<String, Integer>> mapSet = map.entrySet();
        String toString;

        //when
        toString = mapSet.toString();

        //then
        assertEquals("[two=2, three=3, zero=0, four=4, one=1]", toString);
    }
}