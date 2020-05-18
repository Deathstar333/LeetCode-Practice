package org.practice.arrays;

public class q438 {
    /*
    Time Complexity: O(26*L)
    Space Complexity: O(1)
     */

    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int[] pChars = new int[26];
            int[] sChars = new int[26];
            List<Integer> ans = new ArrayList<>();
            for(char c: p.toCharArray())
                pChars[c-'a']++;
            int slen = s.length();
            int plen = p.length();
            if(slen == 0 || plen > slen) return ans;
            for(int i=0; i<plen; i++)
                sChars[s.charAt(i)-'a']++;
            if(isAnagram(sChars, pChars))
                ans.add(0);

            for(int i=plen; i<slen; i++) {
                sChars[s.charAt(i-plen)-'a']--;
                sChars[s.charAt(i)-'a']++;
                if(isAnagram(sChars, pChars))
                    ans.add(i-plen+1);
            }
            return ans;
        }

        public boolean isAnagram(int[] sChars, int[] pChars) {
            for(int i=0; i<26; i++) {
                if(sChars[i] != pChars[i])
                    return false;
            }
            return true;
        }
    }
}
