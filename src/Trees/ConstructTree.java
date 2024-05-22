package Trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructTree {

    private TreeNode createTreeFromInAndPre(
            int[] preOrder,
            int preStart,
            int preEnd,
            int[] inOrder,
            int inStart,
            int inEnd,
            Map<Integer, Integer> inValues
    ) {
        if (preStart > preEnd || inStart > inEnd) return null;
        int rootValue = preOrder[preStart];
        int inValue = inValues.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        int numsOnLeft = inValue - inStart;

        root.left = createTreeFromInAndPre(
                preOrder,
                preStart + 1,
                preStart + numsOnLeft,
                inOrder,
                inStart,
                inValue,
                inValues
                );
        root.right = createTreeFromInAndPre(
                preOrder,
                preStart + numsOnLeft + 1,
                preEnd,
                inOrder,
                inValue + 1,
                inEnd,
                inValues
        );
        return root;
    }

    private TreeNode createTreeFromPostAndIn(
            int[] postOrder,
            int postStart,
            int postEnd,
            int[] inOrder,
            int inStart,
            int inEnd,
            Map<Integer, Integer> inValues
    ) {
        if (postStart > postEnd || inStart > inEnd) return null;
        int rootValue = postOrder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        int inPosition = inValues.get(rootValue);
        int numsOnLeft = inPosition - inStart;
        root.left = createTreeFromPostAndIn(
                postOrder,
                postStart,
                postStart + numsOnLeft - 1,
                inOrder,
                inStart,
                inPosition - 1,
                inValues
        );
        root.right = createTreeFromPostAndIn(
                postOrder,
                postStart + numsOnLeft,
                postEnd - 1,
                inOrder,
                inPosition + 1,
                inEnd,
                inValues
        );
        return root;
    }

    private Map<Integer, Integer> createInOrderMap(int[] inOrder) {
        Map<Integer, Integer> inValues = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++)
            inValues.put(inOrder[i], i);
        return inValues;
    }

    public TreeNode fromInorderPreorder(int[] preOrder, int[] inOrder) {
        Map<Integer, Integer> inValues = createInOrderMap(inOrder);
        int n = preOrder.length;
        TreeNode root = createTreeFromInAndPre(
                preOrder,
                0,
                n - 1,
                inOrder,
                0,
                n - 1,
                inValues
        );
        new LevelOrderTraversal().traversal(root);
        System.out.println();
        return root;
    }

    public TreeNode fromInorderPostorder(int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> inValues = createInOrderMap(inOrder);
        int n = postOrder.length;
        TreeNode root = createTreeFromPostAndIn(
                postOrder,
                0,
                n - 1,
                inOrder,
                0,
                n - 1,
                inValues
        );
        new LevelOrderTraversal().traversal(root);
        System.out.println();
        return root;
    }
}
