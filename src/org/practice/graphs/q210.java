package org.practice.graphs;

public class q210 {

    class Solution {
        /*
        int visited array:0 is White
                          1 is Gray
                          2 is Black
        */
        /*
        Time Complexity: O(V+E) same as DFS,BFS
        Space Complexity: O(V)
         */
        HashMap<Integer, ArrayList<Integer>> graph;
        boolean ans;
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int n = numCourses;
            int[] visited = new int[n];
            int[] ordering = new int[n];
            int index = n-1;
            graph = adjList(prerequisites);
            ans = true;
            //System.out.println(graph.toString());
            for(int i=0; i<n; i++) {
                if(visited[i] == 0) {
                    index = dfs(index, ordering, i, visited);
                }
            }
            //System.out.println(Arrays.toString(ordering));
            if(!ans) return new int[0];
            return ordering;

        }

        public int dfs(int index, int[] ordering, int at, int[] visited) {
            visited[at] = 1;

            ArrayList<Integer> neighbours = graph.get(at);
            if(neighbours != null) {
                for(int v: neighbours) {
                    if(visited[v] == 1) {
                        ans = false;
                        break;
                    }
                    if(visited[v] == 0)
                        index = dfs(index, ordering, v, visited);
                }
            }
            ordering[index] = at;
            index--;
            visited[at] = 2;
            return index;
        }

        public HashMap<Integer, ArrayList<Integer>> adjList(int[][] edges) {
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for(int[] edge: edges) {
                ArrayList<Integer> nEdge;
                if(map.containsKey(edge[1])) {
                    nEdge = map.get(edge[1]);
                }
                else {
                    nEdge = new ArrayList<>();
                }
                nEdge.add(edge[0]);
                map.put(edge[1], nEdge);
            }
            return map;
        }
    }
}
