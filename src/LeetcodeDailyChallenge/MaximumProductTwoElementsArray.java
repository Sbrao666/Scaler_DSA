package LeetcodeDailyChallenge;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/

public class MaximumProductTwoElementsArray {
    public static void main(String[] args) {
        int[] A = {3, 4, 5, 2};
        System.out.println(maxProductO(A));
        System.out.println(maxProductI(A));
        System.out.println(maxProductII(A));
    }

    //    TC = N^2
    private static int maxProductO(int[] A) {
        int maxProduct = 0;
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = (A[i] - 1) * (A[j] - 1);
                maxProduct = Math.max(product, maxProduct);
            }
        }

        return maxProduct;
    }

    //    TC = N
    private static int maxProductII(int[] A) {
        int max = Integer.MIN_VALUE;
        int secondMax = max;
        for (int i : A) {
            if (i > max) {
                secondMax = max;
                max = i;
            }

            if (i > secondMax && i <= max) {
                secondMax = max;
            }
        }
        return (secondMax - 1) * (max - 1);
    }

    //    TC = NlogN
    private static int maxProductI(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        return (A[n - 1] - 1) * (A[n - 2] - 1);
    }

}
