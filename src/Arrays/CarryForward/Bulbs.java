package Arrays.CarryForward;

/*
Problem Description
A wire connects N light bulbs.

Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.

Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.

You can press the same switch multiple times.

Note: 0 represents the bulb is off and 1 represents the bulb is on.



Problem Constraints
0 <= N <= 5×105
0 <= A[i] <= 1



Input Format
The first and the only argument contains an integer array A, of size N.



Output Format
Return an integer representing the minimum number of switches required.



Example Input
Input 1:

 A = [0, 1, 0, 1]
Input 2:

 A = [1, 1, 1, 1]


Example Output
Output 1:

 4
Output 2:

 0
 */
public class Bulbs {
    public static void main(String[] args) {
        int[] A = {0, 1, 1, 0, 1, 1, 0, 1, 0, 1};
        System.out.println(getTheNumberOfToggles_II(A));
        System.out.println(getTheNumberOfToggles_I(A));
    }

    //    tc = o(n^2)
    private static int getTheNumberOfToggles_I(int[] A) {
        int n = A.length;
        int toggles = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 && A[i] == 0) {
                toggles++;
                break;
            }
            if (A[i] == 0) {
                toggles++;
                for (int j = i + 1; j < n; j++) {
                    A[j] = 1 - A[j];
                }
            }
        }
        return toggles;
    }


    //    tc = o(n)
/*
        Logic :If the switch till ith bulb is toggle even no of times then it state
        remain same if toggle odd numbers of time then state become
        toggled.
        Why we have to toggled when number of toggles are odd
        --> Because If toggle is odd number of times that means each thing at the right side is toggled but if it is even number of times that means reverse of toggle is already happen
        so technically we can say that nothing is happend.
        We have to CF the cnt of 0 from left to right. i.e. the no of
        time switch toggled. Because each 0 we have to press the switch to turn it on
*/
    private static int getTheNumberOfToggles_II(int[] A) {
        int toggles = 0;
        for (int a : A) {
            if (toggles % 2 != 0) {
                a = 1 - a;
            }
            if (a == 0) toggles++;
        }
        return toggles;
    }
}
