package LeetcodeDailyChallenge;

import java.util.HashMap;

public class CountNicePairsArray {
    public static void main(String[] args) {
        int[] A = {13, 10, 35, 24, 76};
        System.out.println(countNicePairs_I(A));
        System.out.println(countNicePairs_II(A));
    }

    private static int countNicePairs_II(int[] A) {
        int n = A.length;
        if (n <= 1) return 0;
        int mod = (int) 1e9 + 7;
        HashMap<Integer, Long> map = new HashMap<>();
        long count = 0;

        for (int a : A) {
            int reversedNumber = reverseNumber(a);
            int diff =reversedNumber - a;
            map.put(diff, map.getOrDefault(diff, (long) 0) + 1);
        }


        for (HashMap.Entry<Integer, Long> entry : map.entrySet()) {
            count += getTotalPairPossible(entry.getValue() - 1);
        }


        return (int) (count % mod);
    }

    private static long getTotalPairPossible(long A) {
        return A * (A + 1) / 2;
    }


    //    O(N^2)
    private static int countNicePairs_I(int[] A) {
        int mod = (int) 1e9 + 7;
        long count = 0;
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isNicePair(A[i], A[j])) count++;
            }
        }
        return (int) (count % mod);
    }

    private static boolean isNicePair(int A, int B) {
        return A + reverseNumber(B) == reverseNumber(A) + B;
    }

    private static int reverseNumber(int A) {
        int reversedNumber = 0;
        while (A > 0) {
            reversedNumber = (reversedNumber * 10) + A % 10;
            A /= 10;
        }
        return reversedNumber;
    }
}
