package Arrays.PrefixSum;

import java.util.Arrays;

/*
Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.

Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.


Input Format

The only argument given is the integer array A.
Output Format

Return the product array.
Constraints

2 <= length of the array <= 1000
1 <= A[i] <= 10
For Example

Input 1:
    A = [1, 2, 3, 4, 5]
Output 1:
    [120, 60, 40, 30, 24]

Input 2:
    A = [5, 1, 10, 1]
Output 2:
    [10, 50, 5, 50]
*/
public class ProductArrayPuzzle {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] productArray = getProductArray(A);
        System.out.println(Arrays.toString(productArray));
    }

    private static int[] getProductArray(int[] A) {
        int[] productArray = new int[A.length];
        int productOfAllTheElements = getProductOfAllTheElements(A);
        for (int i = 0; i < A.length; i++) {
            productArray[i] = productOfAllTheElements / A[i];
        }
        return productArray;
    }

    private static int getProductOfAllTheElements(int[] A) {
        int product = 1;
        for (int i : A) product *= i;
        return product;
    }
}
