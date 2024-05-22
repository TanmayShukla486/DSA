package Trees;

public class SuccessorAndPredecessor {
    public BSTNode successor(BSTNode root, int target) {
        BSTNode succ = null;
        while (root != null) {
            if (root.nodeData >= target) {
                root = root.right;
            } else {
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }

    public BSTNode predecessor(BSTNode root, int target) {
        BSTNode pre = null;
        while (root != null) {
            if (root.nodeData >= target) {
                root = root.left;
            } else {
                pre = root;
                root = root.right;
            }
        }
        return pre;
    }
}
