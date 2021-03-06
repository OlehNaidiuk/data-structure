package com.naidiuk.map;

import java.util.*;

public class HashMap<K, V> implements Map<K, V> {
    private Entry<K, V>[] entries;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private int size;

    public HashMap() {
        entries = (Entry<K, V>[]) new Entry[DEFAULT_INITIAL_CAPACITY];
    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> entry = addEntry(key, value);
        if (entry != null) {
            V oldValue = entry.getValue();
            entry.setValue(value);
            return oldValue;
        }
        return null;
    }

    @Override
    public V putIfAbsent(K key, V value) {
        Entry<K, V> entry = addEntry(key, value);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    @Override
    public V get(K key) {
        Entry<K, V> first = entries[findIndex(key)];
        if (first != null) {
            while (first != null) {
                if (key == first.getKey() || (key != null && key.equals(first.getKey()))) {
                    return first.getValue();
                }
                first = first.getNext();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null) {
                entries[i] = null;
            }
        }
        size = 0;
    }

    @Override
    public void putAll(Map<K, V> map) {
        for (Entry<K, V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();
        for (Entry<K, V> entry : entries) {
            if (entry != null) {
                while (entry != null) {
                    entrySet.add(entry);
                    entry = entry.getNext();
                }
            }
        }
        return entrySet;
    }

    @Override
    public V remove(K key) {
        int index = findIndex(key);
        Entry<K, V> first = entries[index];
        if (first != null) {
            Entry<K, V> previous = null;
            while (first != null) {
                if (key == first.getKey() || (key != null && key.equals(first.getKey()))) {
                    if (previous == null) {
                        entries[index] = first.getNext();
                    } else {
                        previous.setNext(first.getNext());
                    }
                    size--;
                    return first.getValue();
                }
                previous = first;
                first = first.getNext();
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        Entry<K, V> first = entries[findIndex(key)];
        if (first != null) {
            while (first != null) {
                if (key == first.getKey() || (key != null && key.equals(first.getKey()))) {
                    return true;
                }
                first = first.getNext();
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (Entry<K, V> entry : entries) {
            if (entry != null) {
                while (entry != null) {
                    if (value == entry.getValue() || (value != null && value.equals(entry.getValue()))) {
                        return true;
                    }
                    entry = entry.getNext();
                }
            }
        }
        return false;
    }

    public String toString() {
        StringJoiner result = new StringJoiner(", ", "{", "}");
        for (Entry<K, V> entry : entries) {
            if (entry != null) {
                while (entry != null) {
                    result.add(entry.toString());
                    entry = entry.getNext();
                }
            }
        }
        return result.toString();
    }

    private int findIndex(K key) {
        return key == null ? 0 : key.hashCode() % entries.length;
    }

    private int findIndex(Entry<K, V> entry) {
        K key = entry.getKey();
        return key == null ? 0 : key.hashCode() % (entries.length * 2);
    }

    private void reSize() {
        Entry<K, V>[] reSizedArray = (Entry<K, V>[]) new Entry[entries.length * 2];
        for (Entry<K, V> entry : entries) {
            if (entry != null) {
                while (entry != null) {
                    int index = findIndex(entry);
                    Entry<K, V> first = entry;
                    entry = entry.getNext();
                    first.setNext(null);
                    if (reSizedArray[index] != null) {
                        Entry<K, V> next = reSizedArray[index];
                        first.setNext(next);
                    }
                    reSizedArray[index] = first;
                }
            }
        }
        entries = reSizedArray;
    }

    private Entry<K, V> addEntry(K key, V value) {
        if (size == (int) (entries.length * 0.75)) {
            reSize();
        }
        int index = findIndex(key);
        Entry<K, V> first = entries[index];
        Entry<K, V> entry = new Entry<>(key, value);
        if (first != null) {
            while (first != null) {
                if (key == first.getKey() || (key != null && key.equals(first.getKey()))) {
                    return first;
                }
                first = first.getNext();
            }
            first = entries[index];
            entry.setNext(first);
        }
        entries[index] = entry;
        size++;
        return null;
    }
}
