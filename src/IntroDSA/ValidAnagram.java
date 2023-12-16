package IntroDSA;

import java.util.HashMap;

//https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagramII(s, t));
    }

    private static boolean isAnagramII(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] charMap = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int indexForSChar = s.charAt(i) - 'a';
            int indexForTChar = t.charAt(i) - 'a';
            charMap[indexForSChar] += 1;
            charMap[indexForTChar] -= 1;
        }

        for (int i : charMap) if (i != 0) return false;

        return true;
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            if (!map.containsKey(currentChar)) return false;

            map.put(currentChar, map.get(currentChar) - 1);

            if (map.get(currentChar) == 0) map.remove(currentChar);

        }

        return map.isEmpty();

    }
}
