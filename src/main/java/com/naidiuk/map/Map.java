package com.naidiuk.map;

import java.util.Set;

public interface Map<K, V> {
    V put(K key, V value);
    V putIfAbsent(K key, V value);
    V get(K key);
    int size();
    boolean isEmpty();
    V remove(K key);
    boolean containsKey(K key);
    boolean containsValue(V value);
    void clear();
    void putAll(Map <K, V> map);
    Set<Entry<K, V>> entrySet();

}
