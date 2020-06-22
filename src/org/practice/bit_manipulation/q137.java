package org.practice.bit_manipulation;

public class q137 {

    /*
    Time Complexity: O(32*N)
    Space Complexity: O(1)
     */
    class Solution {
        public int singleNumber(int[] nums) {
            int[] arr = new int[32];
            for(int x: nums) {
                for(int i=0; i<32; i++) {
                    if((x & (1 << i)) != 0) {
                        arr[i] = (arr[i]+1)%3;
                    }
                }
            }
            int ans = 0;
            for(int i=0; i<32; i++) {
                if(arr[i] == 1) ans += (1 << i);
            }
            return ans;
        }
    }
}
