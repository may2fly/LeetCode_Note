/**
 * 54. 螺旋矩阵
 * 
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
*/

/**
 * 解题思路：
 * 1. 先确定矩阵的边界，然后按照螺旋的顺序遍历矩阵，每一次遍历都将一个元素从矩阵中取出来，放入结果数组中
*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }

        int m = matrix.length, n = matrix[0].length;

        int top = 0, bottom = m-1, left = 0, right = n - 1;

        //上下左右条件都需要判断
        while(top <= bottom && left<=right){
            for(int i=left; i<=right; i++){
                result.add(matrix[top][i]);
            }

            for(int j = top+1; j<=bottom; j++){
                result.add(matrix[j][right]);
            }

            if(left<right && top<bottom){   //内循环要判断是否满足条件
                for(int i = right-1; i>left; i--){
                    result.add(matrix[bottom][i]);
                }

                for(int i=bottom; i>top; i--){
                    result.add(matrix[i][left]);
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