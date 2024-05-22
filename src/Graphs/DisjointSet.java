package Graphs;

import java.util.Arrays;

public class DisjointSet {
    private final int[] rank, parent;
    public DisjointSet(int size) {
        rank = new int[size + 1];
        parent = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            rank[i] = 0; parent[i] = i;
        }
    }

    private int getParent(int node) {
        if (node == parent[node]) return node;
        parent[node] = getParent(parent[node]);
        return parent[node];
    }

    public void findUnion(int u, int v) {
        int uParent = getParent(u);
        int vParent = getParent(v);
        if (uParent == vParent) return;
        int rankUParent = rank[uParent];
        int rankVParent = rank[vParent];
        if (rankUParent < rankVParent) {
            parent[u] = vParent;
        } else if (rankUParent > rankVParent) {
            parent[v] = uParent;
        } else {
            parent[v] = uParent;
            rank[uParent]++;
        }
    }

    public boolean sameComponent(int v, int u) {
        return getParent(v) == getParent(u);
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.findUnion(1,2);
        ds.findUnion(2,3);
        ds.findUnion(4,5);
        ds.findUnion(6,7);
        ds.findUnion(5,6);
        if (ds.sameComponent(3, 7))
            System.out.println("Same");
        else
            System.out.println("Not Same");
        ds.findUnion(3,7);
        if (ds.sameComponent(3, 7))
            System.out.println("Same");
        else
            System.out.println("Not Same");
    }
}
