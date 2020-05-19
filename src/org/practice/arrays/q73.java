package org.practice.arrays;

public class q73 {

    /*
    Time Complexity:O(mn)
    Space Complexity: O(1)
     */

    class Solution {
        public void setZeroes(int[][] matrix) {
            int row = matrix.length;
            int col = matrix[0].length;
            int i=0, j=0;
            boolean isRow = false;
            boolean isCol = false;
            for(i=0; i<row; i++) {
                for(j=0; j<col; j++) {
                    if(matrix[i][j] == 0) {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                        if(!isRow && i== 0) isRow = true;
                        if(!isCol && j== 0) isCol = true;
                    }
                }
            }
            // for(int[] x: matrix)
            //     System.out.println(Arrays.toString(x));

            for(i=1; i<row; i++) {
                for(j=1; j<col; j++) {
                    if(matrix[i][0] == 0 || matrix[0][j] == 0)
                        matrix[i][j] = 0;
                }
            }
            if(matrix[0][0] == 0) {
                i=0;
                j=0;
                if(isCol) {
                    while(i<row) {
                        matrix[i][j] = 0;
                        i++;
                    }
                }
                i=0;
                if(isRow) {
                    while(j<col) {
                        matrix[i][j] = 0;
                        j++;
                    }
                }
            }

        }
    }
}
