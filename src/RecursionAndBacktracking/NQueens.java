package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {


    /**
     * The LR diagonal is such that the difference between col and row is same throughout
     * i.e. if col = 3 and row = 2 then the left to right diagonal in which it is present
     * will always have 3 - 2 = 1 e.g. -> val = (2,1) and 2 - 1 = 1 so same
     * */
    public boolean isSafeLRDiagonal(int[] ar, int val) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == -1) continue;
            if (ar[i] - i == val) return false;
        }
        return true;
    }

    /**
     * The RL diagonal is such that the sum of  col and row is same throughout
     * i.e. if col = 3 and row = 2 then the right to left diagonal in which it is present
     * will always have 3 + 2 = 5 e.g. -> val = (4,1) and 4 + 1 = 5 so same
     * */
    public boolean isSafeRLDiagonal(int[] ar, int val) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == -1) continue;
            if (ar[i] + i == val) return false;
        }
        return true;
    }

    public boolean isSafe(int[] ar, int row, int col) {
        // checking for same column
        for (int j : ar) {
            if (j == col) return false;
        }
        // checking for diagonals
        boolean lrIsSafe = isSafeLRDiagonal(ar, col - row);
        boolean rlIsSafe = isSafeRLDiagonal(ar, col + row);
        // returning true only if both diagonals are safe
        return lrIsSafe && rlIsSafe;
    }

    public void helper(int[] columnPositions, int rowNumber, List<char[][]> boards) {
        // condition is satisfied only when all the rows have a queen in a safe position
        if (rowNumber >= columnPositions.length){
            boards.add(constructBoard(columnPositions));
            return;
        }
        // Do not need to check for rows as each row will only have a single queen in it
        // looping through all the columns to check which column is safe for the queen
        for (int i = 0; i < columnPositions.length; i++) {
            if (isSafe(columnPositions, rowNumber, i)) {
                // if the position is safe we assign it to the column in the designated row number
                columnPositions[rowNumber] = i;
                // we recursively check for the other rows
                helper(columnPositions, rowNumber + 1, boards);
                // we then remove the queen from the current place and try out other places for
                // other possible solutions
                columnPositions[rowNumber] = -1;
            }
        }
    }

    public char[][] constructBoard(int[] columnPositions) {
        int n = columnPositions.length;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '_');
        for (int i = 0; i < n; i++)
            board[i][columnPositions[i]] = 'Q';
        return board;
    }

    public void displayBoard(char[][] board){
        for (char[] boardRow : board) {
            System.out.println(Arrays.toString(boardRow));
        }
        System.out.println("-------------------------------------------------");
    }

    public void findQueenPositions(int n) {
        int[] columnPositions = new int[n];
        Arrays.fill(columnPositions, -1);
        int rowNumber = 0;
        List<char[][]> boards = new ArrayList<>();
        helper(columnPositions, rowNumber, boards);
        for (char[][] board: boards) displayBoard(board);
    }

    public static void main(String[] args) {
        new NQueens().findQueenPositions(10);
    }
}
