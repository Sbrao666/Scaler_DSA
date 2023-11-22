package LeetcodeDailyChallenge;

import java.util.*;

public class DiagonalTraverseII {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<List<Integer>> A = new ArrayList<>();
        for (int[] n1 : nums) {
            List<Integer> a = new ArrayList<>();
            for (int n2 : n1) {
                a.add(n2);
            }
            A.add(a);
        }

        int[] result = findDiagonalOrder(A);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<Pair> queue = new LinkedList();
        queue.offer(new Pair(0, 0));
        List<Integer> ans = new ArrayList();

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int row = p.first;
            int col = p.second;
            ans.add(nums.get(row).get(col));

            if (col == 0 && row + 1 < nums.size()) {
                queue.offer(new Pair(row + 1, col));
            }

            if (col + 1 < nums.get(row).size()) {
                queue.offer(new Pair(row, col + 1));
            }
        }

        int[] result = new int[ans.size()];
        int i = 0;
        for (int num : ans) {
            result[i] = num;
            i++;
        }

        return result;
    }

    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
