package org.practice.greedy;

public class q1282 {
    /*
    Time Complexity: O(N)
    Space Complexity: O(N)
     */
    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            int n = groupSizes.length;
            for(int i=0; i<n; i++) {
                List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<Integer>());
                list.add(i);
                map.put(groupSizes[i], list);
            }
            // System.out.println(map.toString());
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            for(int k: map.keySet()) {
                List<Integer> list = map.get(k);
                int i=0;
                while(i < list.size()) {
                    List<Integer> arr = new ArrayList<Integer>();
                    for(int j=0; j<k; j++) {
                        arr.add(list.get(i));
                        i++;
                    }
                    ans.add(arr);
                }

            }
            return ans;
        }
    }
}
