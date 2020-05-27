package org.practice.graphs;

public class q886 {

    /*
    Time Complexity: O(V^2)
    Space Complexity: O(V^2)
     */
    class Solution {
        boolean ans = true;
        boolean[] visited;
        int N;
        int[] levels;
        public boolean possibleBipartition(int N, int[][] dislikes) {
            int[][] adjMat = new int[N+1][N+1];
            this.visited = new boolean[N+1];
            this.N = N;
            this.levels = new int[N+1];
            int row = dislikes.length;
            if(row == 0) return true;

            //build the adjMatrix
            for(int i=0; i<row; i++) {
                for(int j=0; j<2; j++) {
                    int x = dislikes[i][0];
                    int y = dislikes[i][1];
                    adjMat[x][y] = 1;
                    adjMat[y][x] = 1;
                }
            }
            // for(int r[]: adjMat) {
            //     System.out.println(Arrays.toString(r));
            // }
            for(int i=1; i<N+1; i++) {
                if(!visited[i])
                    dfs(adjMat, i, 0, 1);
            }
            return ans;

        }

        public void dfs(int[][] adjMat, int vertex, int parent, int level) {
            if(!ans) return;
            visited[vertex] = true;
            levels[vertex] = level;
            for(int neighbour = 1; neighbour<N+1; neighbour++) {
                if(adjMat[vertex][neighbour] == 0) continue;
                if(neighbour == parent) continue;

                if(!visited[neighbour]) {
                    dfs(adjMat, neighbour, vertex, level+1);
                }
                else {
                    if((level - levels[neighbour])%2 == 0){
                        ans = false;
                    }
                }
            }
        }
    }

// adjMat
// 0 0 0 0
// 0 0 1 1
// 0 1 0 1
// 0 1 1 0


// 1->2->3->4->5->1

}
