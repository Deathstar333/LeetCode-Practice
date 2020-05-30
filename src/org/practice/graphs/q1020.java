package org.practice.graphs;

public class q1020 {

    /*
    Time Complexity: O(M*N)
    Space Complexity: O(M*N)
     */
    class Solution {
        public int numEnclaves(int[][] A) {
            int row = A.length;
            int col = A[0].length;
            boolean[][] visited = new boolean[row][col];

            //for first and last row
            for(int j=0; j<col; j++) {
                if(!visited[0][j] && A[0][j] == 1)
                    dfs(A, visited, 0, j);
                if(!visited[row-1][j] && A[row-1][j] == 1)
                    dfs(A, visited, row-1, j);
            }

            //for first and last col
            for(int i=0; i<row; i++) {
                if(!visited[i][0] && A[i][0] == 1)
                    dfs(A, visited, i, 0);
                if(!visited[i][col-1] && A[i][col-1] == 1)
                    dfs(A, visited, i, col-1);
            }

            int ans = 0;
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(A[i][j] == 1) ans++;
                }
            }
            return ans;
        }

        public void dfs(int[][] A, boolean[][] visited,int i,int j) {
            if(visited[i][j] || A[i][j] == 0) return;
            int row = A.length;
            int col = A[0].length;

            visited[i][j] = true;
            A[i][j] = 0;

            if(i > 0)
                dfs(A, visited, i-1, j);
            if(j > 0)
                dfs(A, visited, i, j-1);
            if(i < row-1)
                dfs(A, visited, i+1, j);
            if(j < col-1)
                dfs(A, visited, i, j+1);
        }
    }
}
