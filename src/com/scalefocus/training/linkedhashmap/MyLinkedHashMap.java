package com.scalefocus.training.linkedhashmap;

import com.scalefocus.training.MyMap;

/**
 * @author Kristiyan SLavov
 */
public class MyLinkedHashMap<K, V> implements MyMap<K, V> {

    private LinkedHashMapEntry<K, V>[] buckets;

    private LinkedHashMapEntry<K, V> header;

    private LinkedHashMapEntry<K, V> tail;

    private int size = 0;

    private static final int INITIAL_CAPACITY = 16;

    private static final double LOAD_FACTOR = 0.75;

    public MyLinkedHashMap() {
        buckets = new LinkedHashMapEntry[INITIAL_CAPACITY];
    }

    public MyLinkedHashMap(int capacity) {
        buckets = new LinkedHashMapEntry[capacity];
    }

    /**
     * This method adds the specified value associated with the specified key in the map.
     * The map is an array of entries(key-value pair) and every entry can be a double linked list of entries.
     * If the map is filled at 75%, it's capacity is doubled.
     * K is the type of the key.
     * V is the type of the value.
     *
     * @param key   - the key with which the specified value is associated
     * @param value - the value to be associated with the specified key
     */
    public void put(K key, V value) {
        LinkedHashMapEntry<K, V> newEntry = new LinkedHashMapEntry<K, V>(key, value);
        int index = getBucketIndex(key);

        if (header == null) {
            header = newEntry;
            tail = newEntry;
            buckets[index] = newEntry;
            ++size;
        } else {
            LinkedHashMapEntry<K, V> tempEntry = buckets[index];
            if (tempEntry == null) {
                buckets[index] = newEntry;
                tail.setAfter(newEntry);
                newEntry.setBefore(tail);
                tail = newEntry;
                ++size;
            } else {
                if (tempEntry.getKey().equals(key)) {
                    tempEntry.setValue(value);
                    return;
                }
                while (tempEntry.getNext() != null) {
                    if (tempEntry.getNext().getKey().equals(key)) {
                        tempEntry.setValue(value);
                        return;
                    }
                    tempEntry = tempEntry.getNext();
                }
                tempEntry.setNext(newEntry);
                newEntry.setBefore(tail);
                tail.setAfter(newEntry);
                tail = newEntry;
                ++size;
            }
        }
        double curLoadFactor = (1.0 * size / buckets.length);
        if (curLoadFactor > LOAD_FACTOR) {
            rehash();
        }
    }

    /**
     * This method removes the entry for the specified key if the map contains this key.
     * K is the type of the key.
     * V is the returned type of the value to which the specified key is mapped.
     *
     * @param key - the key with which the specified value is associated
     * @return the value to which the specified key is mapped, or null if this map doesn't contain this key
     */
    public V remove(K key) {
        int index = getBucketIndex(key);
        LinkedHashMapEntry<K, V> head = buckets[index];
        LinkedHashMapEntry<K, V> target = null;

        if (head.getKey().equals(key)) {
            target = head;
            if (head.getNext() != null) {
                buckets[index] = head.getNext();
                buckets[index].setBefore(target.getBefore());
                target.getBefore().setAfter(buckets[index]);
            } else {
                buckets[index] = null;
                target.getBefore().setAfter(target.getAfter());
                target.getAfter().setBefore(target.getBefore());
            }
            --size;
            return target.getValue();
        }
        while (head != null) {
            if (head.getNext().getKey().equals(key)) {
                target = head.getNext();
                head.setNext(target.getNext());
                head.setAfter(target.getAfter());
                target.getAfter().setBefore(head);
                --size;
                return target.getValue();
            }
            head = head.getNext();
        }
        return null;
    }

    /**
     * This method returns the value to which the specified key is mapped
     * or null if this map doesn't contain the specified key.
     * K is the type of the key.
     * V is the type of the value.
     *
     * @param key - the key whose associated value is to be returned
     * @return the value to which the specified key is mapped
     * or null if the map doesn't contain the specified key
     */
    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedHashMapEntry<K, V> head = buckets[index];
        while (head != null) {
            if (head.getKey().equals(key)) {
                return head.getValue();
            }
            head = head.getNext();
        }
        return null;
    }

    /**
     * This method returns true if the map contains the specified key.
     *
     * @param key - the specified element to be search for in the list.
     * @return true if the map contains the specified key or false if it does not.
     */
    public boolean contains(K key) {
        if (get(key) != null) {
            return true;
        }
        return false;
    }

    /**
     * This method doubles the capacity of the map and
     * recalculates the indexes where the key-value pairs will be stored.
     */
    private void rehash() {
        LinkedHashMapEntry<K, V> currentEntry = header;
        header = null;
        buckets = new LinkedHashMapEntry[buckets.length * 2];
        size = 0;

        while (currentEntry.getAfter() != null) {
            put(currentEntry.getKey(), currentEntry.getValue());
            currentEntry = currentEntry.getAfter();
        }
        put(currentEntry.getKey(), currentEntry.getValue());
    }

    /**
     * This method returns the index(bucket) where the key-value pair will be stored.
     * K is the type of the key.
     *
     * @param key - the key whose hashcode will be used to calculate the index.
     * @return the index where the specified value associated with the specified key will be stored.
     */
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode & (buckets.length - 1);
    }

    /**
     * This method prints all the key-value pairs from the map.
     */
    public void print() {
        LinkedHashMapEntry<K, V> head = header;
        while (head != null) {
            System.out.println("Key: " + head.getKey() + " | " + "Value = " + head.getValue());
            head = head.getAfter();
        }
    }

    /**
     * This method returns the count of the key-value pairs from the map.
     *
     * @return the count of the key-value pairs
     */
    public int size() {
        return size;
    }

    /**
     * This method returns the length of the map.
     *
     * @return the map's length
     */
    public int length() {
        return buckets.length;
    }
}
