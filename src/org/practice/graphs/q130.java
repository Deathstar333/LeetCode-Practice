package org.practice.graphs;

public class q130 {
    /*
    Time complexity: O(m*n)
    Space Complexity: O(m*n)
     */

    class Solution {
        // int[] dispx = {1,-1,0,0};
        // int[] dispy = {0,0,1,-1};
        int row, col;
        public void solve(char[][] board) {
            row = board.length;
            if(row == 0) return ;
            col = board[0].length;
            // boolean[][] visited = new boolean[row][col];
            //first row and last row
            for(int j=0; j<col; j++) {
                if(board[0][j] == 'O') bfs(0, j, board);
                if(board[row-1][j] == 'O') bfs(row-1, j, board);
            }

            //first col and last col
            for(int i=0; i<row; i++) {
                if(board[i][0] == 'O') bfs(i, 0, board);
                if(board[i][col-1] == 'O') bfs(i, col-1, board);
            }

            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(board[i][j] == '$') board[i][j] = 'O';
                    else if(board[i][j] == 'O') board[i][j] = 'X';
                }
            }

        }

        public void bfs(int r, int c, char board[][]) {
            Deque<int[]> dq = new ArrayDeque<>();
            int[] curr = new int[2];
            curr[0] = r;
            curr[1] = c;
            dq.add(curr);
            while(!dq.isEmpty()) {
                curr = dq.poll();
                int x = curr[0];
                int y = curr[1];
                if(board[x][y] != 'O')
                    continue;
                // visited[x][y] = true;
                board[x][y] = '$';
                if(curr[0] > 0)
                    dq.add(new int[]{x-1,y});
                if(curr[0] < row-1)
                    dq.add(new int[]{x+1,y});
                if(curr[1] > 0)
                    dq.add(new int[]{x,y-1});
                if(curr[1] < col-1)
                    dq.add(new int[]{x,y+1});

            }

        }

    }
}
