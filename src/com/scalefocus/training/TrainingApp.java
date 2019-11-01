package com.scalefocus.training;

import com.scalefocus.training.collection.heap.Heap;

import java.util.PriorityQueue;


public class TrainingApp {

    public static void main(String[] args) {
        Heap heap = new Heap(5);
        heap.insert(2);
        heap.insert(29);
        heap.insert(7);
        heap.insert(11);
        heap.insert(17);
    }
}
