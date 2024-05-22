package Trees;

import java.util.*;

public class TopViewTraversal {
    static class Tuple{
        public TreeNode node;
        public int  col;
        public Tuple(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public void traversal(TreeNode root) {
        TreeMap<Integer, TreeNode> traversalData = new TreeMap<>();
        Queue<Tuple> cache = new LinkedList<>();
        cache.add(new Tuple(root, 0));
        while (!cache.isEmpty()) {
            Tuple current = cache.poll();
            if (!traversalData.containsKey(current.col))
                traversalData.put(current.col, current.node);
            if (current.node.left != null)
                cache.add(new Tuple(current.node.left, current.col - 1));
            if (current.node.right != null)
                cache.add(new Tuple(current.node.right, current.col + 1));
        }
        List<TreeNode> answer = new ArrayList<>(traversalData.values());
        System.out.println(answer);
    }
}
