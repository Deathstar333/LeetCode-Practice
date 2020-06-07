package org.practice.dp;

public class q377 {

    /*
    Time Complexity: O(N*k) where k is nums length
    Space Complexity: O(N)
     */
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            if(target == 0) return 1;
            int[] dp = new int[target+1];
            dp[0] = 1;
            for(int i=1; i<=target; i++) {
                for(int num: nums) {
                    if(num <= i) {
                        dp[i] += dp[i-num];
                    }
                }
            }
            return dp[target];
        }
    }

//1)Subproblem: target t where t belongs to [0,N]
//  #Subproblems: O(N)
// 2)Guess: which is the last no used to reach target? k guesses
// 3)Recurrence: f(t) = sum{f(t-x1),f(t-x2)..,f(t-xk)}
// 4)Topological Order: t from 0 to N
// 5)Running time: O(N) * O(k) = O(N*k)
}
