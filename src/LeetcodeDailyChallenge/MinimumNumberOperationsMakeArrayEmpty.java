package LeetcodeDailyChallenge;

import java.util.HashMap;

public class MinimumNumberOperationsMakeArrayEmpty {
    public static void main(String[] args) {
        int[] nums = {14, 12, 14, 14, 12, 14, 14, 12, 12, 12, 12, 14, 14, 12, 14, 14, 14, 12, 12};
        System.out.println(minOperations(nums));
    }

    private static int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int ans = 0;
        for (int value : map.values()) {

            if (value == 1) return -1;

            ans += (int) Math.ceil((double) value / 3);

        }
        return ans;
    }
}

