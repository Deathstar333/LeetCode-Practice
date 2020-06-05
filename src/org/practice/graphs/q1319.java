package org.practice.graphs;

public class q1319 {
    /*
    Time Complexity: O(NlogN)
    Space Complexity: O(N)
     */

    class Solution {
        int[] parent;
        int[] rank;
        public int makeConnected(int n, int[][] connections) {
            int len = connections.length;
            if(len < n-1) return -1;
            this.parent = new int[n];
            this.rank = new int[n];
            Set<Integer> set = new HashSet<>();
            Arrays.fill(parent, -1);
            for(int i=0; i<len; i++) {
                int u = Math.min(connections[i][0], connections[i][1]);
                int v = Math.max(connections[i][0], connections[i][1]);
                union(u, v);
            }

            for(int i=0; i<n; i++) {
                set.add(find(i));
            }

            return set.size()-1;
        }

        public int find(int i) {
            if(parent[i] == -1)
                return i;
            int result = find(parent[i]);
            parent[i] = result;
            return result;
        }

        public void union(int x, int y) {
            int xset = find(x);
            int yset = find(y);

            if(xset == yset) return;

            int xrank = rank[xset];
            int yrank = rank[yset];

            if(xrank < yrank)
                parent[xset] = yset;
            else if(yrank < xrank)
                parent[yset] = xset;
            else {
                parent[xset] = yset;
                rank[yset]++;
            }
            // parent[xset] = yset;
        }
    }
}
