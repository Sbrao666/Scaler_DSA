package Arrays.CarryForward;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an integer array A containing N distinct integers, you have to find all the leaders in array A. An element is a leader if it is strictly greater than all the elements to its right side.

NOTE: The rightmost element is always a leader.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 108


Input Format
There is a single input argument which a integer array A


Output Format
Return an integer array denoting all the leader elements of the array.


Example Input
Input 1:
 A = [16, 17, 4, 3, 5, 2]
Input 2:
 A = [5, 4]


Example Output
Output 1:
[17, 2, 5]
Output 2:
[5, 4]
 */
public class LeadersInArray {
    public static void main(String[] args) {
        int[] A = {16, 17, 4, 3, 5, 2};
        int[] leaders = getLeadersInTheArray_I(A);
        System.out.println(Arrays.toString(leaders));

        leaders = getLeadersInTheArray_II(A);
        System.out.println(Arrays.toString(leaders));
    }

    private static int[] getLeadersInTheArray_II(int[] A) {
        int n = A.length;
        ArrayList<Integer> list = new ArrayList<>();
        int maxTillHere = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (A[i] > maxTillHere) {
                maxTillHere = A[i];
                list.add(maxTillHere);
            }
        }
        return toArray(list);
    }


    //    tc = o(n^2)
    private static int[] getLeadersInTheArray_I(int[] A) {
        int n = A.length;
        ArrayList<Integer> leadersList = new ArrayList<>();
        leadersList.add(A[n - 1]);
        boolean isStrictlyGreater = true;
        for (int i = 0; i < n - 1; i++) {
            isStrictlyGreater = true;
            for (int j = i + 1; j < n; j++) {
                if (A[i] < A[j]) {
                    isStrictlyGreater = false;
                    break;
                }
            }
            if (isStrictlyGreater) leadersList.add(A[i]);
        }
        return toArray(leadersList);
    }

    private static int[] toArray(ArrayList<Integer> list) {
        int n = list.size();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = list.get(i);
        return array;
    }
}
