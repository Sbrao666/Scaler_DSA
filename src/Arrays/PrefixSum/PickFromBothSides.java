package Arrays.PrefixSum;


/*
Problem Description
You are given an integer array A of size N.

You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.

Find and return the maximum possible sum of the B elements that were removed after the B operations.

NOTE: Suppose B = 3, and array A contains 10 elements, then you can:

Remove 3 elements from front and 0 elements from the back, OR
Remove 2 elements from front and 1 element from the back, OR
Remove 1 element from front and 2 elements from the back, OR
Remove 0 elements from front and 3 elements from the back.


Problem Constraints
1 <= N <= 105

1 <= B <= N

-103 <= A[i] <= 103



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return an integer denoting the maximum possible sum of elements you removed.



Example Input
Input 1:

 A = [5, -2, 3 , 1, 2]
 B = 3
Input 2:

 A = [ 2, 3, -1, 4, 2, 1 ]
 B = 4


Example Output
Output 1:

 8
Output 2:

 9
 */

public class PickFromBothSides {
    public static void main(String[] args) {
        int[] A = {5, -2, 3 , 1, 2};
        int B = 3;
        System.out.println(maxSumFromBothSides(A, B));
    }

    private static int maxSumFromBothSides(int[] A, int B) {
        int[] prefixSum = getPrefixSum(A);
        int maxSum = Integer.MIN_VALUE;
        int n = A.length;
        int lastElement = n - 1;
        for (int i = 0; i <= B; i++) {
            int fromStart = i == 0 ? 0 : prefixSum[i-1];
            int fromEnd = prefixSum[lastElement] - prefixSum[lastElement-(B-i)];
            maxSum = Math.max(maxSum, fromEnd + fromStart);
        }
        return maxSum;
    }

    private static int[] getPrefixSum(int[] A) {
        int n = A.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = A[0];
        for (int i = 1; i < n; i++) prefixSum[i] = prefixSum[i - 1] + A[i];
        return prefixSum;
    }
}
