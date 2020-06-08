package org.practice.greedy;

public class q1296 {
    /*
    Time Complexity: O(NlogN)
    Space Complexity: O(N)
     */
    class Solution {
        public boolean isPossibleDivide(int[] nums, int k) {
            Map<Integer, Integer> map = new LinkedHashMap<>();
            int len = nums.length;
            Arrays.sort(nums);
            if(len%k != 0) return false;
            for(int x: nums) {
                map.put(x, map.getOrDefault(x, 0) + 1);
                // int f = map.get(x);
                // if(f > (len/k)) return false;
            }
            // System.out.println(map.toString());
            Iterator<Integer> iter = map.keySet().iterator();
            while(iter.hasNext()) {
                int x = iter.next();
                while(map.get(x) > 0) {
                    for(int i=0; i<k; i++) {
                        if(map.getOrDefault(x+i, 0) == 0) return false;
                        map.put(x+i, map.get(x+i) - 1);
                    }
                }
            }
            return true;
        }
    }
}
