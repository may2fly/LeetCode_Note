/**
 * 66. 加一
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
*/

/**
 * 解题思路：
 * 1. 倒序遍历数组，找到第一个不为9的元素，将其加1，其余元素置为0
*/
class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return new int[0];

        int n = digits.length;

        for(int i=n-1; i>=0; i--){
            if(digits[i] != 9){
                digits[i] += 1;
                for(int j=i+1; j<n; j++){
                    digits[j] = 0;
                }
                return digits;
            }
        }

        int[] res = new int[n+1];
        res[0] = 1;

        return res;
    }
}