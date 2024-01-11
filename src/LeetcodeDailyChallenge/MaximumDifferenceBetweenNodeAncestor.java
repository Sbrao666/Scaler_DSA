package LeetcodeDailyChallenge;

//https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

public class MaximumDifferenceBetweenNodeAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(0);
        root.right.right.left = new TreeNode(3);

        System.out.println(maxAncestorDiff(root));
    }

    private static int maxAncestorDiff(TreeNode root) {
        return postOrder(root, root.val, root.val);
    }

    private static int postOrder(TreeNode root, int minValue, int maxValue) {
        if (root == null) return maxValue - minValue;

        maxValue = Math.max(maxValue, root.val);
        minValue = Math.min(minValue, root.val);


        if (root.left == null && root.right == null) return maxValue - minValue;

        return Math.max(postOrder(root.left, minValue, maxValue), postOrder(root.right, minValue, maxValue));
    }

    public static class TreeNode {
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
}
