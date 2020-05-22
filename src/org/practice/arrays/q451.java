package org.practice.arrays;

public class q451 {
    /*
    Time Complexity: O(N)
    Space Complexity: O(N)
     */
    class Solution {
        public String frequencySort(String s) {
            int len = s.length();
            if(len == 0) return "";
            int[] map = new int[128];
            for(char c: s.toCharArray()) {
                map[c - '\u0000']++;
            }
            // System.out.println(Arrays.toString(map));
            PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(new SortByFreq());
            for(int i=0; i<128; i++) {
                if(map[i] != 0) {
                    pq.add(new Pair((char) i, map[i]));
                }
            }

            StringBuilder ans = new StringBuilder();
            while(!pq.isEmpty()) {
                Pair<Character, Integer> p = pq.poll();
                for(int i=0; i<p.getValue(); i++) {
                    ans.append(p.getKey());
                }
            }
            return ans.toString();
        }

        class SortByFreq implements Comparator<Pair<Character, Integer>> {

            public int compare(Pair<Character, Integer> p1, Pair<Character, Integer> p2) {
                return p2.getValue() - p1.getValue();
            }
        }
    }
}
