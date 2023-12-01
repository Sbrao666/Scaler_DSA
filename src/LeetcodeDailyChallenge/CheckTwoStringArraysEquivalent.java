package LeetcodeDailyChallenge;


//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

public class CheckTwoStringArraysEquivalent {
    public static void main(String[] args) {
        String[] A = {"ab", "c"};
        String[] B = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(A, B));
        System.out.println(arrayStringsAreEqualII(A, B));
        System.out.println(arrayStringsAreEqualIII(A, B));
    }

    /*
    All three solution contains same time complexity i,e TC=O(n*k) where n = array length and k is string length inside the array.
    only solution 3 having constant space complexity.
     */
    private static boolean arrayStringsAreEqualIII(String[] A, String[] B) {
        int word1Pointer = 0, word2Pointer = 0;
        int string1Pointer = 0, string2Pointer = 0;

        while (word1Pointer < A.length && word2Pointer < B.length) {
            if (A[word1Pointer].charAt(string1Pointer++) !=
                    B[word2Pointer].charAt(string2Pointer++)) {
                return false;
            }
            if (string1Pointer == A[word1Pointer].length()) {
                word1Pointer++;
                string1Pointer = 0;
            }
            if (string2Pointer == B[word2Pointer].length()) {
                word2Pointer++;
                string2Pointer = 0;
            }
        }
        return word1Pointer == A.length && word2Pointer == B.length;
    }

    private static boolean arrayStringsAreEqualII(String[] A, String[] B) {
        StringBuilder stringA = new StringBuilder();

        for (String a : A) stringA.append(a);
        for (String b : B) stringA.append(b);

        int mid = stringA.length() / 2;
        int start = 0;
        while (mid < stringA.length()) {
            if (stringA.charAt(start) != stringA.charAt(mid)) return false;
            mid++;
            start++;
        }

        return true;
    }

    private static boolean arrayStringsAreEqual(String[] A, String[] B) {
        StringBuffer stringA = new StringBuffer();
        StringBuffer stringB = new StringBuffer();

        for (String a : A) stringA.append(a);
        for (String b : B) stringB.append(b);

        return stringA.compareTo(stringB) == 0;
    }
}
