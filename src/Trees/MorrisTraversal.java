package Trees;

import java.util.ArrayList;
import java.util.List;

public class MorrisTraversal {
    public void traversal(TreeNode root) {
        List<TreeNode> answer = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                answer.add(curr);
                curr = curr.right;
            }
            else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr)
                    temp = temp.right;
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                }
                else {
                    temp.right = null;
                    answer.add(curr);
                    curr = curr.right;
                }
            }
        }
        System.out.println(answer);
    }
}
