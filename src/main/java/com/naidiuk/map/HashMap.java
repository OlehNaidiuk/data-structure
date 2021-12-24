package com.naidiuk.map;

public class HashMap implements Map {
    private final Entry[] entries;
    private int size;

    public HashMap() {
        entries = new Entry[10];
    }

    @Override
    public Object put(Object key, Object value) {
        Entry entry = new Entry(key, value);
        int index = findIndex(key);
        Entry first = entries[index];
        if (first != null) {
            while (first != null) {
                if ((key == first.getKey()) || (key != null && key.equals(first.getKey()))) {
                    Object oldValue = first.getValue();
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
    public Object putIfAbsent(Object key, Object value) {
        Entry entry = new Entry(key, value);
        int index = findIndex(key);
        Entry first = entries[index];
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
    public Object get(Object key) {
        Entry first = entries[findIndex(key)];
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
    public Object remove(Object key) {
        int index = findIndex(key);
        Entry first = entries[index];
        if (first != null) {
            Entry previous = null;
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
        Entry first = entries[findIndex(key)];
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
        for (Entry entry : entries) {
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

    private int findIndex(Object key) {
        return key == null ? 0 : key.hashCode() % entries.length;
    }
}
