package Trees;

import java.util.ArrayList;
import java.util.List;

public class LeftRightViewTraversal {
    private void leftView(TreeNode root, int level, List<TreeNode> list) {
        if (root == null) return;
        if (level == list.size()) list.add(root);
        leftView(root.left, level + 1, list);
        leftView(root.right, level + 1, list);
    }

    private void rightView(TreeNode root, int level, List<TreeNode> list) {
        if (root == null) return;
        if (level == list.size()) list.add(root);
        rightView(root.right, level + 1, list);
        rightView(root.left, level + 1, list);
    }

    public void traversal(TreeNode root, char choice) {
        List<TreeNode> traversalOrder = new ArrayList<>();
        switch(choice) {
            case 'l' -> leftView(root, 0, traversalOrder);
            case 'r' -> rightView(root, 0, traversalOrder);
            default -> System.out.println("Invalid Choice");
        }
        System.out.println(traversalOrder);
    }
}
