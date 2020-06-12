package org.practice.greedy;

public class q135 {
    /*
    Time Complexity: O(N)
    Space Complexity: O(N)
     */
    class Solution {
        public int candy(int[] ratings) {
            int len = ratings.length;
            int[] candies = new int[len];
            Arrays.fill(candies, 1);
            int sum = 0;

            for(int i=1; i<len; i++) {
                if(ratings[i] > ratings[i-1]) candies[i] = Math.max(candies[i], candies[i-1] + 1);
            }

            for(int i=len-2; i>=0; i--) {
                if(ratings[i] > ratings[i+1]) candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }

            for(int i=0; i<len; i++) sum += candies[i];
            return sum;
        }
    }

// [1,3,4,5,2]
// [1,2,3,4,1]
}
