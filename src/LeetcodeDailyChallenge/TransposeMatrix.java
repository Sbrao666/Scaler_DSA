package LeetcodeDailyChallenge;

import java.util.Arrays;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] transpose = transpose(A);
        for (int[] i : transpose) System.out.println(Arrays.toString(i));
    }

    private static int[][] transpose(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] transpose = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transpose[j][i] = A[i][j];
            }
        }
        return transpose;
    }
}
