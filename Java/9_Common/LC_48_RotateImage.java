/**
 * 48. 旋转图像
 * 
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
*/

/**
 * 解题思路：
 * 1、先上下翻转
 * 2、在以对折线左右翻转
*/
class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        //上下翻转
        for(int i=0; i<m/2; i++){
            for(int j=0; j<n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[m-i-1][j];//注意越界，不要使用上边界M
                matrix[m-i-1][j] = tmp;
            }
        }
        //沿折现翻转
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}