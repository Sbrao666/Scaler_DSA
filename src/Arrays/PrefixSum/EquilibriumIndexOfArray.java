package Arrays.PrefixSum;

/*
Problem Description
You are given an array A of integers of size N.

Your task is to find the equilibrium index of the given array

The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.

If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.

Note:

Array indexing starts from 0.
If there is no equilibrium index then return -1.
If there are more than one equilibrium indexes then return the minimum index.


Problem Constraints
1 <= N <= 105
-105 <= A[i] <= 105
 */
public class EquilibriumIndexOfArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        System.out.println(equilibriumIndex(A));
    }

    private static int equilibriumIndex(int[] A) {
        prefixSum(A);
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = 0;
            if (i == 0) {
                left = 0;
            } else {
                left = A[i - 1];
                right = A[n - 1] - A[i];
            }
            if (left == right) return i;
        }
        return -1;
    }

    private static void prefixSum(int[] A) {
        for (int i = 1; i < A.length; i++) A[i] += A[i - 1];
    }
}
















