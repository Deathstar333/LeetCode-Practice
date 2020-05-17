package org.practice.graphs;

public class q207 {

    class Solution {
        /*
        int visited array:0 is White
                          1 is Gray
                          2 is Black
        */
        /*
        Time Complexity: O(V+E) same as DFS
        Space Complexity: O(V)
         */
        List<List<Integer>> graph;
        boolean ans;
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int n = numCourses;
            int[] visited = new int[n];
            graph = adjList(prerequisites, n);
            ans = true;
            for(int i=0; i<n; i++) {
                if(visited[i] == 0) {
                    dfs(i, visited);
                }
            }
            return ans;

        }

        public void dfs(int at, int[] visited) {
            visited[at] = 1;

            List<Integer> neighbours = graph.get(at);
            if(neighbours != null) {
                for(int v: neighbours) {
                    if(visited[v] == 1) {
                        ans = false;
                        return;
                    }
                    if(visited[v] == 0)
                        dfs(v, visited);
                }
            }
            visited[at] = 2;
        }

        public List<List<Integer>> adjList(int[][] edges, int n) {
            List<List<Integer>> map = new ArrayList<List<Integer>>();
            for(int i=0; i<n; i++) map.add(new ArrayList<Integer>());
            for(int[] edge: edges) {
                map.get(edge[0]).add(edge[1]);
            }
            return map;
        }

    }
}
