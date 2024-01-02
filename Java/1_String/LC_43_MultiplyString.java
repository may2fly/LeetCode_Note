/**
 * 43. 字符串相乘
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
*/

/**
 * 解题思路：
 * 1. 先将两个字符串反转，然后从后往前遍历，相乘，最后将结果反转
*/

class Solution {
    public String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2)) return "0";

        int len1 = num1.length(), len2 = num2.length();
        int[] ans = new int[len1+len2];

        //字符串Num倒序遍历，与字符串Num2倒序相乘获取结果保存在ans中，循环相加
        for(int i=len1-1; i>=0; i--){
            int v1 = num1.charAt(i) - '0';

            for(int j=len2-1; j>=0; j--){
                int v2 = num2.charAt(j) - '0';
                int sum = ans[i+j+1] + v1*v2;
                ans[i+j+1] =  sum%10;
                ans[i+j] += sum/10;
            }
        }

        StringBuffer sb = new StringBuffer();
        //去除前导0，拼接字符串
        for(int i=0; i<ans.length; i++){
            if(i==0 && ans[i] == 0) continue;
            sb.append(ans[i]);
        }

        return sb.toString();
    }
}