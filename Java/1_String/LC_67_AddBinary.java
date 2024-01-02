/**
 * 67. 二进制求和
 * 
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
*/

class Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();

        int m = a.length() - 1, n = b.length()-1;
        int carry = 0;
        while(m>=0 || n >=0){
            //注意字符串与数字转换
            int va = m >= 0 ? a.charAt(m) - '0' : 0;
            int vb = n >= 0 ? b.charAt(n) - '0' : 0;
            int sum = va + vb + carry;

            sb.append(sum%2);   //StringBuffer可以直接添加数字
            carry = sum/2;

            m--;
            n--;
        }
        if(carry != 0){
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}