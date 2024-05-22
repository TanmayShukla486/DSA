package Graphs;

import java.util.*;

public class RottenOranges {
    private int[][] grid;
    static class Oranges{
        int row, col, time;
        public Oranges(int _row, int _col, int _time) {
            row = _row;
            col = _col;
            time = _time;
        }
    }

    private boolean isInBounds(int i, int j, int n, int m) {
        return (i >= 0) && (i < n) && (j >= 0) && (j < m);
    }

    public RottenOranges(int n, int m) {
        createGrid(n, m);
    }

    public void createGrid(int n, int m) {
        grid = new int[n][m];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }

    public void findTimeTaken() {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<Oranges> rottenOranges = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    rottenOranges.add(new Oranges(i, j, 0));
                    visited[i][j] = true;
                }
                else visited[i][j] = false;
            }
        }
        int time = 0;
        int[] neighborRow = {-1, 0, 1, 0};
        int[] neighborCol = {0, 1, 0, -1};
        while (!rottenOranges.isEmpty()) {
            Oranges current = rottenOranges.poll();
            time = Math.max(time, current.time);
            for (int i = 0; i < 4; i++) {
                int row = current.row + neighborRow[i];
                int col = current.col + neighborCol[i];
                if (isInBounds(row, col, n, m) && grid[row][col] != 0 && !visited[row][col]) {
                    rottenOranges.add(new Oranges(row, col, current.time + 1));
                    visited[row][col] = true;
                }
            }
        }
        boolean allRotten = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    allRotten = false; break;
                }
            }
        }
        System.out.println((allRotten) ? time : -1);
    }
}
