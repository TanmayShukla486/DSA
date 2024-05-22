package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    public boolean checkBipartiteBFS(Graph graph, int startNode) {
        int[] visited = new int[graph.size() + 1];
        Arrays.fill(visited, -1);
        Queue<Integer> cache = new LinkedList<>();
        cache.add(startNode);
        visited[startNode] = 0;
        while (!cache.isEmpty()) {
            int current = cache.poll();
            for (int node: graph.adjacencyList.get(current)) {
                if (visited[node] == -1) {
                    visited[node] = (visited[current] == 0) ? 1 : 0;
                    cache.add(node);
                } else if (visited[node] == visited[current]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean helper(Graph graph, int node, int[] visited, int prevColor) {
        visited[node] = (prevColor == 0) ? 1 : 0;
        for (int adjacentNode: graph.adjacencyList.get(node)) {
            if (visited[adjacentNode] == -1) {
                if (!helper(graph, adjacentNode, visited, visited[node])) return false;
            }
            else if (visited[node] == visited[adjacentNode]) return false;
        }
        return true;
    }

    public boolean checkBipartiteDFS(Graph graph, int startNode) {
        int[] visited = new int[graph.size() + 1];
        Arrays.fill(visited, -1);
        return helper(graph, startNode, visited, 0);
    }
}
