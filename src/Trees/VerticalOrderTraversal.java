package Trees;

import java.util.*;

public class VerticalOrderTraversal {

    static class Tuple {
        public TreeNode node;
        public int row, col;
        public Tuple(TreeNode _node, int _row, int _col) {
            node = _node;
            row = _row;
            col = _col;
        }
    }

    public void traversal (TreeNode root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> traversalData = new TreeMap<>();
        Queue<Tuple> cache = new LinkedList<>();
        cache.add(new Tuple(root, 0, 0));
        while (!cache.isEmpty()) {
            Tuple current = cache.poll();
            // Checking if there is an entry for the current column and if not creating one
            if (!traversalData.containsKey(current.col))
                traversalData.put(current.col, new TreeMap<>());
            // Checking if there is an entry for the current row and if not creating one
            if (!traversalData.get(current.col).containsKey(current.row))
                traversalData.get(current.col).put(current.row, new PriorityQueue<>());
            traversalData.get(current.col).get(current.row).add(current.node.nodeData);
            if (current.node.left != null)
                cache.add(new Tuple(current.node.left, current.row + 1, current.col - 1));
            if (current.node.right != null)
                cache.add(new Tuple(current.node.right, current.row + 1, current.col + 1));
        }
        List<Integer> answer = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> verticalLine: traversalData.values()) {
            for (PriorityQueue<Integer> values: verticalLine.values()) {
                answer.addAll(values);
            }
        }
        System.out.println(answer);
    }
}
