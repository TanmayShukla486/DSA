package Trees;


public class TreeNode {
        public TreeNode left; // Reference to the left child node
        public TreeNode right; // Reference to the right child node
        public int nodeData; // Data stored in the node

        // Constructor for creating a node with only data
        public TreeNode(int data) {
            nodeData = data;
            left = null; // Initialize left child as null
            right = null; // Initialize right child as null
        }

        // Constructor for creating a node with data and a left child
        public TreeNode(int data, TreeNode left) {
            nodeData = data;
            this.left = left;
            // Since only left child is provided, right child is initialized as null
            right = null;
        }

        // Constructor for creating a node with data, left, and right children
        public TreeNode(int data, TreeNode left, TreeNode right) {
            nodeData = data;
            this.left = left;
            this.right = right;
        }

        // Override toString() method to return the node data as a string
        @Override
        public String toString(){
            return nodeData + "";
        }
    }

