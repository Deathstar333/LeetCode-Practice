package org.practice.arrays;

public class q189 {

    /*
    Time Complexity: O(N)
    Space Complexity: O(1)
     */
    class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            if(len < 2) return;
            k = k % len;
            if(k == 0) return;
            int counter = 0;
            int index = 0;
            int  prevIndex = 0;
            int held = nums[index];
            while(counter < len) {
                // System.out.println(Arrays.toString(nums));
                index = (index+k)%(len);
                int temp = nums[index];
                nums[index] = held;
                held = temp;
                if(prevIndex == index) {
                    prevIndex++;
                    index++;
                    held = nums[index];
                }
                counter++;
            }
        }
    }

// 1 2 3 4 5 6 7
// k = 3
// held = 1
// 1 2 3 1 5 6 7
// 1 2 3 1 5 6 4
// 1 2 7 1 5 6 4
// 1 2 7 1 5 3 4
// 1 6 7 1 5 3 4
// 1 6 7 1 2 3 4
// 5 6 7 1 2 3 4

}
