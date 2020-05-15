package org.practice.arrays;

public class q918 {
    /*
    Time Complexity: O(N)
    Space Complexity: O(1)
     */
    class Solution {
        public int maxSubarraySumCircular(int[] A) {
            int ans1, ans2, ans3, sum = 0;
            int len = A.length;
            if(len == 1) return A[0];
            for(int i: A) {
                sum += i;
            }
            ans1 = kadane(A, 0, len-1, 1);
            ans2 = kadane(A, 1, len-1, -1);
            ans3 = kadane(A, 0, len-2, -1);
            // System.out.println(ans1);
            // System.out.println(ans2);
            // System.out.println(ans3);
            return Math.max(ans1, sum + Math.min(ans2, ans3));
        }

        public int kadane(int[] A, int start, int end, int sign) {
            int len = A.length;
            int max_ending_here = sign*A[start], max_so_far = sign*A[start];
            for(int i=start+1; i<=end; i++) {
                max_ending_here = Math.max(max_ending_here + sign*A[i], sign*A[i]);
                max_so_far = Math.max(max_ending_here, max_so_far);
            }
            return max_so_far;
        }
    }

// A: 5 -3  5  5 -3  5
//    5  2  7
//      -3  5 10
//          5 10  7

}
