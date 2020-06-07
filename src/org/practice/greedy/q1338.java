package org.practice.greedy;

public class q1338 {

    /*
    Time Complexity: O(NlogN)
    Space Complexity: O(N)
     */
    class Solution {
        public int minSetSize(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int len = arr.length;
            for(int a: arr) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(map.size(), new myComp());
            for(int k: map.keySet()) {
                pq.add(map.get(k));
            }

            int ans = 0;
            int count = 0;
            while(count < len/2) {
                count += pq.poll();
                ans++;
            }
            return ans;
        }
    }

    class myComp implements Comparator<Integer> {

        public int compare(Integer i1, Integer i2) {
            return i2 - i1;
        }

    }
}
