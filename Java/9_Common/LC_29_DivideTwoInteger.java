/**
 * 29. 两数相除
 * 给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
*/

/**
 * 解题思路：
 * 1.使用移位做操作，使用负数避免边界值处理
*/

class Solution {
    public int divide(int dividend, int divisor) {
        // 符号，除数与被除数是否符号一致
        boolean sign = (dividend > 0) ^ (divisor > 0);
        
        //对除数与被除数做负值处理
        if(dividend > 0) dividend = -dividend;
        if(divisor > 0) divisor = -divisor;

        int result = 0;//结果定义

        //因为是负数，所以dividend需要小于divisor
        while(dividend <= divisor){
            int tmp_result = -1;
            int tmp_dividend = divisor;

            //获取到最大值
            while(dividend < (tmp_dividend << 1)){
                ////边界条件处理
                if(tmp_dividend <= (Integer.MIN_VALUE >> 1)) break;

                tmp_dividend = tmp_dividend << 1;
                tmp_result = tmp_result << 1;
            }

            dividend = dividend - tmp_dividend;
            result += tmp_result;
        }

        if(!sign){
            //这里直接返回
            if(result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;

            result = -result;
        }
        return result;
    }
}