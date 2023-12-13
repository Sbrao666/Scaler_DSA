package LeetcodeDailyChallenge;

//https://leetcode.com/problems/special-positions-in-a-binary-matrix/
public class SpecialPositionsInBinaryMatrix {
    public static void main(String[] args) {
        int[][] A = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(numSpecial(A));
    }

    private static int numSpecial(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (A[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }

        int ans = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (A[row][col] == 1) {
                    if (rowCount[row] == 1 && colCount[col] == 1) {
                        ans++;
                    }
                }
            }
        }

        return ans;

    }


}
