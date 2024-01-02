/**
 * 74. 搜索二维矩阵
 * 给你一个满足下述两条属性的 m x n 整数矩阵:
 * 1、每行中的整数从左到右按非严格递增顺序排列
 * 2、每行的第一个整数大于前一行的最后一个整数
 * 
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
*/
class Solution {
    /**
     * 二分查找，列数为基准，计算中间位置，取值时
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = m*n-1;

        while(left <= right){
            int mid = left + (right-left)/2;
            //取值时，注意是对列出取正与取余
            int x = matrix[mid/n][mid%n];
            if(x == target){
                return true;
            }else if(x < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return false;
    }
}