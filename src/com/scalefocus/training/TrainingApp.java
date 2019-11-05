package com.scalefocus.training;

import com.scalefocus.training.collection.priorityqueue.PriorityQueue;

import java.util.Comparator;

public class TrainingApp {

    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2) {
                    return -1;
                } else if (o1 > o2) {
                    return 1;
                } return 0;
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(10);
        pq.push(10);
        pq.push(30);
        pq.push(20);
        pq.push(400);
        pq.push(700);
        pq.push(23);
        pq.push(17);
        pq.push(7);
        pq.push(5);
        pq.push(3);
        pq.poll();
        pq.poll();
        pq.poll();
        pq.poll();
        pq.poll();
        pq.poll();
        pq.poll();
        pq.poll();
        pq.poll();
        pq.poll();
        pq.peek();
        pq.size();
    }
}
