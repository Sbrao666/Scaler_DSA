package LeetcodeDailyChallenge;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-product-difference-between-two-pairs/
public class MaximumProductDifferenceBetweenTwoPairs {
    public static void main(String[] args) {
        int[] A = {4, 2, 5, 9, 7, 4, 8};
        System.out.println(maxProductDifferenceII(A));
        System.out.println(maxProductDifferenceI(A));
    }

    //    TC = O(NLogN),  SC = O(N)
    private static int maxProductDifferenceI(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        return (A[n - 1] * A[n - 2]) - (A[1] * A[0]);
    }

    //    TC = O(N)
    private static int maxProductDifferenceII(int[] A) {
        int[] maxSecondMax = getMaxAndSecondMax(A);
        int[] minSecondMin = getMinSecondMin(A);

        return (maxSecondMax[1] * maxSecondMax[0]) - (minSecondMin[1] * minSecondMin[0]);
    }

    private static int[] getMinSecondMin(int[] A) {
        int[] minSecondMin = new int[2];
        minSecondMin[0] = minSecondMin[1] = Integer.MAX_VALUE;
        for (int i : A) {
            if (i < minSecondMin[0]) {
                minSecondMin[1] = minSecondMin[0];
                minSecondMin[0] = i;
            } else {
                minSecondMin[1] = Math.min(minSecondMin[1], i);
            }
        }
        return minSecondMin;
    }

    private static int[] getMaxAndSecondMax(int[] A) {
        int[] maxSecondMax = new int[2];
        for (int i : A) {
            if (i > maxSecondMax[0]) {
                maxSecondMax[1] = maxSecondMax[0];
                maxSecondMax[0] = i;
            } else {
                maxSecondMax[1] = Math.max(maxSecondMax[1], i);
            }
        }
        return maxSecondMax;
    }
}
