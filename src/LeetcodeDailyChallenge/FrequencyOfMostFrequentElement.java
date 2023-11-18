package LeetcodeDailyChallenge;

import java.util.Arrays;

//https://leetcode.com/problems/frequency-of-the-most-frequent-element/
public class FrequencyOfMostFrequentElement {
    public static void main(String[] args) {
        int[] A = {1, 2, 4};
        int k = 5;
        System.out.println(maxFreqOfMostFreqElement(A, k));
    }

    private static int maxFreqOfMostFreqElement(int[] A, int B) {
        Arrays.sort(A);
        int maxLength = 0;
        int sum = 0;
        int j = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];

            while (i - j + 1 * A[i] - sum > B) {
                sum -= A[j++];
            }

            maxLength = Math.max(maxLength, i - j + 1);

        }

        return maxLength;
    }


}
