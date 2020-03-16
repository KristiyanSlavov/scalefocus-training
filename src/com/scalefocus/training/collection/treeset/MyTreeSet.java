package com.scalefocus.training.collection.treeset;

import com.scalefocus.training.collection.common.MySet;
import com.scalefocus.training.collection.treemap.MyTreeMap;

/**
 * @author Kristiyan SLavov
 */
public class MyTreeSet<K extends Comparable<K>> implements MySet<K> {

    private MyTreeMap<K, String> treeMap = new MyTreeMap<K, String>();

    private static final String DUMMY_VAL = "";

    public MyTreeSet() {
        treeMap = new MyTreeMap<>();
    }

    /**
     * This method adds the specified element to the set.
     *
     * @param element - element to be added to the set
     */
    public void add(K element) {
        treeMap.put(element, DUMMY_VAL);
    }

    /**
     * This method removes the specified element from this set if it is present.
     *
     * @param element - element to be removed from the set
     * @return true if the set contains the specified element or false if it does not
     */
    public boolean remove(K element) {
        return treeMap.remove(element) != null;
    }

    /**
     * This method returns true if the set contains the specified element.
     *
     * @param element - element to be checked for containment in the set
     * @return true if the set contains the specified element
     */
    public boolean contains(K element) {
        return treeMap.containsKey(element);
    }

    /**
     * This method returns true if the set contains no elements.
     *
     * @return - true if the set contains no element or false if it does.
     */
    public boolean isEmpty() {
        return treeMap.isEmpty();
    }

    /**
     * This method returns the number of elements in the set.
     *
     * @return - the number of elements in the set
     */
    public int size() {
        return treeMap.size();
    }

    /**
     * This method returns the first added element in the set.
     *
     * @return - the first added element in the set
     */
    public Object first() {
        return treeMap.first();
    }

    /**
     * This method returns the last added element in the set.
     *
     * @return - the last added element in the set
     */
    public Object last() {
        return treeMap.last();
    }

    /**
     * This method print all the elements from the set.
     */
    public void print() {
        treeMap.print();
    }
}
