package org.practice.bsearch;

public class q392 {
    /*
    Time Complexity: O(T + SlogT)
    Space Complexity: O(T)
     */

    class Solution {
        public boolean isSubsequence(String s, String t) {
            HashMap<Character, List<Integer>> index = new HashMap<>();

            int slen = s.length();
            int tlen = t.length();
            if(slen == 0) return true;
            if(tlen == 0) return false;


            for(int i=0; i<tlen; i++) {
                char c = t.charAt(i);
                List<Integer> list = index.getOrDefault(c, new ArrayList<>());
                list.add(i);
                index.put(c, list);
            }
            // System.out.println(index.toString());

            char c = s.charAt(0);
            if(!index.containsKey(c)) return false;
            List<Integer> list = index.get(c);
            int prev = list.get(0);
            for(int i=1; i<slen; i++) {
                c = s.charAt(i);
                if(!index.containsKey(c)) return false;
                list = index.get(c);
                int curr = Collections.binarySearch(list, prev+1);

                if(curr < 0) curr = -curr-1;
                if(curr == list.size()) return false;
                // System.out.println(curr);

                prev = list.get(curr);
            }

            return true;
        }
    }

// t = abbba
// s = abb

}
