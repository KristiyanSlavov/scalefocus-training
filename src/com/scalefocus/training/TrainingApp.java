package com.scalefocus.training;

import com.scalefocus.training.collection.array.MyArrayList;
import com.scalefocus.training.collection.doublelink.MyDoubleLinkedList;
import com.scalefocus.training.collection.klink.MyKLinkedList;
import com.scalefocus.training.collection.link.MyLinkedList;
import com.scalefocus.training.collection.queue.Queue;
import com.scalefocus.training.collection.stack.Stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrainingApp {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.push(11);
        queue.push(22);
        queue.push(33);
        queue.push(44);

        queue.poll();
        System.out.println(queue.peek());
        queue.print();
    }
}
