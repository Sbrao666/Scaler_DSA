package LeetcodeDailyChallenge;

import java.util.Scanner;

public class LargestOddSubString {
    public static void main(String[] args) {
        String A = new Scanner(System.in).nextLine();
        System.out.println(largestOddNumber(A));
    }

    private static String largestOddNumber(String A) {
        int n = A.length();
        for (int i = n - 1; i >= 0; i--) {
            int digit = A.charAt(i) - '0';
            if (digit % 2 != 0) return A.substring(0, i + 1);
        }
        return "";
    }
}
