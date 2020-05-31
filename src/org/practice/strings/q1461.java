package org.practice.strings;

public class q1461 {
    /*
    Time Complexity: O(N)
    Space Complexity: O(2^k * k)
     */
    class Solution {
        public boolean hasAllCodes(String s, int k) {
            HashSet<String> set = new HashSet<String>();
            int target = (int)Math.pow(2, k);
            int len = s.length();
            for(int i=0; i <= len-k; i++) {
                set.add(s.substring(i,i+k));
                if(set.size() == target)
                    return true;
            }
            return (set.size() == target);
        }
    }
}
