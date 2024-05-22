package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**1 Based Indexed Undirected Graph*/
public class Graph {
    private final int size;
    public List<List<Integer>> adjacencyList;

    private Graph(int size) {
        this.size = size;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public int size() {
        return size;
    }

    public static Graph takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the number of edges");
        int m = Integer.parseInt(sc.nextLine());
        Graph newGraph = new Graph(n);
        for (int i = 0; i < m; i++) {
            String[] input = sc.nextLine().split(" ");
            int[] intInput = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            newGraph.adjacencyList.get(intInput[0]).add(intInput[1]);
            newGraph.adjacencyList.get(intInput[1]).add(intInput[0]);
        }
        return newGraph;
    }

    public static Graph genericGraph(String s, int n) {
        Graph newGraph = new Graph(n);
        Scanner sc = new Scanner(s);
        while(sc.hasNextLine()) {
            int[] input = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            newGraph.adjacencyList.get(input[0]).add(input[1]);
            newGraph.adjacencyList.get(input[1]).add(input[0]);
        }
        return newGraph;
    }
}
