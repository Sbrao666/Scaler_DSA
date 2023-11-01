package IntroDSA;

public class SecondLargest {
    public static void main(String[] args) {
        int[] A = {2, 1, 2};
        System.out.println(getSecondLargestElement_I(A));
        System.out.println(getSecondLargestElement_II(A));
    }

    private static int getSecondLargestElement_II(int[] A) {
        int n = A.length;
        if (n <= 1) return -1;
        int max = -1;
        int secondMax = -1;
        for (int i : A) {
            if (i > max) {
                secondMax = max;
                max = i;
            }
            if (i > secondMax && i < max) secondMax = i;
        }

        return secondMax;
    }

    //    Approach 1 : Brute force
    private static int getSecondLargestElement_I(int[] A) {
        int largest = getLargest(A);
        return getSecondLargest(A, largest);
    }

    private static int getSecondLargest(int[] A, int largest) {
        int secondLargest = Integer.MIN_VALUE;
        for (int i : A) {
            if (i < largest) {
                secondLargest = Math.max(secondLargest, i);
            }
        }
        return secondLargest;
    }

    private static int getLargest(int[] A) {
        int largest = A[0];
        for (int i : A) largest = Math.max(largest, i);
        return largest;
    }
}
