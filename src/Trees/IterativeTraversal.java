package Trees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Stack;

public class IterativeTraversal {

    /**Root -> Left -> Right*/
    public void preOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode current = stack.pop();
            System.out.print(current.nodeData + "\t");
            if (current.right != null) stack.add(current.right);
            if (current.left != null) stack.add(current.left);

        }
    }

    /**Left -> Root -> Right*/
    public void inOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (true) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            } else {
                if (stack.isEmpty()) break;
                node = stack.pop();
                System.out.print(node.nodeData + "\t");
                node = node.right;
            }
        }
    }

    /**Left -> Right -> Root*/
    public void postOrderTraversal(TreeNode root) {
        Stack<TreeNode> st1 = new Stack<>(), st2 = new Stack<>();
        if (root == null) return;
        st1.add(root);
        while(!st1.isEmpty()){
            TreeNode current = st1.pop();
            st2.add(current);
            if (current.left != null) st1.add(current.left);
            if (current.right != null) st1.add(current.right);
        }
        while (!st2.isEmpty())
            System.out.print(st2.pop().nodeData + "\t");
    }

    public void optimalPostOrderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> answer = new LinkedList<>();
        if (root == null) return;
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // This branching statement allows us to move as left as possible
            if (current != null) {
                stack.add(current);
                current = current.left;
            }
            // This branch deals with right movement and rechecking if the current node has any
            // left branches or not
            else {
                TreeNode temp = stack.peek().right;
                // A leaf node is encountered
                if (temp == null) {
                    temp = stack.pop();
                    answer.add(temp.nodeData);
                    // The while, if runs, signifies that we have reached the current rightmost sub-branch
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop(); answer.add(temp.nodeData);
                    }
                }
                else current = temp;
            }
        }
        System.out.println(answer);
    }
}
