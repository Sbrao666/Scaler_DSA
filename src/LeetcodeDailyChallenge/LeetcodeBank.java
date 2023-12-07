package LeetcodeDailyChallenge;

import java.util.Arrays;
import java.util.Scanner;

public class LeetcodeBank {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(totalMoney(n));
    }

    private static int totalMoney(int n) {
        int[] prefix = getWeeklyPrefix();
        System.out.println(Arrays.toString(prefix));
        int total = 0;
        int week = 0;
        while (n > 0) {
            if (n <= 7) {
                total += (week * 7) + prefix[n];
                n = n - 7;
            } else {
                total += (week * 7) + prefix[7];
                n = n - 7;
            }
            week++;
        }
        return total;
    }

    private static int[] getWeeklyPrefix() {
        int[] prefix = new int[8];
        int p = 1;
        for (int i = 1; i < 8; i++) {
            prefix[i] = prefix[i - 1] + p++;
        }
        return prefix;
    }
}
