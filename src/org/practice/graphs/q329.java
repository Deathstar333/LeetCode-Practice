package org.practice.graphs;

public class q329 {
    /*
    Time Complexity: O(N)
    Space Complexity: O(N)
    N is size of grid
     */

    class Solution {
        int[][] memo;
        int ans;
        public int longestIncreasingPath(int[][] matrix) {
            int row = matrix.length;
            if(row == 0) return 0;
            int col = matrix[0].length;
            ans = 1;
            memo = new int[row][col];

            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(memo[i][j] == 0) {
                        dfs(i,j,matrix);
                    }
                }
            }
            return ans;
        }

        public int dfs(int i, int j, int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            if(memo[i][j] != 0)
                return memo[i][j];

            int max = 1;
            int curr = matrix[i][j];
            if(i < row-1 && curr < matrix[i+1][j])
                max = Math.max(max, dfs(i+1, j, matrix) + 1);
            if(i > 0 && curr < matrix[i-1][j])
                max = Math.max(max, dfs(i-1, j, matrix) + 1);
            if(j < col-1 && curr < matrix[i][j+1])
                max = Math.max(max, dfs(i, j+1, matrix) + 1);
            if(j > 0 && curr < matrix[i][j-1])
                max = Math.max(max, dfs(i, j-1, matrix) + 1);

            memo[i][j] = max;
            ans = Math.max(ans, max);
            return max;
        }
    }
}
