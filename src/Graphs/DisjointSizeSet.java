package Graphs;

import java.util.Arrays;

public class DisjointSizeSet {
    private final int[] size, parent;
    public DisjointSizeSet(int nodes) {
        size = new int[nodes + 1];
        parent = new int[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            size[i] = 1; parent[i] = i;
        }
    }

    private int getParent(int node) {
        if (parent[node] == node) return node;
        parent[node] = getParent(parent[node]);
        return parent[node];
    }

    public void findUnion(int n1, int n2) {
        int parent1 = getParent(n1);
;        int parent2 = getParent(n2);
        if (parent1 == parent2) return;
        int size1 = size[parent1];
        int size2 = size[parent2];
        if (size1 < size2) {
            parent[parent1] = parent2;
            size[parent2] = size1 + size2;
        } else if (size1 > size2) {
            parent[parent2] = parent1;
            size[parent1] = size1 + size2;
        } else {
            parent[parent2] = parent1;
            size[parent1] = size1 + size2;
        }
    }

    public boolean sameComponent(int n1, int n2) {
        return getParent(n1) == getParent(n2);
    }

    public static void main(String[] args) {
        DisjointSizeSet dss = new DisjointSizeSet(7);
        dss.findUnion(1,2);
        dss.findUnion(2,3);
        dss.findUnion(4,5);
        dss.findUnion(6,7);
        dss.findUnion(5,6);
        System.out.println("Same Component: " + ((dss.sameComponent(3, 7))));
        dss.findUnion(3, 7);
        System.out.println("Same Component: " + ((dss.sameComponent(3, 7))));
    }
}
