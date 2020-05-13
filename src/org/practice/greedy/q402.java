package org.practice.greedy;

public class q402 {
    /*
        Time Complexity = O(N) Since,every element gets added and removed from stack max 1 time each
        Space Complexity = O(N)
     */
    static class Solution {
        public String removeKdigits(String num, int k) {
            Deque<Character> stk = new ArrayDeque<>();
            int len = num.length();
            for(int i=0; i<len; i++) {
                if(stk.isEmpty()) stk.offer(num.charAt(i));
                else {
                    while(!stk.isEmpty() && k>0 && num.charAt(i)<stk.peekLast()) {
                        stk.pollLast();
                        k--;
                    }
                    stk.offer(num.charAt(i));
                }
                //System.out.println(stk.toString());
            }
            while(k>0) {
                stk.pollLast();
                k--;
            }
            while(!stk.isEmpty() && stk.peek() == '0') stk.pollFirst();
            if(stk.isEmpty()) return "0";
            StringBuilder sb = new StringBuilder();
            while(!stk.isEmpty()) {
                sb.append(stk.pollFirst());
            }
            return sb.toString();
        }
    }
}
