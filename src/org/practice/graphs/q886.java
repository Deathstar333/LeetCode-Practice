package org.practice.graphs;

public class q886 {

    /*
    Time Complexity: O(V+E)
    Space Complexity: O(V+E)
     */
    class Solution {
        boolean ans;
        public boolean possibleBipartition(int N, int[][] dislikes) {
            this.ans = true;
            // 1: Red
            // 2: Blue
            int[] vertexColors = new int[N+1];
            ArrayList<Integer>[] adjList = new ArrayList[N+1];
            for(int i=0; i<=N; i++)
                adjList[i] = new ArrayList<Integer>();

            for(int[] row: dislikes) {
                adjList[row[0]].add(row[1]);
                adjList[row[1]].add(row[0]);
            }
            for(int i=1; i<=N; i++) {
                if(vertexColors[i] == 0)
                    dfs(i, vertexColors, adjList, 1);
            }
            return ans;
        }

        public void dfs(int src, int[] vertexColors, ArrayList<Integer>[] adjList, int color) {
            if(!ans) return;

            if(vertexColors[src] != 0) {
                if(vertexColors[src] == color)
                    return;
                else {
                    ans = false;
                    return;
                }
            }

            vertexColors[src] = color;
            color = (color%2)+1;
            ArrayList<Integer> neighbours = adjList[src];
            for(int neighbour: neighbours) {
                dfs(neighbour, vertexColors, adjList, color);
            }

        }
    }
}
