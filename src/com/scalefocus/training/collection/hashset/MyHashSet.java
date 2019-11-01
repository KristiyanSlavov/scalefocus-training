package com.scalefocus.training.collection.hashset;

import com.scalefocus.training.collection.common.MySet;
import com.scalefocus.training.collection.hashmap.MyHashMap;

/**
 * @author Kristiyan SLavov
 */
public class MyHashSet<K> implements MySet<K> {

    private MyHashMap<K, Object> map;

    private static final Object DUMMY_VAL = new Object();

    public MyHashSet() {
        map = new MyHashMap<>();
    }

    public MyHashSet(int initialCapacity) {
        map = new MyHashMap<>(initialCapacity);
    }

    /**
     * This method adds new element in the set. Internally, the set uses the hashmap's put method,
     * where the element is the key and the value is the DUMMY_VAL constant.
     * K is the type of the element
     *
     * @param element - the new element that will be stored in the set.
     */
    public void add(K element) {
        map.put(element, DUMMY_VAL);
    }

    /**
     * This method removes the specified element from the set.
     *
     * @param element - the specified element that will be removed from the set
     * @return true if the element is removed or false if the set does not contain this element.
     */
    public boolean remove(K element) {
        return map.remove(element) == DUMMY_VAL;
    }

    /**
     * This method returns true if the set contains the specified element.
     *
     * @param element - the specified element to be searched for in the list.
     * @return true if the set contains the specified element or false if it does not.
     */
    public boolean contains(K element) {
        return map.contains(element);
    }

    /**
     * This method returns the number of elements in the set.
     *
     * @return - the number of elements in the set.
     */
    public int size() {
        return map.size();
    }

    /**
     * This method returns true if the set contains no elements.
     *
     * @return true if the set contains no element or false if it does.
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /**
     * This method prints all the elements from the set.
     */
    public void print() {
        map.print();
    }
}
