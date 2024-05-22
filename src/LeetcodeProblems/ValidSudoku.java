package LeetcodeProblems;

public class ValidSudoku {
    private boolean checkRow(char[][] board, int row, int col) {
        for (int i = 0; i < board[0].length; i++) {
            if (i == col) continue;
            if (board[row][i] != '.' && board[row][i] == board[row][col])
                return false;
        }
        return true;
    }

    private boolean checkCol(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            if (i == row) continue;
            if (board[i][col] != '.' && board[i][col] == board[row][col])
                return false;
        }
        return true;
    }

    private boolean checkGrid(char[][] board, int row, int col) {
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (i == row && j == col) continue;
                if (board[i][j] != '.' && board[i][j] == board[row][col])
                    return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (!(checkRow(board, i, j)
                            && checkCol(board, i, j)
                            && checkGrid(board, i, j)))
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new ValidSudoku().isValidSudoku(board);
    }
}
