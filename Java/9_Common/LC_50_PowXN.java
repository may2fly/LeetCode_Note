/**
 * 50. Pow(x, n)
 * 
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
*/

// 递归
class Solution {
    public double myPow(double x, int n) {
        //预处理正负值，保证后续计算统一
        return n > 0 ? powHelp(x, n) : 1.0/powHelp(x, -n);
    }

    private double powHelp(double x, int n){
        if(n==0) return 1.0;    //终止条件，N==0时返回

        double r = powHelp(x, n/2); //二分递归，降低计算量

        return n%2 == 0 ? r*r : r*r*x;  //奇偶判断，返回
    }
}