package Trees;

public class BSTNode{
    public int nodeData;
    public BSTNode left, right;

    public BSTNode(int nodeData) {
        this.nodeData = nodeData;
        left = null;
        right = null;
    }

    public BSTNode(int nodeData, BSTNode left, BSTNode right) {
        this.nodeData = nodeData;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString(){
        return nodeData + "";
    }
}
