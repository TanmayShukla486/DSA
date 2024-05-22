package Trees;

public class ChildSum {
    public void changeTree(TreeNode root) {
        if (root == null) return;
        int childSum = 0;
        childSum += (root.left != null) ? root.left.nodeData : 0;
        childSum += (root.right != null) ? root.right.nodeData : 0;
        if (childSum >= root.nodeData) root.nodeData = childSum;
        else {
            if (root.left != null) root.left.nodeData = root.nodeData;
            if (root.right != null) root.right.nodeData = root.nodeData;
        }
        changeTree(root.left);
        changeTree(root.right);

        int total = 0;
        total += (root.left != null) ? root.left.nodeData : 0;
        total += (root.right != null) ? root.right.nodeData : 0;
        if (root.left != null || root.right != null) root.nodeData = total;
    }
}
