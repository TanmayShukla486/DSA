package Trees;

public class BinarySearchTreeOperations {

    public BSTNode search(BSTNode root, int value) {
        if (root == null) return null;
        if (root.nodeData == value) return root;
        else if (root.nodeData < value) return search(root.right, value);
        else return search(root.left, value);
    }

    public int ceil(BSTNode root, int value) {
        int ceil = -1;
        if (root == null) return ceil;
        while (root != null) {
            if (root.nodeData == value) {
                ceil = value;
                return ceil;
            } else if (root.nodeData < value) {
                root = root.right;
            } else {
                ceil = root.nodeData;
                root = root.left;
            }
        }
        return ceil;
    }

    public int floor(BSTNode root, int value) {
        int floor = -1;
        if (root == null) return floor;
        while (root != null) {
            if (value == root.nodeData)
                return root.nodeData;
            else if (root.nodeData > value)
                root = root.left;
            else {
                floor = root.nodeData;
                root = root.right;
            }
        }
        return floor;
    }

    public BSTNode insertNode(BSTNode root, int value) {
        if (root == null) {
            root = new BSTNode(value);
            return root;
        }
        BSTNode temp = root;
        BSTNode prevNode = null;
        while (root != null) {
            if (root.nodeData < value) {
                prevNode = root;
                root = root.right;
            } else {
                prevNode = root;
                root = root.left;
            }
        }
        if (prevNode.nodeData < value) prevNode.right = new BSTNode(value);
        else prevNode.left = new BSTNode(value);
        return temp;
    }

    public void deleteNode (BSTNode root, int value) {
        BSTNode toBeDeleted = search(root, value);
        if (toBeDeleted == null) return;
        BSTNode leftBranch = toBeDeleted.left;
        BSTNode rightBranch = toBeDeleted.right;

        // finding the node prior to the one which is to be deleted
        BSTNode searchParty = root;
        while (searchParty != null) {
            if (searchParty.left == toBeDeleted || searchParty.right == toBeDeleted) break;
            else if (searchParty.nodeData < value) searchParty = searchParty.right;
            else searchParty = searchParty.left;
        }
        // If the left branch is null then it is easy as we can attach the right branch based
        // on its value in the tree and then we return
        if (leftBranch == null) {
            assert searchParty != null;
            if (value > searchParty.nodeData) searchParty.right = rightBranch;
            else searchParty.left = rightBranch;
            return;
        }
        // if the left branch is not null then we attach it as per its value in the tree
        // after attaching it we know that whatever value was stored in the left branch
        // will be smaller than the values in the right branch, so we move to the rightmost
        // branch in the attached node and then attach our right branch to it
        else  {
            assert searchParty != null;
            if (value > searchParty.nodeData) searchParty.right = leftBranch;
            else searchParty.left = leftBranch;
        }
        // only doing the traversal if the right branch is not null as there is no need for traversal
        // if the branch is null as it would be redundant attaching the right branch to the right-most
        // of the left branch
        if (rightBranch != null) {
            while (leftBranch.right != null) leftBranch = leftBranch.right;
            leftBranch.right = rightBranch;
        }
    }

    private boolean isBst(BSTNode root, int min, int max) {
        if (root == null) return true;
        if (root.nodeData > max || root.nodeData < min) return false;
        return isBst(root.left, min, root.nodeData) && isBst(root.right, root.nodeData, max);
    }

    public boolean checkBst(BSTNode root) {
        int minValue = Integer.MIN_VALUE;
        int maxValue = Integer.MAX_VALUE;
        return isBst(root, minValue, maxValue);
    }

    private boolean isBst(TreeNode root, int min, int max) {
        if (root == null) return true;
        if (root.nodeData > max || root.nodeData < min) return false;
        return isBst(root.left, min, root.nodeData) && isBst(root.right, root.nodeData, max);
    }

    public boolean checkBst(TreeNode root) {
        int minValue = Integer.MIN_VALUE;
        int maxValue = Integer.MAX_VALUE;
        return isBst(root, minValue, maxValue);
    }

    public BSTNode findLCA(BSTNode root, int val1, int val2) {
        int max = Math.max(val1, val2);
        int min = Math.min(val1, val2);
        if (root == null) return null;
        if (root.nodeData >= max) return findLCA(root.left, min, max);
        else if (root.nodeData > min) return root;
        else return findLCA(root.right, min, max);
    }
}
