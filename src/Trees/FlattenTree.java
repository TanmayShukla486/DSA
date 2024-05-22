package Trees;

public class FlattenTree {
    private TreeNode prev;
    public void flatten(TreeNode root) {
        // Base Case
        if (root == null) return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}
