package Trees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserialize {
    public String serialize(TreeNode root) {
        Queue<TreeNode> cache = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        cache.add(root);
        while (!cache.isEmpty()) {
//            int size = cache.size();
//            int count = 0;
//            for (int i = 0; i < size; i++) {
//                TreeNode current = cache.poll();
//                assert current != null;
//                sb.append(current.nodeData).append(",");
//                if (current.left != null) cache.add(current.left);
//                else count++;
//                if (current.right != null) cache.add(current.right);
//                else count++;
//            }
//            sb.append("$,".repeat(Math.max(0, count)));
            TreeNode current = cache.poll();
            if (current == null) {
                sb.append("$,");
                continue;
            }
            sb.append(current.nodeData).append(",");
            cache.add(current.left);
            cache.add(current.right);
        }
        return sb.toString();
    }
    public TreeNode deserialize(String s) {
        String[] values = s.split(",");
        Queue<TreeNode> cache = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        cache.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = cache.poll();
            if (!values[i].equals("$")) {
                assert parent != null;
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                cache.add(left);
            }
            if (!values[++i].equals("$")) {
                assert parent != null;
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                cache.add(right);
            }
        }
        return root;
    }
}
