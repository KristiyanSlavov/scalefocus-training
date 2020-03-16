package com.scalefocus.training.collection.hashmap;
import com.scalefocus.training.collection.common.MyMap;
/**
 * @author Kristiyan SLavov
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    private HashMapEntry<K, V>[] buckets;

    private int size = 0;

    private static final int INITIAL_CAPACITY = 16;

    private static final double LOAD_FACTOR = 0.75;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public MyHashMap() {
        buckets = (HashMapEntry<K, V>[]) new HashMapEntry[INITIAL_CAPACITY];
    }

    public MyHashMap(int capacity) {
        buckets = new HashMapEntry[capacity];
    }

    /**
     * This method adds the specified value associated with the specified key in the map.
     * The map is an array that contain entries(key-value pair) and every entry can be a linked list of entries.
     * If the map is filled at 75%, it's capacity is doubled.
     * K is the type of the key.
     * V is the type of the value.
     *
     * @param key   - the key with which the specified value is associated
     * @param value - the value to be associated with the specified key
     */
    public void put(K key, V value) {
        HashMapEntry<K, V> entry = new HashMapEntry<>(key, value);

        if (entry.getKey() == null) {
            putNullKeyEntry(entry);
            return;
        }

        int index = getBucketIndex(key);
        HashMapEntry<K, V> existingEntry = buckets[index];

        if (existingEntry == null) {
            buckets[index] = entry;
        } else {
            if (key.equals(existingEntry.getKey())) {
                existingEntry.setValue(value);
                return;
            }
            while (existingEntry.getNext() != null) {
                if (key.equals(existingEntry.getNext().getKey())) {
                    existingEntry.getNext().setValue(value);
                    return;
                }
                existingEntry = existingEntry.getNext();
            }
            existingEntry.setNext(entry);
        }
        ++size;

        double curLoadFactor = (1.0 * size / buckets.length);
        if (curLoadFactor > LOAD_FACTOR) {
            rehash();
        }
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
        if (key == null) {
            return getNullKeyEntry();
        }
        int index = getBucketIndex(key);
        HashMapEntry<K, V> head = buckets[index];
        while (head != null) {
            if (key.equals(head.getKey())) {
                return head.getValue();
            }
            head = head.getNext();
        }
        return null;
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
        V value;
        if (key == null) {
            return removeNullKeyEntry();
        }
        int index = getBucketIndex(key);
        HashMapEntry<K, V> head = buckets[index];
        boolean hasNext = head.getNext() != null;

        if (key.equals(head.getKey())) {
            value = head.getValue();
            buckets[index] = hasNext ? head.getNext() : null;
            --size;
            return value;
        }
        while (head != null) {
            if (key.equals(head.getNext().getKey())) {
                value = head.getNext().getValue();
                head.setNext(head.getNext().getNext());
                --size;
                return value;
            }
            head = head.getNext();
        }
        return null;
    }

    /**
     * This method returns true if the map contains the specified key.
     *
     * @param key - the specified key to be search for in the list.
     * @return true if the map contains the specified key or false if it does not.
     */
    public boolean contains(K key) {
        return get(key) != null;
    }

    /**
     * This method returns the index(bucket) where the key-value pair will be stored.
     * K is the type of the key.
     *
     * @param key - the key whose hashcode will be used to calculate the index.
     * @return the index where the specified value associated with the specified key will be stored.
     */
    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        return hashCode & (buckets.length - 1);
    }

    /**
     * This method doubles the capacity of the map and
     * recalculates the indexes where the key-value pairs will be stored.
     */
    private void rehash() {
        HashMapEntry<K, V>[] temp = buckets;
        buckets = new HashMapEntry[buckets.length * 2];
        size = 0;

        for (int i = 0; i < temp.length; i++) {
            HashMapEntry<K, V> head = temp[i];
            while (head != null) {
                K key = head.getKey();
                V value = head.getValue();

                put(key, value);
                head = head.getNext();
            }
        }
    }

    /**
     * This method prints all the key-value pairs from the map.
     */
    public void print() {
        for (int i = 0; i < buckets.length; i++) {
            HashMapEntry<K, V> head = buckets[i];
            while (head != null) {
                System.out.println("Index: " + i + " | " + "Key = " +
                        head.getKey() + " | " + "Value = " + head.getValue());
                head = head.getNext();
            }
        }
        System.out.println();
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

    /**
     * This method returns true if the map contains no key-value mappings.
     *
     * @return true if the map contains no key-value mappings or false if it does
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private void putNullKeyEntry(HashMapEntry<K, V> entry) {
        HashMapEntry<K, V> existingEntry = buckets[0];

        if (existingEntry == null) {
            buckets[0] = entry;
        } else {
            if (existingEntry.getKey() == null) {
                existingEntry.setValue(entry.getValue());
                return;
            }
            while (existingEntry.getNext() != null) {
                if (existingEntry.getNext().getKey() == null) {
                    existingEntry.getNext().setValue(entry.getValue());
                    return;
                }

                existingEntry = existingEntry.getNext();
            }
            existingEntry.setNext(entry);
        }
        size++;
    }

    private V getNullKeyEntry() {
        HashMapEntry<K, V> existingEntry = buckets[0];
        if (existingEntry.getKey() == null) {
            return existingEntry.getValue();
        }
        while (existingEntry.getNext() != null) {
            if (existingEntry.getNext().getKey() == null) {
                return existingEntry.getNext().getValue();
            }
            existingEntry = existingEntry.getNext();
        }
        return null;
    }

    private V removeNullKeyEntry() {
        V value;
        HashMapEntry<K, V> head = buckets[0];
        boolean hasNext = head.getNext() != null;

        if (head.getKey() == null) {
            value = head.getValue();
            buckets[0] = hasNext ? head.getNext() : null;
            --size;
            return value;
        }
        while (head.getNext() != null) {
            if (head.getNext().getKey() == null) {
                value = head.getNext().getValue();
                head.setNext(head.getNext().getNext());
                --size;
                return value;
            }
            head = head.getNext();
        }
        return null;
    }

}
