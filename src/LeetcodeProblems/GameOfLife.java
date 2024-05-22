package LeetcodeProblems;

public class GameOfLife {
    private boolean isInBounds(int i, int j, int m, int n) {
        return (i >= 0) && (j >= 0) && (i < m) && (j < n);
    }
    private int returnStatus(int[][] board, int i, int j) {
        int[] rowMove = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] colMove = {0, 1, 1, 1, 0, -1, -1, -1};
        int countAlive = 0;
        int m = board.length, n = board[0].length;
        for (int k = 0; k < 8; k++) {
            int row = i + rowMove[k];
            int col = j + colMove[k];
            if (isInBounds(row, col, m, n)) {
                if (board[row][col] == 1)
                    countAlive++;
            }
        }
        if (board[i][j] == 0){
            if (countAlive == 3) return 1;
            return 0;
        }
        if (countAlive < 2 || countAlive > 3) return 0;
        return 1;
    }

    public void gameOfLife(int[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = returnStatus(board, i, j);
            }
        }
    }
}
