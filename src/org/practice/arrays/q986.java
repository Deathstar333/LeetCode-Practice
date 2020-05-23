package org.practice.arrays;

public class q986 {

    /*
    Time Complexity: O(M+N)
    Space Complexity: O(M+N)
     */
    class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            int lenA = A.length;
            int lenB = B.length;
            if(lenA == 0 || lenB == 0) return new int[0][0];
            List<List<Integer>> arr = new ArrayList<List<Integer>>();

            int j = 0, i = 0;
            while(j < lenA && i <lenB) {
                int lb = B[i][0], hb = B[i][1];
                if(A[j][1] < lb) {
                    j++;
                    continue;
                }

                if(hb < A[j][0]) {
                    i++;
                    continue;
                }

                if(A[j][0] < lb && A[j][1] <= hb) {
                    arr.add(new ArrayList<>(Arrays.asList(lb,A[j][1])));
                    j++;
                    continue;
                }
                if(A[j][0] >= lb && A[j][1] <= hb) {
                    arr.add(new ArrayList<>(Arrays.asList(A[j][0],A[j][1])));
                    j++;
                    continue;
                }
                if(A[j][0] >= lb && A[j][1] > hb){
                    arr.add(new ArrayList<>(Arrays.asList(A[j][0],hb)));
                    i++;
                    continue;
                }
                if(A[j][0] < lb && A[j][1] > hb){
                    arr.add(new ArrayList<>(Arrays.asList(lb,hb)));
                    i++;
                    continue;
                }

            }

            int len = arr.size();
            int[][] ans = new int[len][2];
            for(int k=0; k<len; k++) {
                ans[k][0] = arr.get(k).get(0);
                ans[k][1] = arr.get(k).get(1);
            }
            return ans;
        }
    }

// [0,2],[5,10],[13,23],[24,25]
// [1,5],[8,12],[15,24],[25,26]

// ------
//    -----

//  -----
// -------

//      -----
//   -----

// -------
//   ----


}
