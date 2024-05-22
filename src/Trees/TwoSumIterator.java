package Trees;

import java.util.Stack;

public class TwoSumIterator {
    private final boolean isReverse;
    private final Stack<BSTNode> stack;

    public TwoSumIterator(BSTNode root, boolean isReverse) {
        this.isReverse = isReverse;
        stack = new Stack<>();
        fillValues(root, stack);
    }

    private void fillValues(BSTNode root, Stack<BSTNode> stack) {
        if (root == null) return;
        while (root != null) {
            stack.add(root);
            if (isReverse) root = root.right;
            else root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public BSTNode next() {
        BSTNode poppedValue = stack.pop();
        if (!isReverse) {
            fillValues(poppedValue.right, stack);
        } else {
            fillValues(poppedValue.left, stack);
        }
        return poppedValue;
    }
}
