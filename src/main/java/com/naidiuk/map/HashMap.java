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
        if (size == entries.length) {
            reSize();
        }
        int index = findIndex(key);
        Entry<K, V> first = entries[index];
        Entry<K, V> entry = new Entry<>(key, value);
        if (first != null) {
            while (first != null) {
                if ((key == first.getKey()) || (key != null && key.equals(first.getKey()))) {
                    V oldValue = first.getValue();
                    first.setValue(value);
                    return oldValue;
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

    @Override
    public V putIfAbsent(K key, V value) {
        if (size == entries.length) {
            reSize();
        }
        int index = findIndex(key);
        Entry<K, V> first = entries[index];
        Entry<K, V> entry = new Entry<>(key, value);
        if (first != null) {
            while (first != null) {
                if ((key == first.getKey()) || (key != null && key.equals(first.getKey()))) {
                    return first.getValue();
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

    @Override
    public V get(K key) {
        Entry<K, V> first = entries[findIndex(key)];
        if (first != null) {
            while (first != null) {
                if ((key == first.getKey()) || (key != null && key.equals(first.getKey()))) {
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
            entries[i] = null;
        }
        size = 0;
    }

    @Override
    public void putAll(Map<K, V> map) {
        Set<Entry<K, V>> mapSet = map.entrySet();
        for (Entry<K, V> entry : mapSet) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> result = new HashSet<>();
        for (Entry<K, V> entry : entries) {
            if (entry != null) {
                while (entry != null) {
                    result.add(entry);
                    entry = entry.getNext();
                }
            }
        }
        return result;
    }

    @Override
    public V remove(Object key) {
        int index = findIndex(key);
        Entry<K, V> first = entries[index];
        if (first != null) {
            Entry<K, V> previous = null;
            while (first != null) {
                if ((key == first.getKey()) || (key != null && key.equals(first.getKey()))) {
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
    public boolean containsKey(Object key) {
        Entry<K, V> first = entries[findIndex(key)];
        if (first != null) {
            while (first != null) {
                if ((key == first.getKey()) || (key != null && key.equals(first.getKey()))) {
                    return true;
                }
                first = first.getNext();
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry<K, V> entry : entries) {
            if (entry != null) {
                while (entry != null) {
                    if ((value == entry.getValue()) || (value != null && value.equals(entry.getValue()))) {
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

    private int findIndex(Object key) {
        return key == null ? 0 : key.hashCode() % entries.length;
    }

    private void reSize() {
        Entry<K, V>[] reSizedArray = (Entry<K, V>[]) new Entry[entries.length * 2];
        int index;
        K key;
        for (Entry<K, V> entry : entries) {
            if (entry != null) {
                key = entry.getKey();
                index = key == null ? 0 : key.hashCode() % reSizedArray.length;
                reSizedArray[index] = entry;
            }
        }
        entries = reSizedArray;
    }
}
