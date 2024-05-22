package Trees;

import java.util.Stack;

public class BSTIterator {
    private final Stack<BSTNode> stack;
    public BSTIterator(BSTNode root) {
        stack = new Stack<>();
        fillLeft(root, stack);
    }

    private void fillLeft(BSTNode root, Stack<BSTNode> stack) {
        while (root != null) {
            stack.add(root); root = root.left;
        }
    }

    private void fillRight(BSTNode root, Stack<BSTNode> stack) {
        if (root.right == null) return;
        root = root.right;
        fillLeft(root, stack);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public BSTNode next() {
        if (!hasNext()) return null;
        BSTNode toBeReturned = stack.pop();
        fillRight(toBeReturned, stack);
        return toBeReturned;
    }
}
