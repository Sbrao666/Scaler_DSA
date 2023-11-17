package LeetcodeDailyChallenge;

//https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/

import java.util.Arrays;

public class MinimizeMaximumPairSumArray {
    public static void main(String[] args) {
        int[] A = {4, 1, 5, 1, 2, 5, 1, 5, 5, 4};
        System.out.println(minPairSum_I(A));
        System.out.println(minPairSum_II(A));
    }

    //   SC =  TC = O(N)
    private static int minPairSum_II(int[] A) {
        int min = A[0];
        int max = A[0];
        int[] hash = new int[100005];
        for (int a : A) {
            hash[a]++;
            min = Math.min(a, min);
            max = Math.max(a, max);
        }
        int low = min;
        int high = max;
        max = Integer.MIN_VALUE;

        while (low <= high) {
            if (hash[low] == 0) low++;
            else if (hash[high] == 0) high--;
            else {
                max = Math.max(max, low + high);
                hash[low]--;
                hash[high]--;
            }
        }

        return max;
    }

    //    TC = O(NLogN)
    private static int minPairSum_I(int[] A) {
        Arrays.sort(A);
        int minPairSum = A[0] + A[A.length - 1];
        int i = 1;
        int j = A.length - 2;
        while (i < j) {
            minPairSum = Math.max(minPairSum, A[i] + A[j]);
            i++;
            j--;
        }
        return minPairSum;
    }
}
