package org.practice.bit_manipulation;

public class q338 {
    /*
    Time Complexity: O(N)
    Space Complexity: O(N)
     */
    class Solution {
        public int[] countBits(int num) {
            int[] ans = new int[num+1];
            if(num < 1) return ans;

            int ansIter=2, start=1, end=1;
            ans[1] = 1;
            if(num < 2) return ans;
            while(true) {
                for(int j=start; j<=end; j++) {
                    ans[ansIter] = ans[j];
                    ansIter++;
                    if(ansIter > num) return ans;
                }

                for(int j=start; j<=end; j++) {
                    ans[ansIter] = ans[j]+1;
                    ansIter++;
                    if(ansIter > num) return ans;
                }

                start = end+1;
                end = ansIter-1;
            }
        }
    }

// 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16
// 0  1  1  2  1  2  2  3  1  2  2  3  2  3  3  4  1
}
