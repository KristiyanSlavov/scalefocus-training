package com.scalefocus.training;

import com.scalefocus.training.algorithm.slidingpuzzle.Board;
import com.scalefocus.training.algorithm.slidingpuzzle.Puzzle;
import com.scalefocus.training.algorithm.slidingpuzzle.SearchNode;

public class TrainingApp {

    public static void main(String[] args) {

        //        int[][] array = {{1, 3, 0, 4}, {5, 2, 7, 8}, {9, 6, 10, 11}, {13, 14, 15, 12}};
        int[][] array = {{1, 0, 3}, {5, 2, 6}, {8, 4, 7}};
        //int[][] array2 = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
        Board board = new Board(array);
        SearchNode searchNode = new SearchNode(board, 0, null);
        Puzzle slidingPuzzle = new Puzzle(searchNode);
        System.out.println(board.isSolvable());
        slidingPuzzle.getPath();
    }

}
