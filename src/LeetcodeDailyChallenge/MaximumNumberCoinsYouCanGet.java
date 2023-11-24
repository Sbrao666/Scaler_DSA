package LeetcodeDailyChallenge;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
public class MaximumNumberCoinsYouCanGet {
    public static void main(String[] args) {
        int[] A = {2, 4, 1, 2, 7, 8};
        System.out.println(maxCoinsI(A));
        System.out.println(maxCoinsII(A));
    }


/*
Both are the same time complexity solution and same approach together.
One contain the best way of coding that is the difference only.
 */

    private static int maxCoinsII(int[] A) {
        Arrays.sort(A);
        int total = 0;
        int n = A.length;
        for (int i = n / 3; i < n; i += 2) {
            total += A[i];
        }
        return total;
    }

    private static int maxCoinsI(int[] A) {
        Arrays.sort(A);
        int total = 0;
        int n = A.length;
        int totalTriplets = n / 3;
        int start = n - 2;
        while (totalTriplets > 0) {
            total += A[start];
            start = start - 2;
            totalTriplets--;
        }
        return total;
    }
}
