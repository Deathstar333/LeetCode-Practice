package org.practice.arrays;

public class q334 {

    /*
    Time Complexity: O(N)
    Space Complexity: O(1)
     */
    class Solution {
        public boolean increasingTriplet(int[] nums) {
            int min = Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num <= min) {
                    min = num;
                } else if (num <= secondMin) {
                    secondMin = num;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
