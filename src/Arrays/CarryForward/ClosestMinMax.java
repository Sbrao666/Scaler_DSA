package Arrays.CarryForward;

/*
Problem Description
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.



Problem Constraints
1 <= |A| <= 2000



Input Format
First and only argument is vector A



Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array



Example Input
Input 1:

A = [1, 3, 2]
Input 2:

A = [2, 6, 1, 6, 9]


Example Output
Output 1:

 2
Output 2:

 3
 */
public class ClosestMinMax {
    public static void main(String[] args) {
        int[] A = {377, 448, 173, 307, 108};
        System.out.println(getTheMinLengthOfSubArray_I(A));
        System.out.println(getTheMinLengthOfSubArray_II(A));
        System.out.println(getTheMinLengthOfSubArray_III(A));
    }

    //    TC=O(N) but more readable
    private static int getTheMinLengthOfSubArray_III(int[] A) {
        int n = A.length;
        int suarrayPossibleWithLength = n;

        int min = getMin(A);
        int max = getMax(A);

        if (min == max) return 1;

        int indexOfMinElement = -1;
        int indexOfMaxElement = -1;

        for (int i = 0; i < n; i++) {
            if (A[i] == min) {
                indexOfMinElement = i;
                if (indexOfMaxElement != -1) {
                    int diff = i - indexOfMaxElement + 1;
                    suarrayPossibleWithLength = Math.min(suarrayPossibleWithLength, diff);
                }
            }

            if (A[i] == max) {
                indexOfMaxElement = i;
                if (indexOfMinElement != -1) {
                    int diff = i - indexOfMinElement + 1;
                    suarrayPossibleWithLength = Math.min(suarrayPossibleWithLength, diff);
                }
            }
        }

        return suarrayPossibleWithLength;
    }

    //    TC=O(N)
    private static int getTheMinLengthOfSubArray_II(int[] A) {
        int n = A.length;
// find the min and max of the array
        int min = getMin(A);
        int max = getMax(A);
        int length = n;

//initially mark minIndex and maxIndex to the -1. That will our carryForward to mark min and max in the array to find the difference
        int minIndex = -1;
        int maxIndex = -1;
//for each element in the array
        for (int i = 0; i < n; i++) {
            if (A[i] == min) {
// if the current element is the min and max is not found yet then mark current index as minIndex
                if (maxIndex == -1) {
                    minIndex = i;
                } else {
//if we already got maxIndex then find the difference and check if minimum or not
                    int diff = i - maxIndex + 1;
                    length = Math.min(length, diff);
                    minIndex = i;
                }
// if the current element is the max
            } else if (A[i] == max) {
// if the current element is the max and min is not found yet then mark current index as maxIndex
                if (minIndex == -1) {
                    maxIndex = i;
                } else {
//if we already got minIndex then find the difference and check if minimum or not
                    int diff = i - minIndex + 1;
                    length = Math.min(length, diff);
                    maxIndex = i;
                }
            }

        }

        return length;

    }


    //    TC=O(N^2)
    private static int getTheMinLengthOfSubArray_I(int[] A) {
        int n = A.length;
        int min = n;
        int minElement = getMin(A);
        int maxElement = getMax(A);
        for (int i = 0; i < n; i++) {
            if (A[i] == minElement) {
                for (int j = i + 1; j < n; j++) {
                    if (A[j] == maxElement) {
                        min = Math.min(min, (j - i) + 1);
                        break;
                    }
                }
            } else if (A[i] == maxElement) {
                for (int j = i + 1; j < n; j++) {
                    if (A[j] == minElement) {
                        min = Math.min(min, (j - i) + 1);
                        break;
                    }
                }
            }
        }
        return min;
    }

    private static int getMax(int[] A) {
        int max = A[0];
        for (int a : A) max = Math.max(a, max);
        return max;
    }

    private static int getMin(int[] A) {
        int min = A[0];
        for (int a : A) min = Math.min(min, a);
        return min;
    }
}
