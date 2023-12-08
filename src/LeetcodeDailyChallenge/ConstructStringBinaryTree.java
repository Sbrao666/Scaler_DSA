package LeetcodeDailyChallenge;

public class ConstructStringBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);

        System.out.println(tree2str(root));
    }

    private static String tree2str(TreeNode root) {
        StringBuilder treeStr = new StringBuilder();
        inorder(root, treeStr);
        return treeStr.toString();
    }

    private static void inorder(TreeNode root, StringBuilder treeStr) {
        if (root == null) return;
        treeStr.append(root.val);
        if (root.left == null && root.right == null) return;

        treeStr.append("(");
        inorder(root.left, treeStr);
        treeStr.append(")");

        if (root.right != null) {
            treeStr.append("(");
            inorder(root.right, treeStr);
            treeStr.append(")");
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
