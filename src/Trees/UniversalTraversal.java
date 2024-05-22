package Trees;

import java.util.*;

public class UniversalTraversal {
    public String traversalType(int count) {
        return switch(count) {
            case 0 -> "PreOrder:\t";
            case 1 -> "InOrder:\t";
            case 2 -> "PostOrder\t";
            default -> "";
        };
    }

    public void zigZagTraversal(TreeNode root) {
        if (root == null) return;
        boolean leftToRight = true;
        Queue<TreeNode> cache = new LinkedList<>();
        cache.add(root);
        while (!cache.isEmpty()) {
            int size = cache.size();
            TreeNode[] currentLevel = new TreeNode[size];
            for (int i = 0; i < size; i++) {
                TreeNode current = cache.poll();
                int index = (leftToRight) ? i : (size - i - 1);
                currentLevel[index] = current;
                assert current != null;
                if (current.left != null) cache.add(current.left);
                if (current.right != null) cache.add(current.right);
            }
            for (TreeNode node: currentLevel) System.out.print(node + "\t");
            System.out.println(); leftToRight = !leftToRight;
        }
    }

    public void universalTraversal(TreeNode root) {
        // 0th index -> PreOrder, 1st index -> InOrder, 2nd index -> PostOrder
        List<List<Integer>> answer = new ArrayList<>();
        // Adding three lists to store answers
        answer.add(new ArrayList<>());answer.add(new ArrayList<>());answer.add(new ArrayList<>());
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> number = new Stack<>();
        nodes.add(root); number.add(1);
        while(!number.isEmpty()) {
            int currentNumber = number.pop();
            TreeNode currentNode = nodes.pop();
            if (currentNumber == 1) {
                answer.get(0).add(currentNode.nodeData);
                number.add(currentNumber + 1); nodes.add(currentNode);
                if (currentNode.left != null) {
                    nodes.add(currentNode.left); number.add(1);
                }
            } else if (currentNumber == 2) {
                answer.get(1).add(currentNode.nodeData);
                number.add(currentNumber + 1); nodes.add(currentNode);
                if (currentNode.right != null) {
                    nodes.add(currentNode.right); number.add(1);
                }
            } else if (currentNumber == 3) {
                answer.get(2).add(currentNode.nodeData);
            }
        }
        int count = 0;
        System.out.println("Universal Traversal Program");
        for(List<Integer> traversal: answer) {
            System.out.println(traversalType(count++) + traversal);
        }
    }
}
