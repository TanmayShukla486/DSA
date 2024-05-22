package LeetcodeProblems;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBT {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public boolean isCompleteTree(TreeNode root) {

        int levels = getHeight(root) - 1;
        int currLevel = 0;

        Queue<TreeNode> cache = new LinkedList<>();
        cache.add(root);

        while (!cache.isEmpty()) {

            int n = cache.size();

            if (currLevel < levels && (int) Math.pow(2, currLevel) != n) return false;
            for (int i = 0; i < n; i++) {
                TreeNode current = cache.poll();
                if (currLevel == levels - 1) {
                    if (current.left == null && current.right != null) return false;
                }
                if (current.left != null) cache.add(current.left);
                if (current.right != null) cache.add(current.right);
            }

        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null));
        new CheckCompletenessOfBT().isCompleteTree(root);
    }
}

