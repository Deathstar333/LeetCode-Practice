package org.practice.graphs;

public class q947 {

    /*
    Time Complexity: O(NlogN)
    Space Complexity: O(N)
     */
    class Solution {
        int[] parent;
        public int removeStones(int[][] stones) {
            this.parent = new int[20000];
            Arrays.fill(parent, -1);
            Set<Integer> set = new HashSet<>();
            int len = stones.length;
            for(int i=0; i<len; i++) {
                union(stones[i][0], stones[i][1] + 10000);
            }
            for(int i=0; i<len; i++) {
                set.add(find(stones[i][0]));
                set.add(find(stones[i][1]+10000));
            }
            return len - set.size();
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
            parent[xset] = yset;
        }
    }
}
