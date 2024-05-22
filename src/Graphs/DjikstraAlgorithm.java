package Graphs;

import org.graalvm.collections.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DjikstraAlgorithm {
    public void findShortestPath(WeightedG graph, int startingNode) {
        int[] distance = new int[graph.size()];
        int infinity = (int) 1e9;
        Arrays.fill(distance, infinity);
        PriorityQueue<Pair<Integer, Integer>> cache = new PriorityQueue<>(Comparator.comparingInt(Pair::getRight));
        distance[startingNode] = 0;
        cache.add(Pair.create(startingNode, 0));
        while (!cache.isEmpty()) {
            Pair<Integer, Integer> current = cache.poll();
            for (Pair<Integer, Integer> node: graph.adjacencyList.get(current.getLeft())) {
                int currentDistance = current.getRight() + node.getRight();
                if (distance[node.getLeft()] > currentDistance) {
                    distance[node.getLeft()] = currentDistance;
                    cache.add(Pair.create(node.getLeft(), currentDistance));
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }

    public static void main(String[] args) {
        new DjikstraAlgorithm().findShortestPath(new WeightedG(6), 0);
    }
}
