package LeetcodeDailyChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LargestSubstringBetweenTwoEqualCharacters {
    public static void main(String[] args) {
        String s = "ojdncpvyneq";
        System.out.println(maxLengthBetweenEqualCharacters(s));
        System.out.println(maxLengthBetweenEqualCharactersII(s));
        System.out.println(maxLengthBetweenEqualCharactersIII(s));
    }

    private static int maxLengthBetweenEqualCharactersIII(String s) {
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j + i < n; j++) {
                if (s.charAt(i) == s.charAt(j)) return i - 1;
            }
        }
        return -1;
    }

    private static int maxLengthBetweenEqualCharactersII(String s) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) map.put(ch, new ArrayList<>());
            map.get(ch).add(i);
        }
        for (List<Integer> list : map.values()) {
            int minIndex = Integer.MAX_VALUE;
            int maxIndex = 0;
            if (list.size() == 1) continue;
            for (int item : list) {
                minIndex = Math.min(minIndex, item);
                maxIndex = Math.max(maxIndex, item);
            }
            maxLength = Math.max(maxLength, (maxIndex - minIndex) - 1);
        }

        return maxLength;
    }

    private static int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        int maxLength = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    maxLength = Math.max(maxLength, (j - i) - 1);
                }
            }
        }
        return maxLength;
    }
}
