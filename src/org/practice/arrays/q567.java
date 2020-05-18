package org.practice.arrays;

public class q567 {
    /*
    Time Complexity: O(L)
    Space Complexity: O(min(tlen,26))
     */
    class Solution {
        public boolean checkInclusion(String t, String s) {
            boolean ans = false;
            int tlen = t.length();
            int slen = s.length();
            if(slen < tlen) return ans;

            HashMap<Character, Integer> map = new HashMap<>();
            for(char c: t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int counter = map.size();
            int begin=0, end=0;
            while(end < slen) {
                if(ans) break;
                char c = s.charAt(end);
                if(map.containsKey(c)) {
                    map.put(c, map.get(c) - 1);
                    if(map.get(c) == 0) counter--;
                }
                end++;

                while(counter == 0) {
                    char d = s.charAt(begin);
                    if(map.containsKey(d)) {
                        map.put(d, map.get(d) + 1);
                        if(map.get(d) > 0) counter++;
                    }

                    if(end-begin == tlen) ans = true;
                    begin++;
                }

            }
            return ans;

        }
    }
}
