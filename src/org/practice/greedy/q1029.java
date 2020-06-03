package org.practice.greedy;

public class q1029 {
    /*
    Time Complexity: O(NlogN)
    Space Complexity: (1)
     */
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs, new myComp());
            int len = costs.length;
            // for(int[] x: costs)
            //     System.out.println(Arrays.toString(x));
            int a = len/2, b = len/2;
            int ans = 0;
            for(int[] x: costs) {
                if(a == 0) {
                    ans += x[1];
                    continue;
                }
                if(b == 0) {
                    ans += x[0];
                    continue;
                }
                if(x[0] < x[1]) {
                    ans += x[0];
                    a--;
                }
                else {
                    ans += x[1];
                    b--;
                }
            }
            return ans;
        }

        public class myComp implements Comparator<int[]> {
            public int compare(int[] a, int[] b) {
                int diffa = Math.abs(a[0]-a[1]);
                int diffb = Math.abs(b[0]-b[1]);
                return diffb - diffa;
            }
        }
    }
}
