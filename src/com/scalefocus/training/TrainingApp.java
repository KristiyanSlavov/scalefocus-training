package com.scalefocus.training;

import com.scalefocus.training.queue.Queue;
import com.scalefocus.training.stack.Stack;

public class TrainingApp {

    public static void main(String[] args) {
        Stack queue = new Stack();

        queue.push("a");
        queue.push("b");
        queue.push("c");

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.peek();
        System.out.println(queue.size());
    }
}
