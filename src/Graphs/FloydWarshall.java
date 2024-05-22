package Graphs;


import org.graalvm.collections.Pair;

import java.util.Arrays;
import java.util.List;

class WeightedDGMatrix {
    int[][] matrix;
    int infinity;
    public WeightedDGMatrix(WeightedDG graph) {
        matrix = new int[graph.size()][graph.size()];
        infinity = (int) 1e9;
        createGraph(graph);
    }

    private void createGraph(WeightedDG graph) {
        for (int i = 0; i < graph.size(); i++)
            Arrays.fill(matrix[i], infinity);
        for (int i = 0; i < graph.size(); i++) {
            matrix[i][i] = 0;
            for (Pair<Integer, Integer> adjacentNode: graph.adjacencyList.get(i)) {
                matrix[i][adjacentNode.getLeft()] = adjacentNode.getRight();
            }
        }
    }
}

public class FloydWarshall {

    private final WeightedDGMatrix graph;

    public FloydWarshall(WeightedDG graph) {
        this.graph = new WeightedDGMatrix(graph);
        for (int i = 0; i < this.graph.matrix.length; i++)
            System.out.println(Arrays.toString(this.graph.matrix[i]));
    }

    public void findMatrix() {
        for (int i = 0; i < graph.matrix.length; i++) {
            for (int j = 0; j < graph.matrix.length; j++) {
                for (int k = 0; k < graph.matrix.length; k++) {
                    graph.matrix[j][k] = Math.min(
                            graph.matrix[j][k],
                            graph.matrix[j][i] + graph.matrix[i][k]
                    );
                }
            }
        }
        for (int i = 0; i < graph.matrix.length; i++)
            System.out.println(Arrays.toString(graph.matrix[i]));
    }

    public static void main(String[] args) {
        WeightedDG graph = new WeightedDG(4);
        new FloydWarshall(graph).findMatrix();
    }
}
