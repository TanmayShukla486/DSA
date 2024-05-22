package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TarjanAlgorithm {

    private int timer = 1;
    private void dfs(List<List<Integer>> adjacencyList,
                     int node,
                     int parent,
                     List<List<Integer>> answer,
                     boolean[] visited,
                     int[] timeOfInsertion,
                     int[] lowestTime
                     ) {
        visited[node] = true;
        timeOfInsertion[node] = lowestTime[node] = timer; timer++;
        for (int adjacent: adjacencyList.get(node)) {
            if (adjacent == parent) continue;
            if (!visited[adjacent]) {
                dfs(adjacencyList, adjacent, node, answer, visited, timeOfInsertion, lowestTime);
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[adjacent]);
                if (lowestTime[adjacent] > timeOfInsertion[node])
                    answer.add(Arrays.asList(node, adjacent));
            } else {
                lowestTime[node] = Math.min(lowestTime[node], lowestTime[adjacent]);
            }
        }
    }

    public void findBridges(List<List<Integer>> adjacencyList, int size) {
        List<List<Integer>> answer = new ArrayList<>();
        int[] timeOfInsertion = new int[size + 1];
        int[] lowestTime = new int[size + 1];
        boolean[] visited = new boolean[size + 1];
        Arrays.fill(visited, false);

        dfs(adjacencyList, 1, -1, answer, visited, timeOfInsertion, lowestTime);
        System.out.println(answer);
    }

    public static void main(String[] args) {
       List<List<Integer>> adjacencyList = new ArrayList<>();
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the number of nodes");
       int size = Integer.parseInt(sc.nextLine());
       for (int i = 0; i <= size; i++) adjacencyList.add(new ArrayList<>());
       System.out.println("Enter the number of edges");
       int edges = Integer.parseInt(sc.nextLine());
       for (int i = 0; i < edges; i++) {
           int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
           adjacencyList.get(input[0]).add(input[1]);
           adjacencyList.get(input[1]).add(input[0]);
       }
       new TarjanAlgorithm().findBridges(adjacencyList, size);
    }
}
