package Trees;

public class CommonAncestor {

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private TreeNode helper(TreeNode root, int n1, int n2) {
        if (root == null || root.nodeData == n1 || root.nodeData == n2) return root;
        TreeNode left = helper(root.left, n1, n2);
        TreeNode right = helper(root.right, n1, n2);
        if (left == null) return right;
        else if (right == null) return left;
        else return root;
    }

    public void findCommonAncestor(TreeNode root, int node1, int node2) {
        System.out.println(helper(root, node1, node2));
    }
}
