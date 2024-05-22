package Trees;

public class MainClass {

    static TreeNode root = new TreeNode(1,
            new TreeNode(2,new TreeNode(4),new TreeNode(5, new TreeNode(6))),
            new TreeNode(3, new TreeNode(7), new TreeNode(8,
                    new TreeNode(9), new TreeNode(10))));

    static TreeNode balancedRoot = new TreeNode(
            3, new TreeNode(4), new TreeNode(20,
            new TreeNode(15), new TreeNode(7))
    );

    static TreeNode symmetricRoot = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(3)),
            new TreeNode(2, new TreeNode(3), new TreeNode(4)));

    static TreeNode childSumTree = new TreeNode(40,
            new TreeNode(10,
                    new TreeNode(2), new TreeNode(5)),
            new TreeNode(20,
                    new TreeNode(30), new TreeNode(40)));

    static BSTNode bstTree = null;

    public static void main(String[] args){
        RecursiveTraversal obj1 = new RecursiveTraversal();
//        IterativeTraversal iterative = new IterativeTraversal();
        System.out.println("Recursive");
        System.out.print("InOrder:\t");obj1.inOrderTraversal(root);
        System.out.println();
//        System.out.println();
//        System.out.print("PreOrder:\t");obj.preOrderTraversal(root);
//        System.out.println();
//        System.out.print("PostOrder:\t");obj.postOrderTraversal(root);
//        System.out.println();
//        System.out.println("Iterative-----------------------------------------");
//        System.out.print("LevelOrder:\t");new LevelOrderTraversal().traversal(root);
//        System.out.println();
//        System.out.print("InOrder:\t");iterative.inOrderTraversal(root);
//        System.out.println();
//        System.out.print("PreOrder:\t");iterative.preOrderTraversal(root);
//        System.out.println();
//        System.out.print("PostOrder:\t"); iterative.optimalPostOrderTraversal(root);
//        new UniversalTraversal().universalTraversal(root);
//        TreeProperties find = new TreeProperties();
//        System.out.println(find.maxHeight(root));
//        System.out.println(find.checkBalanced(root));
//        System.out.println(find.checkBalanced(balancedRoot));
//        System.out.println(find.diameterOfTree(root));
//        System.out.println(find.areIdentical(root, balancedRoot));
//        // Zig Zag Traversal
//        System.out.print("Zig Zag Traversal:\t");
//        new UniversalTraversal().zigZagTraversal(root);
//        // Boundary Traversal
//        System.out.print("Boundary Traversal\t");
//        new BoundaryTraversal().boundaryTraversal(root);
//        // Vertical Order Traversal
//        System.out.print("Vertical Order Traversal:\t");
//        new VerticalOrderTraversal().traversal(root);
//        // Top View
//        System.out.print("Top View Traversal:\t");
//        new TopViewTraversal().traversal(root);
//        // Bottom View
//        System.out.print("Bottom View Traversal:\t");
//        new BottomViewTraversal().traversal(root);
//        // Left View
//        System.out.print("Left View Traversal:\t");
//        new LeftRightViewTraversal().traversal(root, 'l');
//        // Right View
//        System.out.print("Right View Traversal:\t");
//        new LeftRightViewTraversal().traversal(root, 'r');
//        System.out.println(new SymmetricTree().checkSymmetry(symmetricRoot));
//        System.out.println(new SymmetricTree().checkSymmetry(root));
//        new PathToNode().findPath(root, 6);
//        new WidthOfTree().findWidth(root);
//        new CommonAncestor().findCommonAncestor(root, 2, 10);
//        new ChildSum().changeTree(childSumTree);
//        new LevelOrderTraversal().traversal(childSumTree); System.out.println();
//        new DistanceOfK().findNodes(root, 5, 2);
//        System.out.println(new BurningTrees().burnItAll(root, 5));
        int[] preOrder = {7,3,2,1,6,5,4,10,9,8};
        int[] inOrder = {9,3,15,20,7};
        int[] postOrder = {9,15,7,20,3};
//        TreeNode constructedTree = new ConstructTree().fromInorderPreorder(preOrder, inOrder);
//        TreeNode constructedTree2 = new ConstructTree().fromInorderPostorder(inOrder, postOrder);
//
//        String serializedTree = new SerializeDeserialize().serialize(constructedTree2);
//        System.out.println("Serialized Tree: " + serializedTree);
//        new LevelOrderTraversal().traversal(
//                new SerializeDeserialize().deserialize(serializedTree)
//        );
        int[] values = {9,15,7,20,5,8,12,13,16};
        BinarySearchTreeOperations obj = new BinarySearchTreeOperations();
        for (int value: values) {
            bstTree = obj.insertNode(bstTree, value);
        }
        new RecursiveTraversal().preOrderTraversal(bstTree);
        obj.deleteNode(bstTree, 12);
        System.out.println();
        new RecursiveTraversal().preOrderTraversal(bstTree);
        System.out.println();
        bstTree = obj.insertNode(bstTree, 12);
//        new RecursiveTraversal().preOrderTraversal(bstTree);
        System.out.println(obj.checkBst(bstTree));
        System.out.println(obj.checkBst(root));
        System.out.println(obj.findLCA(bstTree, 13, 16));
        new MorrisTraversal().traversal(root);
//        new FlattenTree().flatten(constructedTree2);
//        obj1.inOrderTraversal(constructedTree2); System.out.println();
        BSTNode tree = new BSTCreation().createTree(preOrder);
        new LevelOrderTraversal().traversal(tree); System.out.println();
        BSTIterator iterator = new BSTIterator(tree);
        String[] commands = "next next hasNext next hasNext next hasNext next hasNext".split(" ");
        for (String command: commands) {
            switch (command) {
                case "next" -> System.out.println("Command: next -> " + iterator.next());
                case "hasNext" -> System.out.println("Command: hasNext ->" + iterator.hasNext());
                default -> System.out.println("Invalid Command");
            }
        }
        TwoSumIterator left = new TwoSumIterator(tree, false);
        TwoSumIterator right = new TwoSumIterator(tree, true);
        int target = 100;
        boolean found = false;
        int i = left.next().nodeData;
        int j = right.next().nodeData;
        while (i < j) {
            if (i + j == target) {
                found = true; break;
            } else if (i + j < target) {
                i = left.next().nodeData;
            } else j = right.next().nodeData;
        }
        if (found) System.out.println("Found = " + i + "," + j);
        else System.out.println("Not Found");
    }
}
