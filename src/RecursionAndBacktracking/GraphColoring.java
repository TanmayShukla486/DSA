package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class GraphColoring {

    /**
     * The problem is such that we have a graph and a set of m colors, and we have to color all the nodes in the
     * graph such that no adjacent nodes have the same colors
     * */

    public boolean isSafe(List<Integer>[] graph, int node, int i, int[] color) {
        // Checking each neighbor for the color, if any neighbor has the same color that we
        // are trying to fill in our current node then return false to state that the color
        // is not safe
        for (int neighbor: graph[node]) {
            if (color[neighbor] == i) return false;
        }
        return true;
    }
    /**
     * The color array stores the color of each node in the graph
     * m -> denotes the number of colors possible
     * */
    public boolean helper(List<Integer>[] graph, int node, int[] color, int n, int m) {
        if (node >= n) return true; // this statement means all the nodes have been filled thus returning true
        for (int i = 0; i < m; i++) {
            // looping through all the colors for each node
            if (isSafe(graph, node, i, color)) {
                // if the color is safe we assign it the current node and try for next node
                color[node] = i;
                // if the node was able to retain the color we assigned it will return true, and we can also return true
                if (helper(graph, node + 1, color, n, m)) return true;
                // if the color was not sustainable we remove the color and try others
                color[node] = -1;
            }
        }
        // if after looping through all the colors we were unable to assign a color to the current node
        // we return false to tell the prior calls that the current scheme of assigning colors is not
        // feasible
        return false;
    }

    public boolean graphColoring(List<Integer>[] graph, int[] color, int m) {
        int n = graph.length;
        return helper(graph, 0, color, n, m);
    }

    public static void main(String[] args) {
    }
}
