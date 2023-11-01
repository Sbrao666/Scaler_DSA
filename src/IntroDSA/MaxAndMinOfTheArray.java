package IntroDSA;

import java.util.Arrays;
import java.util.List;

public class MaxAndMinOfTheArray {
    public static void main(String[] args) {
        int[] A = {5, 1, 2, 3, 4, 5,-4000,2389323};
        int[] minAndMax = getMinAndMaxOfTheArray(A);
        System.out.println(Arrays.toString(minAndMax));
    }

    private static int[] getMinAndMaxOfTheArray(int[] A) {
        int[] minMax = new int[2];
        minMax[0] = A[0];
        minMax[1] = A[1];
        for (int j : A) {
            minMax[0] = Math.min(minMax[0], j);
            minMax[1] = Math.max(minMax[1], j);
        }
        return minMax;
    }
}
