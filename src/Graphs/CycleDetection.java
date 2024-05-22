package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetection {
    static class ChildNode {
        int nodeValue;
        int parentValue;

        public ChildNode(int nodeValue, int parentValue) {
            this.nodeValue = nodeValue;
            this.parentValue = parentValue;
        }
    }

    public void detectCycleBFS(Graph graph, int startingNode) {

        Queue<ChildNode> cache = new LinkedList<>();
        cache.add(new ChildNode(startingNode, -1));

        List<List<Integer>> adjacencyLists = graph.adjacencyList;

        boolean[] visited = new boolean[graph.size() + 1];
        Arrays.fill(visited, false);
        visited[startingNode] = true;

        boolean hasCycle = false;

        while(!cache.isEmpty() && !hasCycle) {
            ChildNode current = cache.poll();
            for (int node: adjacencyLists.get(current.nodeValue)) {
                if (!visited[node]) {
                    visited[node] = true;
                    cache.add(new ChildNode(node, current.nodeValue));
                } else if (node != current.parentValue) {
                    hasCycle = true;
                    break;
                }
            }
        }
        if (hasCycle) System.out.println("Cycle exists");
        else System.out.println("Cycle does not exist");
    }

    private boolean hasCycle(Graph graph, ChildNode node, boolean[] visited) {
        visited[node.nodeValue] = true;
        boolean cycleExists = false;
        for (int current: graph.adjacencyList.get(node.nodeValue)) {
            if (cycleExists) break;
            if (!visited[current]) cycleExists =  hasCycle(graph, new ChildNode(current, node.nodeValue), visited);
            else if (node.parentValue != current) return true;
        }
        return cycleExists;
    }

    public void detectCycleDFS(Graph graph, int startingNode) {
        boolean[] visited = new boolean[graph.size() + 1];
        Arrays.fill(visited, false);
        if (hasCycle(graph, new ChildNode(startingNode, -1), visited))
            System.out.println("Has Cycle");
        else System.out.println("Doesn't Have Cycle");
    }

    private boolean directedHasCycle(DirectedGraph graph, int node,
                                     boolean[] visited, boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int adjacentNode: graph.adjacencyList.get(node)) {
            if (!visited[adjacentNode]) {
                if (directedHasCycle(graph, adjacentNode, visited, pathVisited)) return true;
            }
            else if (pathVisited[adjacentNode]) return true;
        }
        pathVisited[node] = false;
        return false;
    }


    public boolean detectCycleDirected(DirectedGraph graph) {
        boolean[] visited = new boolean[graph.size() + 1], pathVisited = new boolean[graph.size() + 1];
        for (int i = 1; i < visited.length; i++) {
            if (directedHasCycle(graph, i, visited, pathVisited)) return true;
        }
        return false;
    }
}
