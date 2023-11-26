package LeetcodeDailyChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestSubmatrixWithRearrangements {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1}, {1, 1, 1}, {1, 0, 1}};
        System.out.println(largestSubmatrixI(matrix));
        System.out.println(largestSubmatrixII(matrix));
    }

    private static int largestSubmatrixII(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Pair<Integer, Integer>> prevHeights = new ArrayList();
        int ans = 0;

        for (int row = 0; row < m; row++) {
            List<Pair<Integer, Integer>> heights = new ArrayList<>();
            boolean[] seen = new boolean[n];

            for (Pair<Integer, Integer> pair : prevHeights) {
                int height = pair.getKey();
                int col = pair.getValue();
                if (matrix[row][col] == 1) {
                    heights.add(new Pair(height + 1, col));
                    seen[col] = true;
                }
            }

            for (int col = 0; col < n; col++) {
                if (seen[col] == false && matrix[row][col] == 1) {
                    heights.add(new Pair(1, col));
                }
            }

            for (int i = 0; i < heights.size(); i++) {
                ans = Math.max(ans, heights.get(i).getKey() * (i + 1));
            }

            prevHeights = heights;
        }

        return ans;
    }

    private static int largestSubmatrixI(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prevRow = new int[n];
        int ans = 0;

        for (int row = 0; row < m; row++) {

            int[] currRow = matrix[row].clone();

            for (int col = 0; col < n; col++) {
                if (currRow[col] != 0) {
                    currRow[col] += prevRow[col];
                }
            }

            int[] sortedRow = currRow.clone();
            Arrays.sort(sortedRow);

            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, sortedRow[i] * (n - i));
            }

            prevRow = currRow;
        }

        return ans;
    }

    public static class Pair<V, T> {
        private V key;
        private V value;

        public Pair(V key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
