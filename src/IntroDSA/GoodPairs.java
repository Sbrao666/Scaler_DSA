package IntroDSA;

import java.util.HashMap;
import java.util.HashSet;

public class GoodPairs {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int B = 7;
        System.out.println(numberOfGoodPairs_I(A, B));
        System.out.println(numberOfGoodPairs_II(A, B));
    }

    private static int numberOfGoodPairs_II(int[] A, int B) {
        HashSet<Integer> set = new HashSet<>();
        set.add(A[0]);
        for (int i = 1; i < A.length; i++) {
            int diff = Math.abs(B - A[i]);
            if (set.contains(diff)) return 1;
            set.add(A[i]);
        }
        return 0;
    }

    //    Approach 1 : Brute force
    private static int numberOfGoodPairs_I(int[] A, int B) {
        int cnt = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] + A[j] == B) cnt++;
            }
        }
        return cnt;
    }
}
