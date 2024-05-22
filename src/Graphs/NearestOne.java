package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NearestOne {
    private int[][] graph;
    private final int rows, cols;

    static class Position {
        int distance;
        int row, col;

        public Position(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public NearestOne() {
        this(3, 3);
    }

    public NearestOne(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        createGraph();
    }

    private void getInput(Scanner sc) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) graph[i][j] = sc.nextInt();
        }
    }

    private void createGraph() {
        graph = new int[rows][cols];
        final String s = "1 0 1 1 1 0 1 0 0";
        boolean takeInput = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 for your input graph");
        takeInput = sc.nextInt() == 1;
        if (takeInput) {
            getInput(sc);
        } else {
            sc = new Scanner(s);
            getInput(sc);
        }
    }

    private boolean isInBounds(int i, int j) {
        return (i >= 0) && (j >= 0) && (i < rows) && (j < cols);
    }

    public void findNearestOne() {

        int[][] answer = new int[rows][cols];
        boolean[][] visited = new boolean[rows][cols];

        Queue<Position> cache = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (graph[i][j] == 1) {
                    cache.add(new Position(i, j, 0));
                    answer[i][j] = 0;
                    visited[i][j] = true;
                } else visited[i][j] = false;
            }
        }

        final int[] dirR = {-1, 0, 1, 0}, dirC = {0, 1, 0, -1};

        while (!cache.isEmpty()) {
            Position current = cache.poll();
            answer[current.row][current.col] = current.distance;
            for (int i = 0; i < 4; i++) {
                int row = current.row + dirR[i], col = current.col + dirC[i];
                if (isInBounds(row, col) && !visited[row][col] && graph[row][col] == 0) {
                    cache.add(new Position(row, col, current.distance + 1));
                    visited[row][col] = true;
                }
            }
        }
    }
}
