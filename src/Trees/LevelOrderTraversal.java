package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public void traversal(TreeNode root) {
        Queue<TreeNode> cache = new LinkedList<TreeNode>();
        cache.add(root);
        while (!cache.isEmpty()){
            TreeNode currRoot = cache.poll();
            if (currRoot.left != null) cache.add(currRoot.left);
            if (currRoot.right != null) cache.add(currRoot.right);
            System.out.print(currRoot.nodeData + "\t");
        }
    }
    public void traversal(BSTNode root) {
        Queue<BSTNode> cache = new LinkedList<>();
        cache.add(root);
        while (!cache.isEmpty()){
            int size = cache.size();
            List<BSTNode> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                BSTNode currRoot = cache.poll();
                assert currRoot != null;
                if (currRoot.left != null) cache.add(currRoot.left);
                if (currRoot.right != null) cache.add(currRoot.right);
                level.add(currRoot);
            }
            System.out.println(level);
        }
    }
}
