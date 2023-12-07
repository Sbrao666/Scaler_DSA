package LeetcodeDailyChallenge;

//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

import java.util.HashSet;

public class FindWordsThatCanBeFormedCharacters {
    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        System.out.println(countCharacters(words, chars));
    }

    private static int countCharacters(String[] words, String chars) {
        HashSet<String> set = new HashSet<>();
        for (String word : words) set.add(word);
        return recur(set, 0, chars, new StringBuffer());
    }

    private static int recur(HashSet<String> set, int i, String chars, StringBuffer stringBuffer) {
        if (i == chars.length()) return 0;

        if (set.contains(stringBuffer.toString())) return 1;



        return recur(set, i + 1, String.valueOf(stringBuffer.append(chars.charAt(i))), stringBuffer) + recur(set, i+1, chars, stringBuffer);
    }

}
