package org.practice.arrays;

public class q973 {
    /*
    Time Complexity: O(NlogK)
    Space Complexity: O(K)
     */
    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            PriorityQueue<int[]> pq = new PriorityQueue(new myComp());
            for(int[] point: points) {
                pq.add(point);
                if(pq.size() > K) pq.poll();
            }
            int[][] ans = new int[K][2];
            int i = 0;
            for(int[] point: pq) {
                ans[i] = point;
                i++;
            }
            return ans;
        }

        public class myComp implements Comparator<int[]> {
            public int compare(int[] a, int[] b) {
                return -1*(a[0]*a[0] + a[1]*a[1] - b[0]*b[0] - b[1]*b[1]);
            }
        }
    }
}
