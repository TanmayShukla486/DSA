package Trees;

public class CountNodes {

    private int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root.left != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    private int getRightHeight(TreeNode root) {
        int count = 0;
        while (root.right != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    public int count (TreeNode root) {
        if (root == null) return 0;
        int left = getLeftHeight(root);
        int right = getRightHeight(root);
        if (left == right) return 1 << left - 1;
        return 1 + count(root.left) + count(root.right);
    }
}
