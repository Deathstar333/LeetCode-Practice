package org.practice.dp;

public class q279 {

    /*
    Time Complexity: O(N^2)
    Space Complexity: O(N)
     */
    class Solution {
        public int numSquares(int n) {
            if(n < 1) return 0;
            int[] dp = new int[n+1];
            Arrays.fill(dp, n+1);
            dp[0] = 0;
            dp[1] = 1;
            for(int i=0; i<=n; i++) {
                for(int j=1; j*j <= i; j++) {
                    dp[i] = Math.min(dp[i], dp[i-(j*j)] + 1);
                }
            }
            return dp[n];
        }
    }

// 1)Subproblems: min squares to reach target t where t is in [0,N]
//     #Subproblems: O(N)
// 2)Guess: which is the last square in the combination? sqrt(t) guesses
// 3)Recurrence: f(t) = Math.min(f(t-1),f(t-4),...,f(t-sqrt(t)))+1
// 4)Topological order: t from 0 to N
// 5)Running time: O(N) * sum(1,2,...,sqrt(N)) = O(N^2)
}
