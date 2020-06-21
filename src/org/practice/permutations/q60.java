package org.practice.permutations;

public class q60 {

    /*
    Time Complexity: O(N^2)
    Space Complexity: O(N)
     */
    class Solution {
        public String getPermutation(int n, int k) {
            int arr[] = new int[n+1];
            int fact[] = new int[n+1];
            fact[0] = 1;
            for(int i=1; i<=n; i++) {
                arr[i] = 1;
                fact[i] = fact[i-1] * i;
            }
            int len = n;
            StringBuilder sb = new StringBuilder();
            while(n > 0) {
                int x = k / fact[n-1];
                if(k % fact[n-1] == 0) x--;
                // System.out.println("k,n,x: " + k + "," + n + "," + x);
                if(k > fact[n-1]) k = (k%fact[n-1] == 0) ? fact[n-1] : k%fact[n-1];
                n--;
                for(int i=1; i<=len; i++) {
                    if(arr[i] == 0) continue;
                    if(x == 0) {
                        sb.append(i);
                        arr[i] = 0;
                        break;
                    }
                    x--;
                }
            }

            for(int i=1; i<=len; i++) {
                if(arr[i] != 0) sb.append(i);
            }
            return sb.toString();
        }
    }
}
