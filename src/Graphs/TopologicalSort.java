package Graphs;

import java.util.Stack;

public class TopologicalSort {

    private void helpFindOrder(
            DirectedGraph graph,
            boolean[] visited,
            Stack<Integer> nodes,
            int node
    ) {
        visited[node] = true;
        for (int adjacentNode: graph.adjacencyList.get(node)) {
            if (!visited[adjacentNode]) helpFindOrder(graph, visited, nodes, adjacentNode);
        }
        nodes.add(node);
    }

    public void findOrder(DirectedGraph graph) {
        boolean[] visited = new boolean[graph.size() + 1];
        Stack<Integer> nodes = new Stack<>();
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) helpFindOrder(graph, visited, nodes, i);
        }
        while(!nodes.isEmpty())
            System.out.print(nodes.pop() + "\t");
        System.out.println();
    }

}
