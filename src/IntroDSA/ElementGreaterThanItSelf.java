package IntroDSA;

public class ElementGreaterThanItSelf {
    public static void main(String[] args) {
        int[] A = {-1, 2, 4, 6, 5, 6, 2};
        System.out.println(numberOfElementGreaterThanItself(A));
    }

    private static int numberOfElementGreaterThanItself(int[] A) {
        int n = A.length;
        int max = findTheMaxOfTheArray(A, n);
        int count = findTheOccurrences(A, n, max);
        return n - count;
    }

    private static int findTheOccurrences(int[] A, int n, int max) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == max) count++;
        }
        return count;
    }

    private static int findTheMaxOfTheArray(int[] A, int n) {
        int max = A[0];
        for (int i = 1; i < n; i++) max = Math.max(max, A[i]);
        return max;
    }
}
