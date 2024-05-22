package Trees;

import org.jetbrains.annotations.Nullable;

public class BSTCreation {

    private @Nullable BSTNode helper(int[] preOrder, int bound, int[] i) {
        if (i[0] >= preOrder.length || preOrder[i[0]] > bound) return null;
        BSTNode root = new BSTNode(preOrder[i[0]++]);
        root.left = helper(preOrder, root.nodeData, i);
        root.right = helper(preOrder, bound, i);
        return root;
    }
    public BSTNode createTree(int[] preOrder) {
        return helper(preOrder, Integer.MAX_VALUE, new int[]{0});
    }
}
