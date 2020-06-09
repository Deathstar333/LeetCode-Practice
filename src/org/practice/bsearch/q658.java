package org.practice.bsearch;

public class q658 {

    /*
    Time Complexity: O(k + logN)
    Space Complexity: O(1)
     */
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int len = arr.length;
            if(k == len) {
                ArrayList<Integer> ans = new ArrayList<Integer>();
                for(int a: arr) ans.add(a);
                return ans;
            }

            List<Integer> ans = new ArrayList<Integer>();
            int right = Arrays.binarySearch(arr, x);
            if(right < 0) right = -right-1;
            int left = right-1;

            while(k > 0 && left >= 0 && right < len) {
                int leftdiff = Math.abs(arr[left] - x);
                int rightdiff = Math.abs(arr[right] - x);
                if(leftdiff <= rightdiff) {
                    left--;
                }
                else {
                    right++;
                }
                k--;
            }

            while(k > 0 && left >= 0) {
                k--;
                left--;
            }

            while(k > 0 && right < len) {
                k--;
                right++;
            }

            left = left+1;
            right = right-1;
            for(int i=left; i<=right; i++) {
                ans.add(arr[i]);
            }
            return ans;
        }
    }
}
