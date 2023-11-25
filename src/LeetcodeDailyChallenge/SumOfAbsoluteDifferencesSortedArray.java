package LeetcodeDailyChallenge;

import java.util.Arrays;

//https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/?envType=daily-question&envId=2023-11-25


public interface SumOfAbsoluteDifferencesSortedArray {
    public static void main(String[] args) {
        int[] A = {1, 4, 6, 8, 10};
        System.out.println(Arrays.toString(getSumAbsoluteDifferencesI(A)));
        System.out.println(Arrays.toString(getSumAbsoluteDifferencesII(A)));
    }

    /*
        Both are the prefixSum approaches
        for first  : TC = O(N) and SC= O(N);
        for second : TC = O(N) and SC is constant;

        In the second solution we are calculating prefix sum on the fly,
        hence we don't required any additional space to store it.
     */

    static int[] getSumAbsoluteDifferencesII(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int totalSum = 0;
        for (int a : A) totalSum += a;

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - A[i];

            int leftContribution = i;
            int rightContribution = n - i - 1;

            int totalLeft = A[i] * leftContribution - leftSum;
            int totalRight = rightSum - rightContribution * A[i];

            result[i] = totalLeft + totalRight;
            leftSum += A[i];
        }

        return result;
    }

    static int[] getSumAbsoluteDifferencesI(int[] A) {
        int n = A.length;
        int[] result = new int[n];

        int[] prefixSum = getPrefixSum(A);

        for (int i = 0; i < n; i++) {
            int leftPrefix = prefixSum[i] - A[i];
            int rightPrefix = prefixSum[n - 1] - prefixSum[i];

            int currentElementContributionLeftSide = i;
            int currentElementContributionRightSide = n - 1 - i;

            int totalLeft = (currentElementContributionLeftSide * A[i]) - leftPrefix;
            int totalRight = rightPrefix - (currentElementContributionRightSide * A[i]);

            result[i] = totalLeft + totalRight;

        }
        return result;
    }

    static int[] getPrefixSum(int[] A) {
        int n = A.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }
        return prefixSum;
    }

}
