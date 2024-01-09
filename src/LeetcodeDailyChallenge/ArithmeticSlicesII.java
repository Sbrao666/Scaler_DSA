package LeetcodeDailyChallenge;

import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/arithmetic-slices-ii-subsequence/?envType=daily-question&envId=2024-01-07
public class ArithmeticSlicesII {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8, 10};
        System.out.println(numberOfArithmeticSlices(nums));
    }

    private static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;

        Map<Long, Integer>[] dp = new LinkedHashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new LinkedHashMap<Long, Integer>();
        }

        int i = 1;
        while (i < nums.length) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                int count = dp[j].getOrDefault(diff, 0);
                result = result + count;
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + count + 1);
            }
            i++;
        }

        return result;
    }
}
