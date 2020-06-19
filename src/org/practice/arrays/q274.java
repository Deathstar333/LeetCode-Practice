package org.practice.arrays;

public class q274 {

    /*
    Time Complexity: O(N)
    Space Complexity: O(1)
     */
    class Solution {
        public int hIndex(int[] citations) {
            int len = citations.length;
            Arrays.sort(citations);
            int i, j;
            for(i=len-1,j=1; i>=0; i--,j++) {
                if(citations[i] < j) break;
            }
            return j-1;
        }
    }
}
