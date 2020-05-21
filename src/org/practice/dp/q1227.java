package org.practice.dp;

public class q1227 {

    /*
    Time complexity: O(m*n)
    Space Complexity: O(m*n) can be reduced to O(n) or O(1)
    */
    class Solution {
        public int countSquares(int[][] matrix) {
            int row = matrix.length;
            if(row == 0) return 0;
            int col = matrix[0].length;
            int dp[][] = new int[row+1][col+1];
            int ans = 0;
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(matrix[i][j] == 1) {
                        int temp = Math.min(dp[i][j+1],dp[i+1][j]);
                        dp[i+1][j+1] = Math.min(dp[i][j], temp) + 1;
                        ans += dp[i+1][j+1];
                    }
                }
            }
            return ans;
        }
    }
}
