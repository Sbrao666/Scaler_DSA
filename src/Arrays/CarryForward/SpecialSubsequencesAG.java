package Arrays.CarryForward;

/*
Problem Description
You have given a string A having Uppercase English letters.

You have to find how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 109 + 7 as the answer can be very large.



Problem Constraints
1 <= length(A) <= 105



Input Format
First and only argument is a string A.



Output Format
Return an integer denoting the answer.



Example Input
Input 1:

 A = "ABCGAG"
Input 2:

 A = "GAB"


Example Output
Output 1:

 3
Output 2:

 0
 */

import java.util.Scanner;

public class SpecialSubsequencesAG {
    public static void main(String[] args) {
        String A = new Scanner(System.in).nextLine();
        System.out.println(countOfSpecialSubsequences_I(A));
        System.out.println(countOfSpecialSubsequences_II(A));
    }

    private static int countOfSpecialSubsequences_II(String A) {
        int n = A.length();
        int count = 0;
        int countOfG = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (A.charAt(i) == 'G') countOfG++;
            else if (A.charAt(i) == 'A') count += countOfG;
        }
        return count;
    }

    //    TC = O(N^2)
    private static int countOfSpecialSubsequences_I(String A) {
        int n = A.length();
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A.charAt(i) == 'A' && A.charAt(j) == 'G') count++;
            }
        }
        return count;
    }
}
