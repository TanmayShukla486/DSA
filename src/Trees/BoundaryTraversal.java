package Trees;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private void leftBoundaryTraversal(TreeNode root, List<TreeNode> list) {
        TreeNode current = root.left;
        while (current != null){
            if (!isLeaf(current)) list.add(current);
            if (current.left != null) current = current.left;
            else current = current.right;
        }
    }

    private void rightBoundaryTraversal(TreeNode root, List<TreeNode> list) {
        TreeNode current = root.right;
        List<TreeNode> tempList = new ArrayList<>();
        while (current != null) {
            if (!isLeaf(current)) tempList.add(current);
            if (current.right != null) current = current.right;
            else current = current.left;
        }
        for (int i = tempList.size() - 1; i >= 0; i--)
            list.add(tempList.get(i));
    }

    private void leafTraversal(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        if (isLeaf(root)) list.add(root);
        leafTraversal(root.left, list);
        leafTraversal(root.right, list);
    }

    public void boundaryTraversal(TreeNode root) {
        if (root == null) return;
        List<TreeNode> answer = new ArrayList<>();
        answer.add(root);
        leftBoundaryTraversal(root, answer);
        leafTraversal(root, answer);
        rightBoundaryTraversal(root, answer);
        System.out.println(answer);
    }
}
