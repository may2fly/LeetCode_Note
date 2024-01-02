/**
 * 59. 螺旋矩阵 II
 * 
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
*/
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int top = 0, bottom = n-1, left = 0, right = n-1;
        int num = 1;

        while(top<=bottom && left<=right){
            for(int cols = left; cols<=right; cols++){
                result[top][cols] = num;
                num++;
            }
            for(int rows = top+1; rows<=bottom; rows++){
                result[rows][right] = num;
                num++;
            }

            if(top < bottom && left < right){   //越界条件判断，居中位置
                for(int cols = right-1; cols > left; cols--){
                    result[bottom][cols] = num;
                    num++;
                }

                for(int rows = bottom; rows>top; rows--){
                    result[rows][left] = num;
                    num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        return result;
    }
}