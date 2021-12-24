package com.naidiuk.map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {
    public final Map map = new HashMap();

    @Test
    void testPut() {
        //prepare
        Object val, val1, val2, val3, val4, val5;

        //when
        val = map.put(0, 0);
        val1 = map.put("id", 1111);
        val2 = map.put("login", "user");
        val3 = map.put(null, 3.22);
        val4 = map.put(0, "asdf");
        val5 = map.put(null, 0);

        //then
        assertNull(val);
        assertNull(val1);
        assertNull(val2);
        assertNull(val3);
        assertEquals(0, val4);
        assertEquals(3.22, val5);
    }

    @Test
    void testPutIfAbsent() {
        //prepare
        Object val, val1, val2, val3;
        map.put(0, 0);
        map.put("id", '1');
        map.put("login", "user");
        map.put(null, 3.22);

        //when
        val = map.putIfAbsent("login", "dikiydemon");
        val1 = map.putIfAbsent(null, null);
        val2 = map.putIfAbsent("name", "Oleh");
        val3 = map.putIfAbsent('A', 2);

        //then
        assertEquals("user", val);
        assertEquals(3.22, val1);
        assertNull(val2);
        assertNull(val3);
    }

    @Test
    void testGet() {
        //prepare
        Object val, val1, val2, val3, val4, val5;
        map.put(0, 0);
        map.put("id", 1111);
        map.put("login", "user");
        map.put(null, 3.22);

        //when
        val = map.get(0);
        val1 = map.get("id");
        val2 = map.get("login");
        val3 = map.get(null);
        val4 = map.get("name");
        val5 = map.get('G');

        //then
        assertEquals(0, val);
        assertEquals(1111, val1);
        assertEquals("user", val2);
        assertEquals(3.22, val3);
        assertNull(val4);
        assertNull(val5);
    }

    @Test
    void testSize() {
        //prepare
        map.put(0, 0);
        map.put("id", 1111);
        map.put("login", "user");
        map.put(null, 3.22);
        map.putIfAbsent("name", "Oleh");
        map.putIfAbsent('A', 2);

        //when
        int size = map.size();
        map.putIfAbsent(null, null);
        int sizeAfterPutIfAbsent = map.size();

        //then
        assertEquals(6, size);
        assertEquals(6, sizeAfterPutIfAbsent);
    }

    @Test
    void testIsEmpty() {
        //prepare
        boolean empty, notEmpty;
        map.put(0, 0);
        map.put("id", 1111);
        map.put("login", "user");
        map.put(null, 3.22);

        //when
        notEmpty = map.isEmpty();
        map.remove(0);
        map.remove("id");
        map.remove("login");
        map.remove(null);
        empty = map.isEmpty();

        //then
        assertFalse(notEmpty);
        assertTrue(empty);
    }

    @Test
    void testRemove() {
        //prepare
        Object val, val1, val2, val3, val4, val5;
        map.put(0, 0);
        map.put("id", 1111);
        map.put("login", "user");
        map.put(null, 3.22);

        //when
        val = map.remove("name");
        val1 = map.remove(3.22);
        val2 = map.remove(0);
        val3 = map.remove("id");
        val4 = map.remove("login");
        val5 = map.remove(null);

        //then
        assertNull(val);
        assertNull(val1);
        assertEquals(0, val2);
        assertEquals(1111, val3);
        assertEquals("user", val4);
        assertEquals(3.22, val5);
    }

    @Test
    void testContainsKey() {
        //prepare
        map.put(0, 0);
        map.put("id", 1111);
        map.put("login", "user");
        map.put(null, 3.22);

        //then
        assertTrue(map.containsKey(0));
        assertTrue(map.containsKey("id"));
        assertTrue(map.containsKey("login"));
        assertTrue(map.containsKey(null));
        assertFalse(map.containsKey("name"));
        assertFalse(map.containsKey(3425));
        assertFalse(map.containsKey(6.66));
    }

    @Test
    void testContainsValue() {
        //prepare
        map.put(0, 0);
        map.put("id", 1111);
        map.put("login", "user");
        map.put(null, 3.22);

        //then
        assertTrue(map.containsValue(0));
        assertTrue(map.containsValue(1111));
        assertTrue(map.containsValue("user"));
        assertTrue(map.containsValue(3.22));
        assertFalse(map.containsValue(null));
        assertFalse(map.containsValue('S'));
    }
}