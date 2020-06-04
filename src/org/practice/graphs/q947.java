package org.practice.graphs;

public class q947 {

    /*
    Time Complexity: O(N^2)
    Space Complexity: O(N^2)
     */
    class Solution {
        int[][] stones;
        int len;
        Map<Integer, List<Integer>> map;
        int[] parent;
        public int removeStones(int[][] stones) {
            this.stones = stones;
            this.len = stones.length;
            this.map = new HashMap<>();
            this.parent = new int[len];
            Arrays.fill(parent, -1);

            HashSet<Integer> set = new HashSet<>();

            for(int i=0; i<len; i++) {
                for(int j=i+1; j<len; j++) {
                    if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                        List<Integer> list = map.getOrDefault(i, new ArrayList<Integer>());
                        list.add(j);
                        map.put(i, list);
                    }
                }
            }
            // System.out.println(map.toString());

            for(int i=0; i<len-1; i++) {
                if(map.get(i) == null) continue;
                for(int x: map.get(i)) {
                    // System.out.println("start: " + Arrays.toString(parent));
                    union(i, x);
                    // System.out.println("end: " + Arrays.toString(parent));
                }
            }

            for(int i=0; i<len; i++) {
                set.add(find(i));
            }

            return len - set.size();
        }

        public int find(int i) {
            if(parent[i] == -1)
                return i;
            return find(parent[i]);
        }

        public void union(int x, int y) {
            int xset = find(x);
            int yset = find(y);
            if(xset == yset) return;
            parent[xset] = yset;
        }
    }

    // 0  1  2  3  4  5
    // 1  2  4  5  3 -1
}
