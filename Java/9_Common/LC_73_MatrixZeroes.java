/**
 * 73. 矩阵置零
 * 
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
*/

/**
 * 解题思路：
 * 1、定义rows和cols数组，记录每一行和每一列是否有0
 * 2、遍历矩阵，如果当前元素为0，则将rows[i]和cols[j]置为1
 * 3、遍历矩阵，如果当前行或列有0，则将其置为0
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[] rows = new int[m];
        int[] cols = new int[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(rows[i] == 1 || cols[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}