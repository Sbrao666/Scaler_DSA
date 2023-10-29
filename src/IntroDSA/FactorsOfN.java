package IntroDSA;

import java.util.Scanner;

public class FactorsOfN {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(getFactorsOfN_I(n));
        System.out.println(getFactorsOfN_II(n));
    }

    //Approach 2 : Better-Brute force
    private static int getFactorsOfN_II(int n) {
        int cnt = 2;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) cnt++; // increase count by 1 if perfect square
                else cnt += 2; //else increase by 2
            }
        }
        return cnt;
    }


    //Approach 1 : Brute force
    private static int getFactorsOfN_I(int n) {
        int cnt = 2;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) cnt++;
        }
        return cnt;
    }

}
