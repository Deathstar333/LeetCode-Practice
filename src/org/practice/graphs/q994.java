package org.practice.graphs;

public class q994 {
    /*
    Time Complexity: O(N)
    Space Complexity: O(N)
    N is size of grid
     */

    class Solution {
        public int orangesRotting(int[][] grid) {
            int row = grid.length;
            if(row == 0) return 0;
            int col = grid[0].length;
            int[][] visited = new int[row][col];
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(grid[i][j] == 2) {
                        bfs(i, j, grid, visited);
                    }
                }
            }
            // for(int[] x: visited)
            //     System.out.println(Arrays.toString(x));
            int ans = 0;
            for(int i=0; i<row; i++) {
                for(int j=0; j<col; j++) {
                    if(grid[i][j] == 1) {
                        if(visited[i][j] == 0)
                            return -1;
                        else
                            ans = Math.max(ans, visited[i][j]);
                    }
                }
            }
            return ans;
        }

        public void bfs(int r, int c, int[][] grid, int[][] visited) {
            int row = grid.length;
            int col = grid[0].length;
            boolean flag = false;
            Deque<Node> dq = new ArrayDeque<>();
            dq.add(new Node(r,c,0));
            while(!dq.isEmpty()) {
                Node node = dq.poll();
                int i = node.i;
                int j = node.j;
                int level = node.level;
                if(flag && grid[i][j] != 1)
                    continue;
                flag = true;
                if(visited[i][j] != 0 && level >= visited[i][j]) {
                    continue;
                }
                visited[i][j] = level;

                if(i < row - 1)
                    dq.add(new Node(i+1,j,level+1));
                if(i > 0)
                    dq.add(new Node(i-1,j,level+1));
                if(j < col - 1)
                    dq.add(new Node(i,j+1,level+1));
                if(j > 0)
                    dq.add(new Node(i,j-1,level+1));
            }
        }
    }

    class Node {
        int i;
        int j;
        int level;

        public Node(int i, int j, int level) {
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
}
