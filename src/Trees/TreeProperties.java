package Trees;

public class TreeProperties {
    public int maxHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));
    }
    public boolean checkBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) return false;
        return checkBalanced(root.left) && checkBalanced(root.right);
    }

    public int diameterOfTree(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxHeight(root.left);
        int rightHeight = maxHeight(root.right);
        return Math.max(leftHeight + rightHeight, Math.max(diameterOfTree(root.left), diameterOfTree(root.right)));
    }

    public boolean areIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return (root1 == root2);
        return (root1.nodeData == root2.nodeData)
                && areIdentical(root1.left, root2.left)
                && areIdentical(root1.right, root2.right);
    }
}
