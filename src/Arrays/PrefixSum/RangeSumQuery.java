package Arrays.PrefixSum;

/*
Problem Description
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
 */

import java.lang.reflect.Array;
import java.util.Arrays;

public class RangeSumQuery {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[][] B = {{0, 3}, {1, 2}};
        System.out.println(Arrays.toString(rangeSum_I(A, B)));
        System.out.println(Arrays.toString(rangeSum_II(A, B)));
        System.out.println(Arrays.toString(rangeSum_III(A, B)));
    }

    //    Prefix sum : O(n) + O(q);  space : O(1)
    private static long[] rangeSum_III(int[] A, int[][] B) {
        int n = A.length;
        int q = B.length;
        long[] rangeSum = new long[q];
        for (int i = 1; i < n; i++) A[i] += A[i - 1];
        for (int i = 0; i < q; i++) {
            int start = B[i][0];
            int end = B[i][1];

            if (start == 0) {
                rangeSum[i] = A[end];
            } else {
                rangeSum[i] = A[end] - A[start-1];
            }

        }
        return rangeSum;
    }

    //    Prefix sum : O(n) + O(q);  space : O(n)
    private static long[] rangeSum_II(int[] A, int[][] B) {
        int n = A.length;
        int q = B.length;
        int[] prefixSum = new int[n];
        long[] rangeSum = new long[q];
        prefixSum[0] = A[0];
        for (int i = 1; i < n; i++) prefixSum[i] = prefixSum[i - 1] + A[i];
        for (int i = 0; i < q; i++) {
            int start = B[i][0];
            int end = B[i][1];
            if (start == 0) {
                rangeSum[i] = prefixSum[end];
            } else {
                rangeSum[i] = prefixSum[end] - prefixSum[start - 1];
            }
        }
        return rangeSum;
    }

    //    Approach 1 : BruteForce : O(nq)
    private static long[] rangeSum_I(int[] A, int[][] B) {
        long[] rangeSum = new long[B.length];
        for (int i = 0; i < B.length; i++) {
            for (int j = B[i][0]; j <= B[i][1]; j++) {
                rangeSum[i] += A[j];
            }
        }
        return rangeSum;
    }
}
