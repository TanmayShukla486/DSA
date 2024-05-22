package Graphs;

import org.graalvm.collections.Pair;

import java.util.*;


public class PrimsAlgorithm {

    static class Item{
        int weight, node, parent;

        public Item(int weight, int node, int parent) {
            this.weight = weight;
            this.node = node;
            this.parent = parent;
        }
    }

    static class Edge{
        int fromNode, toNode;

        public Edge(int fromNode, int toNode) {
            this.fromNode = fromNode;
            this.toNode = toNode;
        }

        @Override
        public String toString(){
            return fromNode + "->" + toNode;
        }
    }

    public void findMST(WeightedG graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Edge> answer = new ArrayList<>();
        PriorityQueue<Item> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
        queue.add(new Item(0, 0, -1));
        while(!queue.isEmpty()) {
            Item current = queue.poll();
            if (current.parent != -1 && !visited[current.node])
                answer.add(new Edge(current.parent, current.node));
            visited[current.node] = true;
            for (Pair<Integer, Integer> adjacentNode: graph.adjacencyList.get(current.node)) {
                if (!visited[adjacentNode.getLeft()]) {
                    queue.add(new Item(adjacentNode.getRight(), adjacentNode.getLeft(), current.node));
                }
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        WeightedG graph = new WeightedG(6);
        new PrimsAlgorithm().findMST(graph);
    }

}
