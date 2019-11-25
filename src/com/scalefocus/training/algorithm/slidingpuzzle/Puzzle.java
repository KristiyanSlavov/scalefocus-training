package com.scalefocus.training.algorithm.slidingpuzzle;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * The Puzzle class is responsible for finding the optimal path in the initial board (solving the puzzle),
 * if the initial board is solvable.It uses A* Search Algorithm which calculates the search node's priority by sum of the
 * current moves and the sum of manhattan distance of all the board's elements.
 * After the calculation of the priority, it chooses the search node with less priority.
 * This is done until the current node is in the final state (is solved).
 * The algorithm uses a priority queue where the search nodes are pushed and the search node with less priority is
 * always first in the priority queue. Then the first search node is retrieved and removed, and it's neighbors
 * are pushed into the priority queue. And this is repeated until the current search node is in the final state.
 * If the current node is in the final state it is pushed into optimalPath(stack data structure).
 * After that the class has a calculateOptimalPath method which traverses the parents/previous
 * search nodes of the final search node and pushes them into the optimalPath stack, thus forming the optimal path (solving the puzzle).
 *
 * @author Kristiyan SLavov
 */
public class Puzzle {

    private PriorityQueue<SearchNode> priorityQueue;

    private SearchNode initial;

    private Stack<SearchNode> optimalPath;

    public Puzzle(SearchNode node) {
        initial = node;
        priorityQueue = new PriorityQueue<>();
        optimalPath = new Stack<>();
    }

    /**
     * This method solves the puzzle (the initial board), if the board is solvable.
     * It uses A* Search Algorithm which calculates the search node's priority by sum of the
     * current moves and the sum of manhattan distance of all the board's elements.
     * After the calculation of the priority, it chooses the search node with less priority.
     * This is done until the current node is in the final state (is solved).
     * The algorithm uses a priority queue where the search nodes are pushed and the search node with less priority is
     * always first in the priority queue. Then the first search node is retrieved and removed, and it's neighbors
     * are pushed into the priority queue. And this is repeated until the current search node is in the final state.
     * If the current node is in the final state it is pushed into optimalPath(stack data structure).
     * After that the class has a calculateOptimalPath method which traverses the parents
     * search nodes of the final search node and pushes them into the optimalPath stack, thus forming the optimal path (solving the puzzle).
     *
     */
    private void calculatePuzzle() {
        if (!initial.getBoard().isSolvable() || !initial.getBoard().hasBlankTile()) {
            return;
        }

        SearchNode current = initial;
        SearchNode previous;
        int[][] finalState = initial.getBoard().calculateFinalState();
        int moves = 0;

        priorityQueue.add(current);
        while (current.getBoard().getNeighbors() != null) {
            previous = priorityQueue.poll();
            if (deepEqual(current.getBoard().getTiles(), finalState)) {
                calculateOptimalPath(current);
                return;
            }

            for (Board b : current.getBoard().getNeighbors()) {
                SearchNode newNode = new SearchNode(b, moves, previous);

                //critical optimization
                assert previous != null;
                if(null == previous.getPrevious() ||
                        !deepEqual(newNode.getBoard().getTiles(), previous.getPrevious().getBoard().getTiles())) {
                    priorityQueue.add(newNode);
                }
            }
            current = priorityQueue.peek();
        }
    }

    /**
     * This method forms the optimal path from the initial board state to the final board state.
     * It uses the final search node, traverses its parents until it reaches the initial board state
     * and pushes all of the nodes into optimalPath stack
     *
     * @param finalNode - the final search node from which traverse will started.
     */
    private void calculateOptimalPath(SearchNode finalNode) {
        SearchNode current = finalNode;
        while (current.getPrevious() != null) {
            optimalPath.add(current);
            current = current.getPrevious();
        }
        optimalPath.add(current);
    }

    /**
     * This method checks if a two 2D arrays are equal.
     *
     * @param firstArray - the first array
     * @param secondArray - the second array
     * @return - true if the two arrays are equal or false if they are not.
     */
    private boolean deepEqual(int[][] firstArray, int[][] secondArray) {
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

    /**
     * This method prints the optimal path from the initial board state to the final board state.
     */
    public void getPath() {
        //first calculate the puzzle
        calculatePuzzle();

        //if visited list is empty, the initial puzzle is not solvable.
        if (optimalPath.size() == 0) {
            System.out.println("Not solvable puzzle!");
        } else {
            int moves = 0;
            while (!optimalPath.isEmpty()) {
                moves++;
                SearchNode sn = optimalPath.pop();
                int length = sn.getBoard().getLength();
                for (int row = 0; row < length; row++) {
                    for (int col = 0; col < length; col++) {
                        System.out.print(sn.getBoard().getTiles()[row][col] + " ");
                        if (col == length - 1) {
                            System.out.println(sn + " Moves:" + moves + " Previous: " + sn.getPrevious());
                        }
                    }
                    if (row == length - 1) {
                        System.out.println("");
                    }
                }
            }
        }
    }
}
