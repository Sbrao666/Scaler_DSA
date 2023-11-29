package LeetcodeDailyChallenge;

import java.util.Arrays;
import java.util.Scanner;

public class KnightDialer {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(knightDialer(n));
    }

    private static int knightDialer(int n) {
        int mod = (int) 1e9 + 7;
        long totalDial = 0;
        char[][] dialPad = fillDialPad();



        int result = (int) (totalDial % mod);
        return result < 0 ? result + mod : result;
    }

    private static char[][] fillDialPad() {
        char[][] dialPad = new char[4][3];
        char prev = '1';
        dialPad[0][0] = prev;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i==0 && j==0) continue;
                prev = (char) (prev +1);
                dialPad[i][j] = prev;
            }
        }
        dialPad[3][0] = '*';
        dialPad[3][1] = '0';
        dialPad[3][2] = '#';
        return dialPad;
    }
}
