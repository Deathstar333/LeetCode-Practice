package org.practice.graphs;

public class q547 {
    /*
    Time Complexity: O(V+E)
    Space Complexity: O(V+E)
     */
    class Solution {
        int row, col;
        public int findCircleNum(int[][] M) {
            this.row = M.length;
            if(row == 0) return 0;
            this.col = M[0].length;
            boolean[] visited = new boolean[row];
            int ans = 0;
            Deque<Integer> dq = new ArrayDeque<>();
            for(int i=0; i<row; i++) {
                if(!visited[i]) {
                    dq.add(i);
                    while(!dq.isEmpty()) {
                        int x = dq.poll();
                        visited[x] = true;
                        for(int j=0; j<col; j++) {
                            if(!visited[j] && M[x][j] == 1) {
                                dq.add(j);
                            }
                        }
                    }
                    ans++;
                }
            }
            return ans;
        }
    }
}
