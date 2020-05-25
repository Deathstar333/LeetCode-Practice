package org.practice.dp;

public class q1035 {
    /*
    Time Complexity: O(N^2)
    Space Complexity: O(N^2)
     */
    class Solution {
        public int maxUncrossedLines(int[] A, int[] B) {
            int lenA = A.length;
            int lenB = B.length;
            int[][] dp = new int[lenA+1][lenB+1];
            for(int i=lenA-1; i>=0; i--) {
                for(int j=lenB-1; j>=0; j--) {
                    if(A[i] == B[j])
                        dp[i][j] = dp[i+1][j+1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
            return dp[0][0];
        }
    }

// 1) Subproblem : Suffix [i:] of Str A and Suffix [j:] of Str B
//    #Subproblems: O(N^2)
// 2) Guess : a)if both num match ans+1
//            b)if A[i] != A[j] progress both and take max
// 3) Recursion : dp(i,j) = {
//                             dp[i+1][j+1] + 1                    if A[i] == B[j]
//                             Math.max(dp[i+1][j], dp[i][j+1])    otherwise
//                         }
// 4) Topological Order: smallest to largest
//                         i from lenA-1 to 0
//                         j from lenB-1 to 0
// 5) Running Time = #Subproblems * Time/Subproblem = O(N^2) * O(1) = O(N^2)


}
