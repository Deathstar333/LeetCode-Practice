package org.practice.greedy;

public class q870 {
    /*
    Time Complexity: O(NlogN)
    Space Complexity: O(N)
     */
    class Solution {
        public int[] advantageCount(int[] A, int[] B) {
            TreeSet<Integer> ts = new TreeSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int a: A) {
                ts.add(a);
                map.put(a, map.getOrDefault(a,0)+1);
            }

            int k = 0;
            for(int b: B) {
                Integer a = ts.higher(b);
                if(a == null) {
                    a = ts.first();
                }
                A[k] = a;
                map.put(a, map.get(a)-1);
                if(map.get(a) == 0) ts.remove(a);
                k++;
            }
            return A;
        }
    }

// B 10 1 4 11
// A 11 2 7 15
}
