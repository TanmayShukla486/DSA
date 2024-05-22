package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfTree {

    static class Position {
        TreeNode node;
        int position;

        public Position(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    public void findWidth(TreeNode root) {
        Queue<Position> cache = new LinkedList<>();
        cache.add(new Position(root, 0));
        int ans = 0;
        while (!cache.isEmpty()) {
            int size = cache.size();
            int first = 0, last = 0;
            int minVal = cache.peek().position;
            for (int i = 0; i < size; i++) {
                Position current = cache.poll();
                assert current != null;
                int val = current.position - minVal;
                if (i == 0) first = val;
                else if (i == size - 1)
                    last = val;
                if (current.node.left != null)
                    cache.add(new Position(current.node.left, 2 * val + 1));
                if (current.node.right != null)
                    cache.add(new Position(current.node.right, 2 * (val + 1)));
            }
            ans = Math.max(ans, last - first + 1);
        }
        System.out.println(ans);
    }
}
