package LeetcodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
//    3
//            [[2,0,8],[1,0,10],[1,2,3],[0,2,4],[1,2,6],[1,1,3],[1,0,6],[0,2,4]]
//            [4,2,8]
static class Node {
    int value, cost;
    public Node(int value, int cost) {
        this.value = value;
        this.cost = cost;
    }
}

    private void helper(List<List<Node>> adjList, boolean[] visited, int[] answer, int[] disappear, int cost, int node) {
        if (disappear[node] <= cost) {
            return;
        }
        answer[node] = cost;
        visited[node] = true;
        int min = Integer.MAX_VALUE, nextNode = 0;
        for (Node adjacentNode: adjList.get(node)) {
            int nextCost = adjacentNode.cost + cost;
            if (!visited[adjacentNode.value] && disappear[adjacentNode.value] > nextCost && min > nextCost) {
                min = nextCost;
                nextNode = adjacentNode.value;
            }
        }
        if (min != Integer.MAX_VALUE) helper(adjList, visited, answer, disappear, min, nextNode);

    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int[] answer = new int[n];
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0], to = edges[i][1], wt = edges[i][2];
            adjList.get(from).add(new Node(to, wt));
            adjList.get(to).add(new Node(from, wt));
        }
        Arrays.fill(answer, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        helper(adjList, visited, answer, disappear, 0, 0);
        for (int i = 0; i < n; i++)
            if (answer[i] == Integer.MAX_VALUE) answer[i] = -1;
        return answer;
    }

    public static void main(String[] args) {
        new Graph().minimumTime(3, new int[][]{{2,0,8},{1,0,10},{1,2,3},{0,2,4},{1,2,6},{1,1,3},{1,0,6},{0,2,4}}, new int[] {4,2,8});
    }
}
