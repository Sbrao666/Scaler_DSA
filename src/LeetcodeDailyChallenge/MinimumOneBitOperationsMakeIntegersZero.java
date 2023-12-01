package LeetcodeDailyChallenge;

import java.util.Scanner;

//https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/

public interface MinimumOneBitOperationsMakeIntegersZero {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(minimumOneBitOperations(n));
    }

    static int minimumOneBitOperations(int n) {
        int ans = n;
        ans ^= ans >> 16;
        ans ^= ans >> 8;
        ans ^= ans >> 4;
        ans ^= ans >> 2;
        ans ^= ans >> 1;
        return ans;
    }
}
