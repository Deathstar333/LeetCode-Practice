package org.practice.arrays;

public class q3 {

    /*
    Time Complexity = O(2*L) = O(L)
    Space Complexity = O(min(L,m))
    where L is len of string
    and m is size of charset(26 for 'a'-'z', 128 for ASCII etc.)
     */
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int slen = s.length();
            if(slen == 0) return 0;
            int begin=0, end=0;
            int ans = 1;
            while(end < slen) {
                //System.out.println(map.toString());
                char c = s.charAt(end);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.get(c) == 1) ans = Math.max(ans, end-begin+1);
                end++;
                while(begin < end && map.get(c) > 1) {
                    char d = s.charAt(begin);
                    map.put(d, map.get(d)-1);
                    begin++;
                }
            }
            return ans;
        }
    }
}
