package org.practice.greedy;

public class q763 {

    /*
    Time Complexity: O(N^2)
    Space Complexity: O(N)
     */
    class Solution {
        public List<Integer> partitionLabels(String S) {
            int[] freq = new int[26];
            int len = S.length();
            List<Integer> ans = new ArrayList<>();
            Set<Character> window = new HashSet<>();
            for(char c: S.toCharArray()) {
                freq[c-'a']++;
            }
            // System.out.println(Arrays.toString(freq));

            int start = 0, end = 0;
            while(end < len) {
                window.add(S.charAt(end));
                freq[S.charAt(end) - 'a']--;

                if(freq[S.charAt(end) - 'a'] == 0) {
                    boolean flag = true;
                    for(char c: window) {
                        if(freq[c-'a'] > 0) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        window.clear();
                        ans.add(end-start+1);
                        start = end+1;
                    }
                }
                end++;
                // System.out.println(Arrays.toString(freq));
            }
            return ans;
        }
    }

// ababcbacadefegdehijhklij

// a = 4
// b = 3
// c = 2
// d = 2
// e = 3
// f = 1
// g = 1
// h = 2
// i = 2
// j = 2
// k = 1
// l = 1
}
