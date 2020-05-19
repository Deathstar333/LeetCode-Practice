package org.practice.arrays;

public class q54 {

    /*
    Time Complexity: O(m*n)
    Space Complexity: O(m*n)
     */
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int rowMin = 0, rowMax = matrix.length;
            List<Integer> ans = new ArrayList<>();
            if(rowMax == 0) return ans;
            int colMin = 0, colMax = matrix[0].length;
            int len = rowMax*colMax;
            int counter = 0;

            int i=rowMin, j=colMin;
            while(rowMin < rowMax && colMin < colMax) {
                // System.out.println(ans.toString());
                //first row
                i = rowMin;
                for( j=colMin; j<colMax; j++) {
                    ans.add(matrix[i][j]);
                    counter++;
                    if(counter == len) return ans;
                }
                rowMin++;

                //last col
                j = colMax-1;
                for( i=rowMin; i<rowMax; i++) {
                    ans.add(matrix[i][j]);
                    counter++;
                    if(counter == len) return ans;
                }
                colMax--;

                //last row
                i = rowMax-1;
                for( j=colMax-1; j>=colMin; j--) {
                    ans.add(matrix[i][j]);
                    counter++;
                    if(counter == len) return ans;
                }
                rowMax--;

                //first col
                j = colMin;
                for( i=rowMax-1; i>=rowMin; i--) {
                    ans.add(matrix[i][j]);
                    counter++;
                    if(counter == len) return ans;
                }
                colMin++;

            }
            return ans;

        }
    }

}
