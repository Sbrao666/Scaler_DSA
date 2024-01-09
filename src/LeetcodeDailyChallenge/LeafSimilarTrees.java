package LeetcodeDailyChallenge;


//https://leetcode.com/problems/leaf-similar-trees/

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left = new TreeNode(2);

        System.out.println(leafSimilar(root1, root2));
    }

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> inorder1 = inorder(root1);
        List<Integer> inorder2 = inorder(root2);

        return inorder1.equals(inorder2);
    }

    private static List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return;
        }

        inorder(root.left, list);
        inorder(root.right, list);
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
