package org.practice.dp;

public class q368 {

    /*
    Time Complexity: O(N^2)
    Space Complexity: O(N)
     */
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            List<Integer> result = new ArrayList<>();
            int len = nums.length;
            if(len < 1) return result;
            int[] dp = new int[len];
            Arrays.fill(dp, 1);
            Arrays.sort(nums);

            Map<Integer, Integer> map = new HashMap<>();
            for(int x: nums) map.put(x, x);

            int maxIndex = 0, max = 0;
            for(int i=1; i<len; i++) {
                int div = 0, count = 0;
                for(int j=0; j<i; j++) {
                    if(nums[i]%nums[j] == 0 && dp[j] > count) {
                        div = nums[j];
                        count = dp[j];
                    }
                }
                dp[i] = count + 1;
                if(dp[i] > max) {
                    max = dp[i];
                    maxIndex = i;
                }
                map.put(nums[i], (div == 0) ? nums[i]:div);
            }

            // System.out.println(Arrays.toString(dp));
            // System.out.println(map.toString());
            // System.out.println(max);
            // System.out.println(maxIndex);

            int elem = nums[maxIndex];
            result.add(elem);
            while(map.get(elem) != elem) {
                elem = map.get(elem);
                result.add(elem);
            }

            return result;
        }
    }
}
