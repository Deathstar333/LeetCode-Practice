package org.practice.arrays;

public class q76 {

    /*
    Time Complexity: O(N)
    Space Complexity: O(1)
     */
    class Solution {
        public String minWindow(String s, String t) {
            String ans = "";
            int startIndex = 0, endIndex = 0;
            if(t.length() > s.length()) return ans;

            HashMap<Character, Integer> map = new HashMap<>();
            for(char c: t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int counter = map.size();
            int begin=0, end=0;
            int len = Integer.MAX_VALUE;

            while(end < s.length()) {

                char c = s.charAt(end);
                if(map.containsKey(c)) {
                    map.put(c, map.get(c)-1);
                    if(map.get(c) == 0) counter--;
                }
                end++;

                while(counter == 0) {
                    char d = s.charAt(begin);
                    if(map.containsKey(d)) {
                        map.put(d, map.get(d)+1);
                        if(map.get(d) > 0) counter++;
                    }
                    if(end-begin+1 < len) {
                        len = end-begin+1;
                        startIndex = begin;
                        endIndex = end;
                    }
                    begin++;
                }
            }
            ans = s.substring(startIndex, endIndex);
            return ans;
        }
    }
}
