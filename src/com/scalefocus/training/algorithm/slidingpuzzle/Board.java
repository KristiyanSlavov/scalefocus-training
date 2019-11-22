package com.scalefocus.training.algorithm.slidingpuzzle;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Kristiyan SLavov
 */
public class Board {

    private int[][] tiles;

    private int[][] finalState;

    private int length;

    private int blankTileRow;

    private int blankTileCol;

    private List<Board> neighbors;

    public Board(int[][] tiles) {
        this.tiles = tiles;
        length = tiles.length;
        neighbors = new LinkedList<>();
    }

    // return sum of Manhattan distances between blocks and goal
    protected int manhattan() {
        int manhattanDistance = 0;
        int expectedValue = 0;
        calculateFinalState();

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

    public int[][] getTiles() {
        return tiles;
    }

    protected int[][] getFinalState() {
        calculateFinalState();
        return finalState;
    }

    protected List<Board> getNeighbors() {
        calculateNeighbors();
        return neighbors;
    }

    // helper to get a board in final state
    private void calculateFinalState() {
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

        this.finalState = finalArray;
    }

    private void findBlankTile() {
        for (int row = 0; row < getLength(); row++) {
            for (int col = 0; col < getLength(); col++) {
                if (tiles[row][col] == 0) {
                    blankTileRow = row;       // index starting from 0
                    blankTileCol = col;
                    return;
                }
            }
        }
    }

    private void calculateNeighbors() {
        if (neighbors.size() != 0) {
            return;
        }

        //find blankTile row and col
        findBlankTile();

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

    private void generateNeighbor(int toPosition, boolean isRow) {
        int[][] copyTiles = copy2DArray(tiles);

        if (isRow) {
            swapTiles(copyTiles, blankTileRow, blankTileCol, toPosition, blankTileCol);
        } else {
            swapTiles(copyTiles, blankTileRow, blankTileCol, blankTileRow, toPosition);
        }

        neighbors.add(new Board(copyTiles));
    }

    private void swapTiles(int[][] array, int fromRow, int fromCol, int toRow, int toCol) {
        int temp = array[fromRow][fromCol];
        array[fromRow][fromCol] = array[toRow][toCol];
        array[toRow][toCol] = temp;
    }

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
    private int getRowColHelper(int[][] a, int value, boolean isRow) {
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                if (a[row][col] == value) {
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

    // board size N
    public int getLength() {
        return tiles.length;
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
                Arrays.equals(finalState, board.finalState) &&
                Objects.equals(neighbors, board.neighbors);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(length, blankTileRow, blankTileCol, neighbors);
        result = 31 * result + Arrays.hashCode(tiles);
        result = 31 * result + Arrays.hashCode(finalState);
        return result;
    }
}
