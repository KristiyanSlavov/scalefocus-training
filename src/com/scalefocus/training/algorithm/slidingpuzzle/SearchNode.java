package com.scalefocus.training.algorithm.slidingpuzzle;

/**
 * @author Kristiyan SLavov
 */
public class SearchNode implements Comparable<SearchNode> {

    private String id;

    private Board board;

    private int moves;

    private int priority;

    private SearchNode previous;

    public SearchNode(String id, Board board, int moves, SearchNode previous) {
        this.id = id;
        this.board = board;
        this.moves = moves;
        this.priority = this.moves + board.manhattan();
        this.previous = previous;
    }

    public String getId() {
        return id;
    }

    public Board getBoard() {
        return board;
    }

    public int getPriority() {
        return priority;
    }

    public int getMoves() {
        return moves;
    }

    public SearchNode getPrevious() {
        return previous;
    }

    @Override
    public int compareTo(SearchNode node) {
        return this.priority - node.priority;
    }
}
