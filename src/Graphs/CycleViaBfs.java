package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleViaBfs {

    public boolean hasCycle(DirectedGraph graph) {
        int[] inDegree = new int[graph.size()];
        for (List<Integer> nodeList: graph.adjacencyList)
            for (int node: nodeList) inDegree[node]++;

        Queue<Integer> cache = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++)
            if (inDegree[i] == 0) cache.add(i);

        List<Integer> answer = new ArrayList<>();
        while (!cache.isEmpty()) {
            int node = cache.poll();
            answer.add(node);
            for (int adjacentNode: graph.adjacencyList.get(node)) {
                inDegree[adjacentNode]--;
                if (inDegree[adjacentNode] == 0) cache.add(adjacentNode);
            }
        }
        return !(answer.size() == graph.size());
    }
}
