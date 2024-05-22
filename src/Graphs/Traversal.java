package Graphs;

import java.util.*;

public class Traversal {
    private void helpBfsTraverse(Graph graph,
                                 int startingNode,
                                 boolean[] visited,
                                 List<Integer> answer) {
        List<List<Integer>> adjList = graph.adjacencyList;
        Queue<Integer> cache = new LinkedList<>();
        cache.add(startingNode);
        while (!cache.isEmpty()) {
            int currNode = cache.poll();
            answer.add(currNode);
            for (int node: adjList.get(currNode)) {
                if (!visited[node]) {
                    cache.add(node);
                    visited[node] = true;
                }
            }
        }
    }

    public List<Integer> bfsTraverse(Graph graph, int startingNode) {
        List<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[graph.size() + 1];
        Arrays.fill(visited, false);
        visited[startingNode] = true;
        helpBfsTraverse(graph, startingNode, visited, answer);
        return answer;
    }

    private void helpDfsTraverse(Graph graph,
                                 int startingNode,
                                 boolean[] visited,
                                 List<Integer> answer) {
        answer.add(startingNode);
        visited[startingNode] = true;
        for (int node: graph.adjacencyList.get(startingNode)) {
            if (!visited[node]) helpDfsTraverse( graph, node, visited, answer);
        }
    }

    public List<Integer> dfsTraverse(Graph graph, int startingNode) {
        List<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[graph.size() + 1];
        Arrays.fill(visited, false);
        helpDfsTraverse(graph, startingNode, visited, answer);
        return answer;
    }


}
