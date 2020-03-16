package com.scalefocus.training.collection.treemap;

import com.scalefocus.training.collection.common.RBNode;
import com.scalefocus.training.collection.tree.RedBlackTree;

/**
 * @author Kristiyan SLavov
 */
public class MyTreeMap<K extends Comparable<K>, V extends Comparable<V>> {

    private RedBlackTree<K, V> redBlackTree;

    public MyTreeMap() {
        redBlackTree = new RedBlackTree<>();
    }

    public RBNode<K,V> getRoot() {
        return redBlackTree.getRoot();
    }

    /**
     * This method inserts a specified value associated with a specified key in the map.
     * If the map already contains a mapping for the key, the old value is replaced with the new value.
     *
     * @param key - key with which the specified value is to be associated
     * @param value - value to be associated with the specified key
     */
    public void put(K key, V value) {
        redBlackTree.insert(key, value);
    }

    /**
     * This method removes the mapping for the specified key from the map if present.
     *
     * @param key - key for which mapping should be removed
     * @return - the previous value associated with key, or null if there was no mapping for key
     */
    public Object remove(K key) {
        return redBlackTree.delete(key);
    }

    /**
     * This method returns true if the map contains a key or keys associated with the specified value.
     *
     * @param value - value whose presence in map map is to be tested
     * @return - true if the map contains a key associated with the specified value
     */
    public boolean containsValue(V value) {
        return redBlackTree.containsValue(value);
    }

    /**
     * This method returns true if the map contains a mapping for the specified key.
     *
     * @param key - key whose presence in the map is to be tested
     * @return - true if the map contains a mapping for the specified key
     */
    public boolean containsKey(K key) {
        return redBlackTree.containsKey(key);
    }

    /**
     * This method returns the first added key-value pair to the map.
     *
     * @return - the first added element or null if the map does not contain any elements.
     */
    public Object first() {
        return redBlackTree.first();
    }

    /**
     * This method returns the last added key-value pair to the map.
     *
     * @return - the last added key-value pair
     */
    public Object last() {
        return redBlackTree.last();
    }

    /**
     * This method returns a key-value mapping associated with the least key in this map,
     * or null if the map is empty.
     *
     * @return - an entry with the least key, or null if this map is empty
     */
    public Object minimum() {
        return redBlackTree.minimumEntry();
    }

    /**
     * This method returns a key-value mapping associated with the greatest key in this map,
     * or null if the map is empty.
     *
     * @return - an entry with the greatest key, or null if this map is empty
     */
    public Object maximum() {
        return redBlackTree.maximumEntry();
    }

    /**
     * This method returns true if the map contains no key-value mappings.
     *
     * @return - true if the map contains no key-value mappings
     */
    public boolean isEmpty() {
        return redBlackTree.isEmpty();
    }

    /**
     * This method returns the number of key-value mappings in this map.
     *
     * @return - the number of key-value mappings in this map
     */
    public int size() {
        return redBlackTree.size();
    }

    /**
     * This method prints all the keys from the map;
     */
    public void print() {
        redBlackTree.print();
    }
}
