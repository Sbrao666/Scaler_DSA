package LeetcodeDailyChallenge;

//https://leetcode.com/problems/arithmetic-subarrays/?envType=daily-question&envId=2023-11-23

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubArrays {
    public static void main(String[] args) {
        int[] nums = {-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10}, l = {0, 1, 6, 4, 8, 7}, r = {4, 4, 9, 7, 9, 10};
        List<Boolean> checkArithmeticSubArraysI = checkArithmeticSubarrays_I(nums, l, r);
        System.out.println(checkArithmeticSubArraysI);
    }

    //    TC = O(NlogN * M) + O(N)
    private static List<Boolean> checkArithmeticSubarrays_I(int[] A, int[] left, int[] right) {
        int m = left.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] subArray = Arrays.copyOfRange(A, left[i], right[i] + 1);
            ans.add(isArithmeticSunArrayI(subArray));
        }
        return ans;
    }

    private static Boolean isArithmeticSunArrayI(int[] subArray) {
        Arrays.sort(subArray);
        int diff = subArray[1] - subArray[0];
        for (int i = 1; i < subArray.length; i++) {
            int currentDiff = subArray[i] - subArray[i - 1];
            if (currentDiff != diff) return false;
        }
        return true;
    }
}
