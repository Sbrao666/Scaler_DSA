package IntroDSA;

import java.util.Arrays;

public class ReverseTheArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6};
        reverseArray(A);
        System.out.println(Arrays.toString(A));
    }

    private static void reverseArray(int[] A) {
        int start = 0;
        int end = A.length - 1;
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
