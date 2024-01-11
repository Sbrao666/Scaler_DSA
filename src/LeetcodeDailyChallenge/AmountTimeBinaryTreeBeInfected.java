package LeetcodeDailyChallenge;

import java.util.*;

public class AmountTimeBinaryTreeBeInfected {
    public static HashSet<Integer> visited;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(10);
//        root.right.right = new TreeNode(6);
        int start = 1;
        System.out.println(amountOfTime(root, start));
    }

    private static int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, List<Integer>> graph = fillTheGraph(root);
        visited = new HashSet<>();
        return bfs(graph, start);
    }

    private static int bfs(HashMap<Integer, List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int minute = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while (levelSize > 0) {
                int current = queue.poll();
                for (int num : graph.get(current)) {
                    if (!visited.contains(num)) {
                        visited.add(num);
                        queue.add(num);
                    }
                }
                levelSize--;
            }
            minute++;
        }
        return minute - 1;
    }

    private static HashMap<Integer, List<Integer>> fillTheGraph(TreeNode root) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        inorder(root, graph);
        return graph;
    }

    private static void inorder(TreeNode root, HashMap<Integer, List<Integer>> graph) {
        if (root == null) return;

        if (!graph.containsKey(root.val)) graph.put(root.val, new ArrayList<>());

        if (root.left != null) {
            if (!graph.containsKey(root.left.val)) graph.put(root.left.val, new ArrayList<>());
            graph.get(root.left.val).add(root.val);
            graph.get(root.val).add(root.left.val);
        }

        if (root.right != null) {
            if (!graph.containsKey(root.right.val)) graph.put(root.right.val, new ArrayList<>());
            graph.get(root.right.val).add(root.val);
            graph.get(root.val).add(root.right.val);
        }

        inorder(root.left, graph);
        inorder(root.right, graph);
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
