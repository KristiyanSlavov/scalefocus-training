package com.scalefocus.training.algorithm.slidingpuzzle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author Kristiyan SLavov
 */
public class Puzzle {

    private PriorityQueue<SearchNode> priorityQueue;

    private SearchNode initial;

    private LinkedList<SearchNode> visited;

    private Stack<SearchNode> optimalPath;

    public Puzzle(SearchNode node) {
        initial = node;
        priorityQueue = new PriorityQueue<>();
        visited = new LinkedList<>();
        optimalPath = new Stack<>();
    }

    private void calculatePuzzle() {
        if (!initial.getBoard().isSolvable()) {
            return;
        }

        SearchNode current = initial;
        int[][] finalState = initial.getBoard().getFinalState();
        int moves = 0;
        int nodeNumber = 0;

        priorityQueue.add(current);
        while (current.getBoard().getNeighbors() != null) {
            visited.add(priorityQueue.poll());
            if (Arrays.deepEquals(current.getBoard().getTiles(), finalState)) {
                calculateOptimalPath(current);
                return;
            }

            for (Board b : current.getBoard().getNeighbors()) {
//                ++nodeNumber;
                SearchNode newNode = new SearchNode("NODE" + nodeNumber, b, moves, visited.getLast());
                //critical optimization
                if (null == visited.getLast().getPrevious() ||
                        !Arrays.deepEquals(newNode.getBoard().getTiles(), visited.getLast().getPrevious().getBoard().getTiles())) {
                    priorityQueue.add(newNode);
                }
            }
            current = priorityQueue.peek();
        }
    }

    private void calculateOptimalPath(SearchNode finalNode) {
        SearchNode current = finalNode;
        while (current.getPrevious() != null) {
            optimalPath.add(current);
            current = current.getPrevious();
        }
        optimalPath.add(current);
    }

    public boolean deepEqual(int[][] firstArray, int[][] secondArray) {
        if (firstArray.length == secondArray.length) {
            for (int row = 0; row < firstArray.length; row++) {
                for (int col = 0; col < firstArray.length; col++) {
                    if (firstArray[row][col] != secondArray[row][col]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public void printOptimalPath() {
        //first calculate the puzzle
        calculatePuzzle();

        //if visited list is empty, the initial puzzle is not solvable.
        if (optimalPath.size() != 0) {
            int moves = 0;
            while (!optimalPath.isEmpty()) {
                moves++;
                SearchNode sn = optimalPath.pop();
                int length = sn.getBoard().getLength();
                for (int row = 0; row < length; row++) {
                    for (int col = 0; col < length; col++) {
                        System.out.print(sn.getBoard().getTiles()[row][col] + " ");
                        if (col == length - 1) {
                            System.out.println("ID: " + sn.getId() + " " + " Moves:" + moves + " Previous: " + sn.getPrevious());
                        }
                    }
                    if (row == length - 1) {
                        System.out.println("");
                    }
                }
            }
        } else {
            System.out.println("Not solvable puzzle!");
        }
    }
}
