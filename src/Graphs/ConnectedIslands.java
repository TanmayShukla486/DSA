package Graphs;

import org.graalvm.collections.Pair;

import java.util.*;

public class ConnectedIslands {
    private final int[][] graph;
    private final int rows, cols;

    private static class Node {
        int row;
        int col;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public ConnectedIslands(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        graph = new int[rows][cols];
        createGraph();
    }

    private final String s = "1 1 0 1 1\n" +
            "1 0 0 0 0\n" +
            "0 0 0 0 1\n" +
            "1 1 0 1 1\n";
    private void createGraph() {
        Scanner sc = new Scanner(s);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                graph[i][j] = sc.nextInt();
        }
    }

    public void display() {
        for (int i = 0; i < rows; i++)
            System.out.println(Arrays.toString(graph[i]));
    }

    private void fill(boolean[][] visited) {
        for (int i = 0; i < rows; i++) Arrays.fill(visited[i], false);
    }

    private boolean isInBounds(int i, int j) {
        return (i >= 0) && (j >= 0) && (i < rows) && (j < cols);
    }

    private void findIsland(Node node, boolean[][] visited) {
        Queue<Node> cache = new LinkedList<>();
        cache.add(node);
        visited[node.row][node.col] = true;
        int[] rowDirection = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] colDirection = {-1, 0, 1, 1, 1, 0, -1, -1};
        while (!cache.isEmpty()) {
            Node current = cache.poll();
            for (int i = 0; i < 8; i++) {
                int r = current.row + rowDirection[i];
                int c = current.col + colDirection[i];
                if (isInBounds(r, c) && !visited[r][c] && graph[r][c] != 0) {
                    cache.add(new Node(r, c));
                    visited[r][c] = true;
                }
            }
        }
    }

    public int findIslands() {
        int count = 0;

        boolean[][] visited = new boolean[rows][cols];
        fill(visited);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    findIsland(new Node(i, j), visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void findDistinctIsland(Node node,
                                    boolean[][] visited,
                                    List<Pair<Integer, Integer>> list,
                                    int baseR,
                                    int baseC
                                    ) {
        visited[node.row][node.col] = true;
        list.add(Pair.create(node.row - baseR, node.col - baseC));
        int[] rowDirection = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] colDirection = {-1, 0, 1, 1, 1, 0, -1, -1};
        for (int i = 0; i < 8; i++) {
            int row = node.row + rowDirection[i]; int col = node.col + colDirection[i];
            if (isInBounds(row, col) && !visited[row][col] && graph[row][col] != 0)
                findDistinctIsland(new Node(row, col), visited, list, baseR, baseC);
        }
    }

    public int distinctIslands() {
        boolean[][] visited = new boolean[rows][cols];
        fill(visited);
        Set<List<Pair<Integer, Integer>>> answer = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && graph[i][j] != 0) {
                    List<Pair<Integer, Integer>> path = new ArrayList<>();
                    findDistinctIsland(new Node(i, j), visited, path, i, j);
                    answer.add(path);
                }
            }
        }
        return answer.size();
    }
}
