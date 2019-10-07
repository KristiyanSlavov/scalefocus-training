package com.scalefocus.training.hashset;

import com.scalefocus.training.hashmap.MyHashMap;

/**
 * @author Kristiyan SLavov
 */
public class MyHashSet<K> {

    private MyHashMap<K, Object> map;

    private static final Object DUMMY_VAL = new Object();

    public MyHashSet() {
        map = new MyHashMap<K, Object>();
    }

    public MyHashSet(int initialCapacity) {
        map = new MyHashMap<K, Object>(initialCapacity);
    }

    /**
     * This method adds new element in the set. Internally, the set uses the hashmap's put method,
     * where the key is the new element and the value is the DUMMY_VAL constant.
     * K is the type of the element
     *
     * @param key - the new element that will be stored in the set.
     */
    public void add(K key) {
        map.put(key, DUMMY_VAL);
    }

    /**
     * This method removes the specified element from the set.
     *
     * @param key - the specified element that will be removed from the set
     * @return true if the element is removed or false if the set does not contain this element.
     */
    public boolean remove(K key) {
        return map.remove(key) == DUMMY_VAL;
    }

    /**
     * This method returns true if the set contains the specified element.
     *
     * @param key - the specified element to be search for in the list.
     * @return true if the set contains the specified element or false if it does not.
     */
    public boolean contains(K key) {
        return map.contains(key);
    }

    /**
     * This method prints all the elements from the set.
     */
    public void print() {
        map.print();
    }
}
