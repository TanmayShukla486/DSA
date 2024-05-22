package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {


    /*TODO
    *  Implement the functionality of covering non connected nodes to the graph as well*/
    private int getNode(char a) {
        return a - 97;
    }

    private char getChar(int node) {
        return (char) (node + 97);
    }

    public void findDictionary(int n, String[] wordOrder) {

        // creating the empty adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjacencyList.add(new ArrayList<>());

        for (int i = 0; i < wordOrder.length - 1; i++) {
            String first = wordOrder[i], second = wordOrder[i + 1];
            int length = Math.min(first.length(), second.length());
            for (int j = 0; j < length; j++) {
                if (first.charAt(j) == second.charAt(j)) continue;
                adjacencyList.get(getNode(first.charAt(j))).add(getNode(second.charAt(j)));
                break;
            }
        }

        int[] inDegree = new int[n];
        for (List<Integer> nodeList: adjacencyList)
            for (int node: nodeList) inDegree[node]++;

        Queue<Integer> cache = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0) cache.add(i);

        List<Character> answer = new ArrayList<>();
        while (!cache.isEmpty()) {
            int node = cache.poll();
            answer.add(getChar(node));
            for (int adjacentNode: adjacencyList.get(node)) {
                inDegree[adjacentNode]--;
                if (inDegree[adjacentNode] == 0) cache.add(adjacentNode);
            }
        }

        System.out.println(answer);
    }
}
