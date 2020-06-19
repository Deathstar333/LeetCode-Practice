package org.practice.arrays;

public class q275 {

    /*
    Time Complexity:O(logN)
    Space Complexity: O(1)
     */
    class Solution {
        public int hIndex(int[] citations) {
            int len = citations.length;
            int low = 0, high = len-1;
            while(low <= high) {
                int mid = low + (high-low)/2;
                if(citations[mid] < (len-mid)) {
                    low = mid + 1;
                }
                else high = mid - 1;
            }
            return len-low;
        }
    }
}
