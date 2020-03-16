package com.scalefocus.training.algorithm.slidingpuzzle;

/**
 * The SearchNode class is responsible for holding a board,
 * moves taken to get to the current SearchNode, priority of the SearchNode,
 * and a reference to the previous SearchNode (the parent of the current SearchNode).
 * The SearchNode priority is calculated by the sum of the moves and the board's manhattan distance.
 *
 * @author Kristiyan SLavov
 */
public class SearchNode implements Comparable<SearchNode> {

    private Board board;

    private int moves;

    private int priority;

    private SearchNode previous;

    public SearchNode(Board board, int moves, SearchNode previous) {
        this.board = board;
        this.moves = moves;
        this.priority = this.moves + board.getManhattanDistance();
        this.previous = previous;
    }

    /**
     * This method return the board of the search node.
     *
     * @return - the search node's board
     */
    Board getBoard() {
        return board;
    }

    /**
     * This method returns the priority of the search node.
     *
     * @return - the search node's priority
     */
    int getPriority() {
        return priority;
    }

    /**
     * This method returns the search node current moves.
     *
     * @return - the search node current moves.
     */
    int getMoves() {
        return moves;
    }

    /**
     * This method returns the previous search node (the parent of the current search node).
     *
     * @return - the previous search node
     */
    SearchNode getPrevious() {
        return previous;
    }

    /**
     * This method compares two search nodes by their priority.
     *
     * @param node - the node to be compared with the current node.
     *
     * @return - 1 if the current search node's priority is greater than the other search node priority,
     * -1 if the current search node's priority is less than the other search node's priority or
     * 0 if the priorities are equal.
     */
    @Override
    public int compareTo(SearchNode node) {
        return this.priority - node.priority;
    }
}
