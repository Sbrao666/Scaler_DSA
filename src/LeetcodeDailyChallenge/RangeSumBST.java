package LeetcodeDailyChallenge;

public class RangeSumBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        int low = 7;
        int high = 15;
        System.out.println(rangeSumBST(treeNode, low, high));
    }

    private static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;

        if(root.val>=low && root.val<=high) sum+=root.val;

        return sum + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
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
