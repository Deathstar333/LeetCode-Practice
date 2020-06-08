package org.practice.greedy;

public class q1400 {

    /*
    Time Complexity: O(N)
    Space Complexity: O(1)
     */
    class Solution {
        public boolean canConstruct(String s, int k) {
            int len = s.length();
            if(len < k) return false;
            if(len == k) return true;
            int[] freq = new int[26];
            for(char c: s.toCharArray()) {
                freq[c-'a']++;
            }

            int odd = 0;
            for(int f: freq) {
                if(f % 2 != 0) odd++;
            }

            if(k < odd) return false;
            return true;
        }
    }

// annabelle
// a = 2
// b = 1
// n = 2
// e = 2
// l = 2

// leetcode
// l = 1
// e = 3
// t = 1
// c = 1
// o = 1
// d = 1
}
