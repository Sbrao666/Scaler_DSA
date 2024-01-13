package IntroDSA;

//https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

public class MinimumNumberStepsMakeTwoStringsAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "mangaar";
        System.out.println(minSteps(s, t));
        System.out.println(minSteps_I(s, t));
    }

    private static int minSteps_I(String s, String t) {
        int[] freq = new int[26];
        byte[] sb = s.getBytes();
        byte[] tb = t.getBytes();

        for (byte b : sb) freq[b - 'a']++;

        int steps = 0;

        for (byte b : tb) {
            if (freq[b - 'a'] > 0) freq[b - 'a']--;
            else steps++;
        }

        return steps;
    }

    private static int minSteps(String s, String t) {
        int[] sFreq = new int[26];

        for (char ch : s.toCharArray()) sFreq[ch - 'a']++;

        int steps = 0;

        for (char ch : t.toCharArray()) {
            int index = ch - 'a';
            if (sFreq[index] > 0) {
                sFreq[index]--;
            } else {
                steps++;
            }
        }

        return steps;
    }
}
