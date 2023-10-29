package IntroDSA;

import java.util.Arrays;

public class ShiftLastKElementToStartOfArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 4;
        shiftLastKElementToStart(A, k);
        System.out.println(Arrays.toString(A));
    }

    private static void shiftLastKElementToStart(int[] A, int k) {
        int n = A.length;
        reverseTheArrayElement(A, n - k, n - 1);
        reverseTheArrayElement(A, 0, n - k - 1);
        reverseTheArrayElement(A, 0, n - 1);
    }

    private static void reverseTheArrayElement(int[] A, int start, int end) {
        while (start < end) {
            swap(A, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] A, int start, int end) {
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
    }
}
