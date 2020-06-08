package org.practice.greedy;

public class q1094 {

    /*
    Time Complexity: O(N)
    Space Complexity: O(1)
     */
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int[] arr = new int[1001];
            for(int[] trip: trips) {
                arr[trip[1]] += trip[0];
                arr[trip[2]] -= trip[0];
            }
            // System.out.println(Arrays.toString(arr));
            for(int x: arr) {
                capacity -= x;
                if(capacity < 0) return false;
            }
            return true;
        }
    }
}
