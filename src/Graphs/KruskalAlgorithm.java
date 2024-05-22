package Graphs;

import java.util.*;

public class KruskalAlgorithm {

    static class Edge{
        int from, to, weight;
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        @Override
        public String toString() {
            return from + "->" + to + "(" + weight + ")";
        }
    }

    DisjointSizeSet disjointSizeSet;
    PriorityQueue<Edge> edges;
    public KruskalAlgorithm(int size) {
        // 0 based indexing
        edges = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
        disjointSizeSet = new DisjointSizeSet(size);
    }

    private List<Edge> findMST() {
        int sum = 0;
        List<Edge> answer = new ArrayList<>();
        while(!edges.isEmpty()) {
            Edge currentEdge = edges.poll();
            if (!disjointSizeSet.sameComponent(currentEdge.from, currentEdge.to)) {
                disjointSizeSet.findUnion(currentEdge.from, currentEdge.to);
                sum += currentEdge.weight;
                answer.add(currentEdge);
            }
        }
        System.out.println("Weight -> " + sum);
        return answer;
    }

    public void takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of edges");
        int edgeCount = Integer.parseInt(sc.nextLine());
        System.out.println("Enter edges as from to weight");
        for (int i = 0; i < edgeCount; i++) {
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            edges.add(new Edge(input[0], input[1], input[2]));
        }
    }

    public static void main(String[] args) {
        KruskalAlgorithm object = new KruskalAlgorithm(6);
        object.takeInput();
        System.out.println(object.findMST());
    }
}
