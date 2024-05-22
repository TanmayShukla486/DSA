package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**0 Based Indexing Graph*/
public class DirectedGraph {
    public List<List<Integer>> adjacencyList;
    private final int size;

    private final String s = """
            1 2
            2 3
            3 4
            3 7
            4 5
            7 5
            5 6
            8 9
            9 10
            10 8""";

    public DirectedGraph(int size) {
        this.size = size;
        adjacencyList = new ArrayList<>();
        createEmptyGraph();
    }

    private void takeInput(Scanner sc) {
        System.out.println("Enter the number of edges");
        int m = Integer.parseInt(sc.nextLine());
        System.out.println("Enter the edges in the format 1 -> 2 without arrows");
        for (int i = 0; i < m; i++) {
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjacencyList.get(input[0]).add(input[1]);
        }
    }

    private void formGraph(Scanner sc) {
        sc = new Scanner(s);
        while (sc.hasNextLine()) {
            int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            adjacencyList.get(input[0] - 1).add(input[1] - 1);
        }
    }

    private void createEmptyGraph() {
        for (int i = 0; i < size; i++) adjacencyList.add(new ArrayList<>());
        System.out.println("Would you like to input edges if yes enter 1");
        Scanner sc = new Scanner(System.in);
        if ((Integer.parseInt(sc.nextLine()) == 1)) {
            takeInput(sc);
        } else formGraph(sc);
    }

    public int size(){
        return size;
    }
}
