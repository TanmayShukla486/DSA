package Graphs;

import org.graalvm.collections.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {

    static class Edge {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    private List<Edge> createEdges(WeightedDG graph) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            for (Pair<Integer, Integer> node: graph.adjacencyList.get(i))
                edges.add(new Edge(i, node.getLeft(), node.getRight()));
        }
        return edges;
    }

    public void findMinDistance(WeightedDG graph, int startingNode) {

        int n = graph.size();
        List<Edge> edges = createEdges(graph);

        int infinity = (int) 1e9;
        int[] distance = new int[graph.size()];
        Arrays.fill(distance, infinity);
        distance[startingNode] = 0;

        for (int i = 0; i < n; i++)
            for (Edge edge: edges) {
                if (distance[edge.start] == infinity) continue;
                int newDistance = distance[edge.start] + edge.weight;
                if (distance[edge.end] > newDistance)
                    distance[edge.end] = newDistance;
            }
        System.out.println(Arrays.toString(distance));
    }

    public static void main(String[] args) {
        WeightedDG graph = new WeightedDG(6);
        new BellmanFord().findMinDistance(graph, 0);
    }

}
