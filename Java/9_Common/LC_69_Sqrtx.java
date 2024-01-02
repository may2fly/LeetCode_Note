/**
 * 69. x 的平方根 
 * 
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 
 * 
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
*/

/**
 * 二分法查找
*/

class Solution {
    public int mySqrt(int x) {
        int left = 1, right = x;

        while(left <= right){
            int mid = left + (right-left)/2;

            if(mid < x/mid){
                left = mid + 1;
            }else if(mid > x/mid){
                right = mid - 1;
            }else{
                return mid;
            }
        }

        //要返回right值，left值是上边界，right值是下边界
        return right;
    }
}