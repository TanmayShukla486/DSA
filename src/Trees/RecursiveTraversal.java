package Trees;

public class RecursiveTraversal {
    public void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.nodeData + "\t");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public void preOrderTraversal(BSTNode root) {
        if (root == null) return;
        System.out.print(root.nodeData + "\t");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.nodeData + "\t");
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.nodeData + "\t");
    }
}
