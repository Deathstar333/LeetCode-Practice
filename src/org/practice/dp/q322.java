package org.practice.dp;

public class q322 {
    /*
    Time Complexity: O(N*k)
    Space Complexity: O(N)
     */
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if(amount == 0) return 0;
            int[] dp = new int[amount+1];
            for(int i=0; i<=amount; i++) {
                // System.out.println(Arrays.toString(dp));
                int min = Integer.MAX_VALUE;
                for(int coin: coins) {
                    if(i - coin < 0) continue;
                    if(i - coin == 0) {
                        min = 1;
                        break;
                    }
                    if(dp[i-coin] == 0) continue;
                    min = Math.min(min, dp[i - coin] + 1);
                }
                if(min == Integer.MAX_VALUE) continue;
                dp[i] = (min == 0) ? 0: min;
            }
            // System.out.println(Arrays.toString(dp));
            return (dp[amount] == 0) ? -1: dp[amount];
        }
    }

// 1) Subproblem: Amount N
// #Subproblems: O(N)
// 2) Guess: which coin to use? k+1 options
// 3) Recurrence : f(N) = Math.min(f(N-x1),..,f(N-xk)) + 1;
// 4) Topological order: i from 0 to N
//                         for each coin in coins[]
// 5) Time taken = O(N)*O(k) = O(Nk)
}
