package RecursionAndBacktracking;

import org.graalvm.collections.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {

    public void findMissingValues(List<Pair<Integer,Integer>> missing, int[][] board) {
        for (int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                if (board[i][j] == -1) missing.add(Pair.create(i, j));
    }

    public List<Integer> getDefault() {
        List<Integer> val = new ArrayList<>();
        for (int i = 1; i < 10; i++) val.add(i);
        return val;
    }

    public void gridValues(List<Integer> grid, int[][] board, Pair<Integer, Integer> index) {
        int startRow = (index.getLeft() / 3) * 3;
        int startCol = (index.getRight() / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++)
            for (int j = startCol; j < startCol + 3; j++) {
                int val = board[i][j];
                if (val == -1) continue;
                grid.set(val - 1, -1);
            }
    }

    public void findCommon(List<Integer> values, List<Integer> row, List<Integer> grid, List<Integer> column) {
//        System.out.println("Row: " + row + "\nColumn: " + column + "\nGrid: " + grid);
        for (int i = 0; i < 9; i++) {
            if (row.get(i) == -1 || column.get(i) == -1 || grid.get(i) == -1) continue;
            values.add(row.get(i));
        }
//        System.out.println(values /*+ "\n---------------"*/);
    }

    public List<Integer> findPossibleValues(Pair<Integer, Integer> index, int[][] board) {
        List<Integer> defaultValues = getDefault();
        List<Integer> column = new ArrayList<>(defaultValues);
        List<Integer> row = new ArrayList<>(defaultValues);
        List<Integer> grid = new ArrayList<>(defaultValues);
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int val1 = board[i][index.getRight()];
            int val2 = board[index.getLeft()][i];
            if (val1 != -1) {
                row.set(val1 - 1, -1);
            }
            if (val2 != -1) {
                column.set(val2 - 1, -1);
            }

        }
        gridValues(grid, board, index);
        findCommon(values, row, grid, column);
        return values;
    }

    public void display(int[][] board) {
        for (int i = 0; i < 9; i++) System.out.println(Arrays.toString(board[i]));
        System.out.println("---------------------------------------------");
    }

    public boolean solve(List<Pair<Integer, Integer>> missingValues, int currentMissing, int[][] board) {
        // This statement signifies that all values that are missing have been accounted for
        if (currentMissing >= missingValues.size()) return true;
        Pair<Integer, Integer> integer = missingValues.get(currentMissing);
        List<Integer> possibleValues = findPossibleValues(integer, board);
        // This means that there are no possible values for the current cell which is impossible for a correct solution
        if (possibleValues.isEmpty()) return false;
        for (int value: possibleValues) {
            board[integer.getLeft()][integer.getRight()] = value;
            boolean isCorrect = solve(missingValues, currentMissing + 1, board);
            if (!isCorrect) {
                board[integer.getLeft()][integer.getRight()] = -1;
            } else return true; // Only come to this line when we encounter a correct solution for the sudoku
        }
        return false;
    }

    public void sudokuSolver(int[][] board) {
        List<Pair<Integer, Integer>> missingValues = new ArrayList<>();
        findMissingValues(missingValues, board);
        boolean didSolve = solve(missingValues, 0, board);
        if (didSolve) for (int i = 0; i < 9; i++) System.out.println(Arrays.toString(board[i]));
        else System.out.println("Erroneous sudoku kindly recheck");
    }

    public static void main(String[] args) {
        int[][] board = {
                {9,-1,-1,-1,5,-1,4,-1,-1},
                {-1,4,-1,-1,-1,-1,5,-1,9},
                {8,-1,-1,4,3,-1,-1,-1,-1},
                {5,-1,-1,2,6,-1,-1,-1,1},
                {-1,-1,7,-1,-1,-1,2,-1,-1},
                {1,-1,-1,-1,8,5,-1,-1,3},
                {-1,-1,-1,-1,9,1,-1,-1,2},
                {3,-1,2,-1,-1,-1,-1,1,-1},
                {-1,-1,1,-1,2,-1,-1,-1,7}
        };

        new Sudoku().sudokuSolver(board);
    }
}
