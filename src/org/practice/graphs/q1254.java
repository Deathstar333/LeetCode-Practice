package org.practice.graphs;

public class q1254 {
    /*
    Time Complexity: O(V+E)
    Space Complexity: O(V+E)
     */
    class Solution {
        int[][] grid;
        int row, col;
        public int closedIsland(int[][] grid) {
            this.grid = grid;
            this.row = grid.length;
            this.col = grid[0].length;
            int ans = 0;

            //first and last row
            for(int j=0; j<col; j++) {
                if(grid[0][j] == 0) helper(0,j);
                if(grid[row-1][j] == 0) helper(row-1,j);
            }

            //first and last col
            for(int i=0; i<row; i++) {
                if(grid[i][0] == 0) helper(i,0);
                if(grid[i][col-1] == 0) helper(i,col-1);
            }

            //find closed islands
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(grid[i][j] == 0) {
                        helper(i,j);
                        ans++;
                    }
                }
            }
            return ans;

        }

        public void helper(int i, int j) {

            grid[i][j] = 1;

            if(i > 0 && grid[i-1][j] == 0)
                helper(i-1,j);
            if(j > 0 && grid[i][j-1] == 0)
                helper(i,j-1);
            if(i < row-1 && grid[i+1][j] == 0)
                helper(i+1,j);
            if(j < col-1 && grid[i][j+1] == 0)
                helper(i,j+1);
        }
    }
}
