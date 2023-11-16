package Arrays.CarryForward;


/*
You are given a string S, and you have to find all the amazing substrings of S.

An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is the number of Amazing Substrings in given the string.
Constraints

1 <= length(S) <= 1e6
S can have special characters
Example

Input
    ABEC

Output
    6

Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6.
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class AmazingSubArrays {
    public static void main(String[] args) {
        String A = "AEIOU";
        System.out.println(getNumberOfAmazingSubarray(A));
    }

    private static int getNumberOfAmazingSubarray(String A) {
        int n = A.length();
        int countOfAmazingSubArrays = 0;
        int mod = 10003;
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(A.charAt(i))) {
                countOfAmazingSubArrays += (n - i);
            }
        }
        return countOfAmazingSubArrays % mod;
    }
}
