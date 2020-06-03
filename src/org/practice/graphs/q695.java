package org.practice.graphs;

public class q695 {
    /*
    Time Complexity: O(V+E)
    Space Complexity: O(V+E)
     */
    class Solution {
        int[][] grid;
        int row, col;
        public int maxAreaOfIsland(int[][] grid) {
            this.grid = grid;
            this.row = grid.length;
            if(row < 1) return 0;
            this.col = grid[0].length;
            int ans = 0;

            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(grid[i][j] == 1)
                        ans = Math.max(ans, dfs(i, j));
                }
            }
            return ans;
        }

        public int dfs(int i, int j) {
            if(grid[i][j] == 0) return 0;

            grid[i][j] = 0;

            int area = 1;
            if(i > 0) area += dfs(i-1,j);
            if(j > 0) area += dfs(i,j-1);
            if(i < row-1) area += dfs(i+1,j);
            if(j < col-1) area += dfs(i,j+1);

            return area;
        }
    }
}
