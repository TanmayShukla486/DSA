package Graphs;

import org.graalvm.collections.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ShortestPath {

    private void topoSortDFS(int node, Stack<Integer> topoSort, boolean[] visited, WeightedDG graph) {
        visited[node] = true;
        for (Pair<Integer, Integer> adjacentNode : graph.adjacencyList.get(node)) {
            if (!visited[adjacentNode.getLeft()]) topoSortDFS(adjacentNode.getLeft(), topoSort, visited, graph);
        }
        topoSort.add(node);
    }

    public void shortestDistance(WeightedDG graph, int startingNode) {
        Stack<Integer> topoSort = new Stack<>();
        boolean[] visited = new boolean[graph.size()];
        for (int i = 0; i < visited.length; i++)
            if (!visited[i]) topoSortDFS(i, topoSort, visited, graph);
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, (int) 1e9);
        distance[startingNode] = 0;
        while (!topoSort.isEmpty()) {
            int node = topoSort.pop();
            for (Pair<Integer, Integer> adjacentNode: graph.adjacencyList.get(node)) {
                int adjNodeVal = adjacentNode.getLeft();
                int wt = adjacentNode.getRight();
                distance[adjNodeVal] = Math.min(distance[adjNodeVal], wt + distance[node]);
            }
        }
        System.out.println(Arrays.toString(distance));
    }

    public void shortestDistanceUndirected(Graph graph, int startingNode) {
        Queue<Pair<Integer, Integer>> cache = new LinkedList<>();
        int infinity = (int) 1e9;
        int[] distance = new int[graph.size() + 1];
        Arrays.fill(distance, infinity);
        distance[startingNode] = 0;
        cache.add(Pair.create(startingNode, 0));
        while(!cache.isEmpty()) {
            Pair<Integer, Integer> currNode = cache.poll();
            for (int node: graph.adjacencyList.get(currNode.getLeft())) {
                if (distance[node] == infinity) {
                    cache.add(Pair.create(node, currNode.getRight() + 1));
                    distance[node] = currNode.getRight() + 1;
                } else distance[node] = Math.min(currNode.getRight() + 1, distance[node]);
            }
        }
        System.out.println(Arrays.toString(distance));
    }

    public static void main(String[] args) {
        WeightedDG graph = new WeightedDG(7);
        new ShortestPath().shortestDistance(graph, 5);
    }
}
