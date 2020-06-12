package org.practice.greedy;

public class q134 {

    /*
    Time Complexity: O(N)
    Space Complexity: O(1)
     */
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int len = gas.length;
            int start = 0, sum = 0, diff = 0;
            for(int i=0; i<len; i++) {
                sum += gas[i] - cost[i];
                if(sum < 0) {
                    start = i + 1;
                    diff += sum;
                    sum = 0;
                }
            }
            return (sum + diff >= 0) ? start: -1;

        }
    }

// [5,8,2,8]
// [6,5,6,6]

// [-1,3,-4,2]

//[1,5,-6,-2,3,-4,3]
}
