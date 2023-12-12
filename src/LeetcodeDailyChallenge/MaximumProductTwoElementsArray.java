package LeetcodeDailyChallenge;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

public class MaximumProductTwoElementsArray {
    public static void main(String[] args) {
        int[] A = {3, 4, 5, 2};
        System.out.println(maxProductI(A));
        System.out.println(maxProductII(A));
    }

    private static int maxProductII(int[] A) {
        int max = Integer.MIN_VALUE;
        int max2 = max;
        for (int i : A) {
            if (i > max) {
                max2 = max;
                max = i;
            }

            if (i > max2 && i < max) {
                max2 = max;
            }
        }
        return( max2 - 1) * (max - 1);
    }

    private static int maxProductI(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        return (A[n - 1] - 1) * (A[n - 2] - 1);
    }

}
