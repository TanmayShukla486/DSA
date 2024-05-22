package Graphs;

import org.graalvm.collections.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WeightedG {

    private final static String s = """
            0 1 4
            0 2 4
            1 2 4
            2 3 3
            2 4 1
            2 5 6
            4 5 3
            3 5 2
            """;

    private final int size;
    public List<List<Pair<Integer, Integer>>> adjacencyList;

    public WeightedG(int size) {
        this.size = size;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        createGraph();
        displayAdjacencyList();
    }

    public int size() {
        return size;
    }

    private void createGraph() {
        Scanner sc = new Scanner(s);
        while (sc.hasNextLine()) {
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjacencyList.get(input[0]).add(Pair.create(input[1], input[2]));
            adjacencyList.get(input[1]).add(Pair.create(input[0], input[2]));
        }
    }

    private void displayAdjacencyList() {
        for (List<Pair<Integer, Integer>> nodeList: adjacencyList)
            System.out.println(nodeList);
    }
}
