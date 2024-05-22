package Graphs;

import org.graalvm.collections.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WeightedDG {
    public List<List<Pair<Integer, Integer>>> adjacencyList;

    private Scanner sc;

    private final String s = """
            6 4 2
            6 5 3
            5 4 1
            4 0 3
            4 2 1
            0 1 2
            1 3 1
            2 3 3
            """;
    private final int size;

    private final boolean userInput;
    public WeightedDG(int size) {
        sc = new Scanner(System.in);
        this.size = size;
        adjacencyList = new ArrayList<>();
        createEmptyGraph();
        System.out.println("Type 1 if user input");
        if (Integer.parseInt(sc.nextLine()) == 1){
            userInput = true;
        }
        else {
            sc = new Scanner(s);
            userInput = false;
        }
        createGraph();
    }

    private void createEmptyGraph() {
        for (int i = 0; i < size; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    private void createGraph() {
        if (userInput) {
            System.out.println("Enter the number of edges");
            int edges = Integer.parseInt(sc.nextLine());
            System.out.println("Enter the edges in the format: from to weight");
            for (int i = 0; i < edges; i++) {
                int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                adjacencyList.get(input[0]).add(Pair.create(input[1], input[2]));
            }
        } else {
            while (sc.hasNextLine()) {
                int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                adjacencyList.get(input[0]).add(Pair.create(input[1], input[2]));
            }
        }
    }

    public int size(){
        return size;
    }

}
