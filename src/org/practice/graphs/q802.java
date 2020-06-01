package org.practice.graphs;

public class q802 {
    /*
    Time Complexity: O(V+E)
    Space Complexity: O(V)
     */
    class Solution {
        int[][] graph;
        public List<Integer> eventualSafeNodes(int[][] graph) {
            int n = graph.length;
            this.graph = graph;
            // 0: white
            // 1: gray
            // 2: black
            int[] visited = new int[n];
            boolean[] safe = new boolean[n];
            Arrays.fill(safe, true);
            for(int i=0; i<n; i++) {
                if(visited[i] == 0) {
                    boolean isCyclic = dfs(i, -1, visited, safe);
                }
            }

            List<Integer> ans = new ArrayList<>();
            for(int i=0; i<n; i++) {
                if(safe[i]) ans.add(i);
            }
            return ans;
        }

        public boolean dfs(int src, int parent, int[] visited, boolean[] safe) {
            // System.out.println("src: " + src);
            boolean isCyclic = false;
            int flag = 0;
            visited[src] = 1;

            for(int x: graph[src]) {
                // System.out.println(x);
                if(safe[x] == false) {
                    isCyclic = true;
                }

                else if(visited[x] == 1) {
                    safe[x] = false;
                    isCyclic = true;
                    //cycle found
                }

                else if(visited[x] == 0) {
                    isCyclic = dfs(x, src, visited, safe);
                    if(isCyclic) safe[x] = false;
                }

                if(isCyclic) flag = 1;
            }

            visited[src] = 2;
            if(flag == 1) safe[src] = false;
            return (flag == 1);
        }
    }
}
