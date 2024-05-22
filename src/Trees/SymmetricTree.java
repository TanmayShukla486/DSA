package Trees;

public class SymmetricTree {
    private boolean areSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return (root1 == root2);
        return (root1.nodeData == root2.nodeData)
                && areSymmetrical(root1.left, root2.right)
                && areSymmetrical(root1.right, root2.left);
    }

    public boolean checkSymmetry(TreeNode root) {
        return areSymmetrical(root.left, root.right);
    }
}
