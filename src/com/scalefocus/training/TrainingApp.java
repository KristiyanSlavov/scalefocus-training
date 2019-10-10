package com.scalefocus.training;

import com.scalefocus.training.collection.queue.Queue;
import com.scalefocus.training.collection.stack.Stack;

public class TrainingApp {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");

        stack.poll();
        stack.poll();
        stack.poll();
        stack.poll();
        System.out.println(stack.size());
    }
}
