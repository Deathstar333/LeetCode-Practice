package org.practice.data_structure;

public class q239 {
    /*
    Time Complexity: O(N)
    Space Complexity: O(N)
     */
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            minQueue mq = new minQueue();
            int len = nums.length;
            int ans[] = new int[len-k+1];
            int i,j;
            for(i=0; i<k; i++) {
                mq.add(nums[i]);
            }
            ans[0] = mq.getMax();
            i=1;
            for(j=k; j<len; j++, i++) {
                mq.add(nums[j]);
                mq.remove(nums[i-1]);
                ans[i] = mq.getMax();
            }
            return ans;
        }
    }

    class minQueue {
        Deque<Integer> dq;
        public minQueue() {
            dq = new ArrayDeque<Integer>();
        }

        public void add(int x) {
            while(!dq.isEmpty() && dq.peekLast() < x)
                dq.pollLast();
            dq.offerLast(x);
        }

        public void remove(int x) {
            if(dq.peekFirst() == x)
                dq.pollFirst();
        }

        public int getMax() {
            return dq.peekFirst();
        }
    }

// nums = 1  3 -1 -3  5  3  6  7
//        0  1  2  3  4  5  6  7
}
