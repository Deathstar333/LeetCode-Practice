package org.practice.arrays;

public class q152 {

    /*
    Time Complexity: O(N)
    Space Complexity: O(1)
     */

    class Solution {
        public int maxProduct(int[] nums) {
            int len = nums.length;
            if(len == 0) return 0;
            int ans = nums[0];
            int imin = 1, imax = 1;
            for(int i=0; i<len; i++) {
                if(nums[i] < 0) {
                    int temp = imin;
                    imin = imax;
                    imax = temp;
                }

                imin = Math.min(nums[i], imin*nums[i]);
                imax = Math.max(nums[i], imax*nums[i]);
                ans = Math.max(ans, imax);
            }
            return ans;
        }
    }

// 2  3 -2  4
// 0  1  2  3
// imin    imax    ans
// -48     4       6

}
