package org.practice.graphs;

public class q1376 {
    /*
    Time Complexity: O(V+E)
    Space Complexity: O(V+E)
     */
    class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

            //create graph
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int i=0; i<n; i++) map.put(i, new ArrayList<Integer>());
            for(int i=0; i<manager.length; i++) {
                if(manager[i] == -1) continue;
                List<Integer> list = map.get(manager[i]);
                list.add(i);
                map.put(manager[i], list);
            }
            // System.out.println(map.toString());

            int time = dfs(headID, map, informTime);
            return time + informTime[headID];
        }

        public int dfs(int src, HashMap<Integer, List<Integer>> map, int[] informTime) {

            int time = Integer.MIN_VALUE;

            List<Integer> list = map.get(src);
            if(list.isEmpty()) time = informTime[src];

            for(int vertex: list) {
                time = Math.max(time, dfs(vertex, map, informTime) + informTime[vertex]);
            }

            return time;
        }
    }
}
