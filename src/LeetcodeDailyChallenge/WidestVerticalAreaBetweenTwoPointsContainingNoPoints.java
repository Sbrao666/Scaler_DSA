package LeetcodeDailyChallenge;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public static void main(String[] args) {
        int[][] points = {{3, 1}, {9, 0}, {1, 0}, {1, 4}, {5, 3}, {8, 8}};
        System.out.println(maxWidthOfVerticalArea(points));
        System.out.println(maxWidthOfVerticalAreaII(points));
    }

    private static int maxWidthOfVerticalAreaII(int[][] points) {
        int widestVerticalArea = 0;
        int n = points.length;
        int[] xPointer = new int[n];
        for (int i = 0; i < n; i++) xPointer[i] = points[i][0];
        Arrays.sort(xPointer);
        for (int i = 1; i < n; i++) {
            widestVerticalArea = Math.max(widestVerticalArea, xPointer[i] - xPointer[i - 1]);
        }
        return widestVerticalArea;
    }

    private static int maxWidthOfVerticalArea(int[][] points) {
        int widestVerticalArea = 1;
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < points.length; i++) {
            int currentWidth = points[i][0] - points[i - 1][0];
            widestVerticalArea = Math.max(currentWidth, widestVerticalArea);
        }

        return widestVerticalArea;
    }
}
