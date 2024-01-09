package LeetcodeDailyChallenge;

import java.util.*;

public class ConvertArrayInto2DArrayWithConditions {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        List<List<Integer>> list = findMatrix(nums);
        System.out.println(list);
    }

    private static List<List<Integer>> findMatrix(int[] nums) {
        int freq[] = new int[nums.length + 1];

        ArrayList<List<Integer>> ans = new ArrayList<>();
        for (int c : nums) {
            if (freq[c] >= ans.size()) {
                ans.add(new ArrayList<>());
            }
            ans.get(freq[c]).add(c);
            freq[c]++;
        }

        return ans;
    }
}
