package LeetcodeDailyChallenge;

import java.util.Arrays;

//https://leetcode.com/problems/difference-between-ones-and-zeros-in-row-and-column/
public class DifferenceBetweenOnesZerosRowColumn {
    public static void main(String[] args) {
        int[][] A = {{1, 1, 1}, {1, 1, 1}};
        int[][] diff = onesMinusZeros(A);
        int[][] diff1 = onesMinusZerosI(A);
        for (int[] d : diff) System.out.println(Arrays.toString(d));
        System.out.println();
        for (int[] d : diff1) System.out.println(Arrays.toString(d));
    }

    private static int[][] onesMinusZerosI(int[][] grid) {
        int row[]= new int[grid.length];
        int column[]= new int[grid[0].length];
        for(int i=0; i<row.length; i++){
            int one=0;
            for(int j=0; j<column.length; j++){
                one = one + grid[i][j];
            }
            row[i]= (2*one)-(row.length);
        }

        for(int j=0; j<column.length; j++){
            int one=0;
            for(int i=0; i<row.length; i++){
                one = one + grid[i][j];
            }
            column[j]= (2*one)-(column.length);
        }

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                grid[i][j]= row[i]+column[j];
            }
        }
        return grid;
    }

    private static int[][] onesMinusZeros(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[] row = new int[n];
        int[] col = new int[m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row[i] += A[i][j] == 1 ? 1 : -1;
                col[j] += A[i][j] == 1 ? 1 : -1;
            }
        }

        return getDiffMetrics(row, col, n, m);
    }

    private static int[][] getDiffMetrics(int[] row, int[] col, int n, int m) {
        int[][] diff = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                diff[i][j] = row[i] + col[j];
            }
        }
        return diff;
    }
}
