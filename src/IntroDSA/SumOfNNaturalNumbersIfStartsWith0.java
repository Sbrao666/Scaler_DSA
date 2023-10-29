package IntroDSA;

import java.util.Scanner;

public class SumOfNNaturalNumbersIfStartsWith0 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(sumOfNNaturalNumbers_I(n));
        System.out.println(sumOfNNaturalNumbers_II(n));
    }

    //Approach 2 : Constant solution
    private static int sumOfNNaturalNumbers_II(int n) {
        return (n * (n - 1)) / 2;
    }

    //Approach 1 : Brute force
    private static int sumOfNNaturalNumbers_I(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) sum += i;
        return sum;
    }
}
