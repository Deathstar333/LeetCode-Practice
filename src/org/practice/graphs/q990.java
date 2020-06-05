package org.practice.graphs;

public class q990 {
    /*
    Time Complexity: O(NlogN)
    Space Complexity: O(N)
     */

    class Solution {
        int[] parent;
        public boolean equationsPossible(String[] equations) {
            int len = equations.length;
            this.parent = new int[26];
            Arrays.fill(parent, -1);
            for(String str: equations) {
                if(str.charAt(1) == '!') continue;
                int x = str.charAt(0) - 'a';
                int y = str.charAt(3) - 'a';
                union(x, y);
            }

            for(String str: equations) {
                if(str.charAt(1) == '=') continue;
                int x = str.charAt(0) - 'a';
                int y = str.charAt(3) - 'a';
                if(find(x) == find(y)) return false;
            }
            return true;
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
