package com.scalefocus.training;

import com.scalefocus.training.queue.Queue;
import com.scalefocus.training.stack.Stack;

public class TrainingApp {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        stack.push("f");

        stack.poll();
        stack.poll();
        stack.poll();
        stack.poll();

        stack.push("g");
        stack.push("h");

        System.out.println(stack.peek());
    }
}
