package LeetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensII {
    private boolean safeCols(int[] rows, int col) {
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == -1) continue;
            else if (rows[i] == col) return false;
        }
        return true;
    }

    private boolean safeLRDiagonal(int[] rows, int row, int col) {
        int diff = col - row;
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == -1) continue;
            int currDiff = rows[i] - i;
            if (diff == currDiff) return false;
        }
        return true;
    }

    private boolean safeRLDiagonal(int[] rows, int row, int col) {
        int sum = col + row;
        for (int i = 0; i < rows.length; i++) {
            if (rows[i] == -1) continue;
            int currSum = rows[i] + i;
            if (sum == currSum) return false;
        }
        return true;
    }

    private boolean isSafe(int[] rows, int row, int col) {
        if (!safeCols(rows, col)) return false;
        return safeLRDiagonal(rows, row, col) && safeRLDiagonal(rows, row, col);
    }

    private void helper(int[] rows, int rowNum, int n, List<int[]> answer) {
        if (n == rowNum){
            answer.add(rows);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(rows, rowNum, i)) {
                rows[rowNum] = i;
                helper(rows, rowNum + 1, n, answer);
                rows[rowNum] = -1;
            }
        }
    }

    public int totalNQueens(int n) {
        List<int[]> answer = new ArrayList<>();
        int[] rows = new int[n];
        Arrays.fill(rows, -1);
        helper(rows, 0, n, answer);
        return answer.size();
    }

    public static void main(String[] args) {
        System.out.println(new NQueensII().totalNQueens(4));
    }
}
