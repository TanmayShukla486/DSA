package Trees;

import java.util.ArrayList;
import java.util.List;

public class PathToNode {

    private boolean helper(TreeNode root, int target, List<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root.nodeData == target) return true;
        boolean isInLeftBranch = helper(root.left, target, path);
        boolean isInRightBranch = helper(root.right, target, path);
        if (!isInRightBranch && !isInLeftBranch) {
            path.remove(root);
            return false;
        }
        return true;
    }
    public void findPath(TreeNode root, int target) {
        List<TreeNode> path = new ArrayList<>();
        if (helper(root, target, path))
            System.out.println(path);
    }
}
