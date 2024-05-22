package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BurningTrees {

    private TreeNode findParentsAndTarget(TreeNode root,
                                          int target,
                                          Map<TreeNode, TreeNode> parents
    ) {
        Queue<TreeNode> cache = new LinkedList<>();
        cache.add(root);
        TreeNode targetNode = null;
        while (!cache.isEmpty()) {
            TreeNode current = cache.poll();
            if (current.nodeData == target) targetNode = current;
            if (current.left != null) {
                parents.put(current.left, current);
                cache.add(current.left);
            }
            if (current.right != null) {
                parents.put(current.right, current);
                cache.add(current.right);
            }
        }
        assert targetNode != null;
        return targetNode;
    }

    public int burnItAll(
            TreeNode root,
            int target
    ) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        TreeNode targetNode = findParentsAndTarget(root, target, parents);
        Queue<TreeNode> cache = new LinkedList<>();
        cache.add(targetNode);
        Map<TreeNode, Boolean> visitedNode = new HashMap<>();
        visitedNode.put(targetNode, true);
        int steps = 0;
        while (!cache.isEmpty()) {
            int size = cache.size();
            boolean burnedSomething = false;
            for (int i = 0; i < size; i++) {
                TreeNode current = cache.poll();
                assert current != null;
                if (current.left != null
                        && !visitedNode.getOrDefault(current.left, false)) {
                    burnedSomething = true;
                    cache.add(current.left);
                    visitedNode.put(current.left, true);
                }
                if (current.right != null
                        && !visitedNode.getOrDefault(current.right, false)) {
                    burnedSomething = true;
                    cache.add(current.right);
                    visitedNode.put(current.right, true);
                }
                if (parents.getOrDefault(current, null) != null
                        && !visitedNode.getOrDefault(
                                parents.get(current), false)) {
                    burnedSomething = true;
                    cache.add(parents.get(current));
                    visitedNode.put(parents.get(current), true);
                }
            }
            if (burnedSomething) steps++;
        }
        return steps;
    }
}
