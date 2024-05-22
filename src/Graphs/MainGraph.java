package Graphs;

import java.util.List;
import java.util.Scanner;

public class MainGraph {

    private static Graph userGraph;
    private final static boolean takeInput;

    private static Graph genericGraph;

    private final static String s = "1 2\n1 3\n2 5\n3 4\n2 6\n3 7\n4 8";
    private final static int n = 8;

    static {
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 0 if not taking user input for dfs or bfs");
        takeInput = sc.nextInt() == 1;
        if (takeInput)
            userGraph = Graph.takeInput();
        else
            genericGraph = Graph.genericGraph(s, n);
    }

    public static void main(String[] args) {
        /* Adjacency list based graph operations*/
        if (takeInput) {
            for (List<Integer> list : userGraph.adjacencyList)
                System.out.println(list);
            System.out.println(new BipartiteGraph().checkBipartiteBFS(userGraph, 1));
            System.out.println(new BipartiteGraph().checkBipartiteDFS(userGraph, 1));
        }
        else {
            for (List<Integer> list : genericGraph.adjacencyList)
                System.out.println(list);
//            List<Integer> bfs = new Traversal().bfsTraverse(genericGraph, 4);
//            System.out.println(bfs);
//            List<Integer> dfs = new Traversal().dfsTraverse(genericGraph, 3);
//            System.out.println(dfs);
//            new CycleDetection().detectCycleDFS(genericGraph, 1);
            new ShortestPath().shortestDistanceUndirected(genericGraph, 4);
        }
////        RottenOranges rotten = new RottenOranges(3,3);
//        rotten.findTimeTaken();

        /*Custom 2D array based graph operations*/
//        ConnectedIslands islands = new ConnectedIslands(4, 5);
//        System.out.println(islands.distinctIslands());
//        DirectedGraph graph = new DirectedGraph(10);
//        System.out.println(graph.adjacencyList);
//        System.out.println(new CycleDetection().detectCycleDirected(graph));
//        new TopologicalSort().findOrder(graph);
//        NearestOne oneGraph = new NearestOne();
//        oneGraph.findNearestOne();
//        DirectedGraph kahnAlgoGraph = new DirectedGraph(6);
//        new KahnAlgorithm().findTopologicalSort(kahnAlgoGraph);
//        System.out.println(new CycleViaBfs().hasCycle(kahnAlgoGraph));
//        new CourseSchedule().findOrderOfJobs();

//        String[] wordOrder = {"baa", "abcd", "abca", "cab", "cad"};
//        new AlienDictionary().findDictionary(4, wordOrder);
    }
}
