package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DistanceOfK {

    private TreeNode findParentLinks (
            TreeNode root,
            int target,
            Map<TreeNode, TreeNode> parents
    ) {
        TreeNode targetNode = null;
        Queue<TreeNode> cache = new LinkedList<>();
        cache.add(root);
        while(!cache.isEmpty()) {
            TreeNode current = cache.poll();
            if (current.nodeData == target) targetNode = current;
            if (current.left != null) {
                cache.add(current.left);
                parents.put(current.left, current);
            }
            if (current.right != null) {
                cache.add(current.right);
                parents.put(current.right, current);
            }
        }
        assert targetNode != null;
        return targetNode;
    }
    public void findNodes (
            TreeNode root,
            int target,
            int k
    ) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        TreeNode targetNode = findParentLinks(root, target, parents);
        Map<TreeNode, Boolean> visitedNodes = new HashMap<>();
        Queue<TreeNode> cache = new LinkedList<>();
        cache.add(targetNode);
        visitedNodes.put(targetNode, true);
        int curr_lvl = 0;
        while (!cache.isEmpty()) {
            int size = cache.size();
            if (curr_lvl == k) break;
            curr_lvl++;
            // Going through all the nodes in the current level
            for (int i = 0; i < size; i++) {
                TreeNode current = cache.poll();
                assert current != null;
                if (current.left != null
                        && !visitedNodes.getOrDefault(current.left, false)
                ) {
                    cache.add(current.left); visitedNodes.put(current.left, true);
                }
                if (current.right != null
                        && !visitedNodes.getOrDefault(current.right, false)) {
                    cache.add(current.right); visitedNodes.put(current.right, true);
                }
                if (parents.getOrDefault(current, null) != null
                        && !visitedNodes.getOrDefault(parents.get(current), false)) {
                    cache.add(parents.get(current)); visitedNodes.put(parents.get(current), true);
                }
            }
        }
        System.out.println(cache);
    }
}
