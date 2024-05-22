package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgorithm {
    private void dfsTime(DirectedGraph graph, boolean[] visited, Stack<Integer> timeSort, int node) {
        visited[node] = true;
        for (int adjacentNode: graph.adjacencyList.get(node)) {
            if (!visited[adjacentNode]) dfsTime(graph, visited, timeSort, adjacentNode);
        }
        timeSort.add(node);
    }

    private void normalDFS(List<List<Integer>> adjacencyList, boolean[] visited, int node) {
        visited[node] = true;
        for (int adjacentNode: adjacencyList.get(node)) {
            if (!visited[adjacentNode]) normalDFS(adjacencyList, visited, adjacentNode);
        }
    }

    public int findStronglyConnectedComponent(DirectedGraph graph) {

        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> sortedNodes = new Stack<>();
        for (int i = 0; i < visited.length; i++)
            if (!visited[i])
                dfsTime(graph, visited, sortedNodes, i);

        Arrays.fill(visited, false);
        List<List<Integer>> reversedGraph = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) reversedGraph.add(new ArrayList<>());
        for (int i = 0; i < graph.size(); i++) {
            for (int node: graph.adjacencyList.get(i)) {
                reversedGraph.get(node).add(i);
            }
        }

        int scc = 0;
        while(!sortedNodes.isEmpty()) {
            int node = sortedNodes.pop();
            if (!visited[node]) {
                scc++;
                normalDFS(reversedGraph, visited, node);
            }
        }
        return scc;
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(8);
        System.out.println(new KosarajuAlgorithm().findStronglyConnectedComponent(graph));
    }
}
