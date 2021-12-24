package com.naidiuk.map;

public interface Map {
    Object put(Object key, Object value);
    Object putIfAbsent(Object key, Object value);
    Object get(Object key);
    int size();
    boolean isEmpty();
    Object remove(Object key);
    boolean containsKey(Object key);
    boolean containsValue(Object value);
}
