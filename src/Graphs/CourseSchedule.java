package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    private final static int[][] prerequisites = {
            {1, 0},
            {2, 1},
            {3, 2}
    };
    private final static int jobs = 4;
    private final static int preReq = prerequisites.length;

    public void findOrderOfJobs() {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < jobs; i++) adjacencyList.add(new ArrayList<>());
        for (int i = 0; i < preReq; i++)
            adjacencyList.get(prerequisites[i][0]).add(prerequisites[i][1]);
        int[] inDegree = new int[jobs];
        for (List<Integer> nodeList: adjacencyList)
            for (int node: nodeList) inDegree[node]++;
        Queue<Integer> cache = new LinkedList<>();
        for (int i = 0; i < jobs; i++)
            if (inDegree[i] == 0) cache.add(i);
        List<Integer> answer = new ArrayList<>();
        while (!cache.isEmpty()) {
            int node = cache.poll();
            answer.add(node);
            for (int adjacentNode: adjacencyList.get(node)) {
                inDegree[adjacentNode]--;
                if (inDegree[adjacentNode] == 0) cache.add(adjacentNode);
            }
        }
        if (answer.size() == jobs)
            System.out.println(answer);
    }
}
