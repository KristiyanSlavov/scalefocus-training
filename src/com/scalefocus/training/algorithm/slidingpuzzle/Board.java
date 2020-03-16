package com.scalefocus.training.algorithm.slidingpuzzle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * The Board class is responsible for holding the current board state,
 * the length of the board, the blank tile's row and col, and also
 * the board's neighbors.
 * This class also provides:
 * getManhattanDistance - method that returns the sum of manhattan distance of all the board's elements
 * <p>
 * calculateFinalState - method that returns the final state of the board
 * <p>
 * hasBlankTile - method that checks if the board has a blank tile (0 value)
 * <p>
 * calculateNeighbors - method that checks how many neighbors the blank tile has
 * and then calls the generateNeighbor method to generates all the blank tile's neighbors.
 * <p>
 * generateNeighbor - method that generates a neighbor of the blank tile
 * and fill the neighbors list with it. It copy the current board and swaps the blank tile with it's neighbor tile.
 * In this way, it creates a neighbor of the blank tile.
 * <p>
 * swapTiles - method that changes positions of a given elements.It is used by the
 * generateNeighbor method to swap the position of the blank tile with its neighbors.
 * <p>
 * copy2DArray - method that copies a given array.
 * <p>
 * getRowColHelper - method that returns a row or column of a given element, based on isRow flag.
 * <p>
 * isSolvable - method that checks if the board is solvable or not.
 * <p>
 * tileAt - method that returns a tile(element) from the specified position (the given row and col).
 *
 * @author Kristiyan SLavov
 */
public class Board {

    private int[][] tiles;

    private int length;

    private int blankTileRow;

    private int blankTileCol;

    private List<Board> neighbors;

    public Board(int[][] tiles) {
        this.tiles = tiles;
        length = tiles.length;
        neighbors = new LinkedList<>();
    }

    /**
     * This method returns the current state of the board.
     *
     * @return - the board's current state
     */
    int[][] getTiles() {
        return tiles;
    }

    /**
     * This method returns the neighbors of the board.
     *
     * @return - the board's neighbors
     */
    List<Board> getNeighbors() {
        calculateNeighbors();
        return neighbors;
    }

    /**
     * This method returns the board's width.
     *
     * @return - the board's width
     */
    int getLength() {
        return tiles.length;
    }

    /**
     * This method returns the sum of manhattan distance of all the board's elements.
     * It checks if the elements are at their right positions and if they are not, the method calculates
     * the steps that must be taken to put the element/s at its right position and then it sums the steps
     * into one manhattan distance.
     *
     * @return - the sum of the manhattan distance of all the board's elements
     */
    int getManhattanDistance() {
        int manhattanDistance = 0;
        int expectedValue = 0;
        int[][] finalState = calculateFinalState();

        for (int row = 0; row < tiles.length; row++) {
            for (int col = 0; col < tiles[row].length; col++) {
                int value = tiles[row][col];
                expectedValue++;
                if (value != 0 && value != expectedValue) {
                    manhattanDistance += Math.abs(row - getRowColHelper(finalState, value, true))
                            + Math.abs(col - getRowColHelper(finalState, value, false));
                }
            }
        }
        return manhattanDistance;
    }

    /**
     * This method calculates and returns the final state of the board.
     *
     * @return - the board's final state
     */
    int[][] calculateFinalState() {
        int[][] finalArray = new int[length][length];
        int value = 0;

        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                value++;
                if ((col + 1 == length) && (row + 1 == length)) {
                    finalArray[row][col] = 0;
                } else {
                    finalArray[row][col] = value;
                }

            }
        }

        return finalArray;
    }

    /**
     * This method checks if the board has a blank tile (0 value).
     * If it has a blank tile it returns true and sets the properties:
     * blankTileRow - with the blank tile's current row
     * blankTileCol - with the blank tile's current column
     *
     * @return - true if the board has a blank tile (0 value) or false if it has not.
     */
    boolean hasBlankTile() {
        for (int row = 0; row < getLength(); row++) {
            for (int col = 0; col < getLength(); col++) {
                if (tiles[row][col] == 0) {
                    blankTileRow = row;       // index starting from 0
                    blankTileCol = col;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method checks how many neighbors the blank tile has
     * and then calls the generateNeighbor method to generates all the blank tile's neighbors.
     */
    private void calculateNeighbors() {
        if (neighbors.size() != 0) {
            return;
        }

        //if there is blank tile
        if (hasBlankTile()) {

            //check for UP neighbor
            if (blankTileRow - 1 >= 0) {
                generateNeighbor(blankTileRow - 1, true);
            }
            //check for LEFT neighbor
            if (blankTileCol - 1 >= 0) {
                generateNeighbor(blankTileCol - 1, false);
            }

            //check for DOWN neighbor
            if (blankTileRow + 1 < getLength()) {
                generateNeighbor(blankTileRow + 1, true);
            }

            //check for RIGHT neighbor
            if (blankTileCol + 1 < getLength()) {
                generateNeighbor(blankTileCol + 1, false);
            }
        }
    }

    /**
     * This method generates a the blank tile's neighbor and fill the neighbors list with it.
     * It copy the current board and swaps the blank tile with it's neighbor tile (the top neighbor,
     * the bottom neighbor, the left neighbor, or the right neighbor.).
     * In this way, it creates a the blank tile's neighbor.
     *
     * @param toPosition - the position of the element which will be replaced with the blank tile.
     * @param isRow      - the flag that determines whether the position is for a row or a column
     */
    private void generateNeighbor(int toPosition, boolean isRow) {
        int[][] copyTiles = copy2DArray(tiles);

        if (isRow) {
            swapTiles(copyTiles, blankTileRow, blankTileCol, toPosition, blankTileCol);
        } else {
            swapTiles(copyTiles, blankTileRow, blankTileCol, blankTileRow, toPosition);
        }

        neighbors.add(new Board(copyTiles));
    }

    /**
     * This method changes the positions of a given elements.It is used by the
     * generateNeighbor method to swap the position of the blank tile with its neighbors.
     *
     * @param array   - the board/the array in which the given elements will be swapped.
     * @param fromRow - the first element's row
     * @param fromCol - the first element's column
     * @param toRow   - the second element's row
     * @param toCol   - the second element's column
     */
    private void swapTiles(int[][] array, int fromRow, int fromCol, int toRow, int toCol) {
        int temp = array[fromRow][fromCol];
        array[fromRow][fromCol] = array[toRow][toCol];
        array[toRow][toCol] = temp;
    }

    /**
     * This method creates a copy of a specified two dimensional array.
     *
     * @param fromArray - the array from which will be created a copy.
     */
    private int[][] copy2DArray(int[][] fromArray) {
        int[][] copy = new int[fromArray.length][fromArray.length];

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy.length; j++) {
                copy[i][j] = fromArray[i][j];
            }
        }
        return copy;
    }

    // helper to get the row or col of a value, based on isRow flag.
    // if isRow is equal to true, then return row
    // otherwise return col.

    /**
     * This method returns the row or the column of array given element.
     *
     * @param array - the board/array from which a row or a column will be returned.
     * @param element - the element contained in a particular position (row/column).
     * @param isRow - the flag that shows whether a row or a column to be returned.
     *
     * @return - a row/column from the specified array
     */
    private int getRowColHelper(int[][] array, int element, boolean isRow) {
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == element) {
                    if (isRow) {
                        return row;
                    } else {
                        return col;
                    }
                }
            }
        }
        return -1;
    }

    /**
     * This method checks if the board is solvable or not.
     *
     * @return - true if the board is solvable or false if it is not solvable.
     */
    public boolean isSolvable() {
        int inversions = 0;

        for (int i = 0; i < this.getLength() * this.getLength(); i++) {
            int currentRow = i / this.getLength();
            int currentCol = i % this.getLength();

            if (tileAt(currentRow, currentCol) == 0) {
                blankTileRow = currentRow;
                blankTileCol = currentCol;
            }

            for (int j = i; j < this.getLength() * this.getLength(); j++) {
                int row = j / this.getLength();
                int col = j % this.getLength();


                if (tileAt(row, col) != 0 && tileAt(row, col) < tileAt(currentRow, currentCol)) {
                    inversions++;
                }
            }
        }

        if (tiles.length % 2 != 0 && inversions % 2 != 0) return false;
        if (tiles.length % 2 == 0 && (inversions + blankTileRow) % 2 == 0) return false;

        return true;
    }


    /**
     * This method returns an element on the specified row/col position.
     *
     * @param row - the element's row
     * @param col - the element's column
     * @return - the element on the specified position.
     */
    private int tileAt(int row, int col) {
        if (row < 0 || row > length - 1) {
            throw new IndexOutOfBoundsException
                    ("row should be between 0 and N - 1");
        }
        if (col < 0 || col > length - 1) {
            throw new IndexOutOfBoundsException
                    ("col should be between 0 and N - 1");
        }

        return tiles[row][col];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return length == board.length &&
                blankTileRow == board.blankTileRow &&
                blankTileCol == board.blankTileCol &&
                Arrays.equals(tiles, board.tiles) &&
                Objects.equals(neighbors, board.neighbors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(length, blankTileRow, blankTileCol, neighbors);
        result = 31 * result + Arrays.hashCode(tiles);
        return result;
    }
}
