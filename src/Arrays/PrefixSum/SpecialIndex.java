package Arrays.PrefixSum;

/*
Problem Description
Given an array, arr[] of size N, the task is to find the count of array indices such that
removing an element from these indices makes the sum of even-indexed and odd-indexed array
elements equal.

Problem Constraints
1 <= N <= 105
-105 <= A[i] <= 105
Sum of all elements of A <= 109

 */
public class SpecialIndex {
    public static void main(String[] args) {
        int[] A = {1, 1, 1};
        System.out.println(countSpecialIndex(A));
    }

    private static int countSpecialIndex(int[] A) {
        int n = A.length;
        int[] evenIndexedPrefixSum = getPrefixSum(A, n, true);
        int[] oddIndexedPrefixSum = getPrefixSum(A, n, false);
        int count = 0;
        for (int i = 0; i < n; i++) {
            int evenSum = 0;
            int oddSum = -1;
            if (i == 0) {
                evenSum = evenIndexedPrefixSum[n - 1] - evenIndexedPrefixSum[i];
                oddSum = oddIndexedPrefixSum[n - 1] - oddIndexedPrefixSum[i];
            } else {
                evenSum = evenIndexedPrefixSum[i - 1] + oddIndexedPrefixSum[n - 1] - oddIndexedPrefixSum[i];
                oddSum = oddIndexedPrefixSum[i - 1] + evenIndexedPrefixSum[n - 1] - evenIndexedPrefixSum[i];
            }
            if (oddSum == evenSum) count++;
        }
        return count;
    }

    private static int[] getPrefixSum(int[] A, int n, boolean isEvenIndexed) {
        int[] prefixSum = new int[n];
        if (isEvenIndexed) {
            prefixSum[0] = A[0];
            for (int i = 1; i < n; i++) {
                if (i % 2 == 0) prefixSum[i] = prefixSum[i - 1] + A[i];
                else prefixSum[i] = prefixSum[i - 1];
            }
        } else {
            prefixSum[0] = 0;
            for (int i = 1; i < n; i++) {
                if (i % 2 != 0) prefixSum[i] = prefixSum[i - 1] + A[i];
                else prefixSum[i] = prefixSum[i - 1];
            }
        }
        return prefixSum;
    }
}
