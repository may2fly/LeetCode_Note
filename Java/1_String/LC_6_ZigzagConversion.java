/**
 * N 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
    P   A   H   N
    A P L S I I G
    Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
*/

/**
* 解题思路：
* 字形变换时会有一个固定的循环长度，首先获取这个循环长度，根据首尾行的情况算出字符位置，然后计算中间行数的数据.
* 循环长度是2*numRows - 2，Z形中间是cycleLen*n - i
*/
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;  // 特殊情况预处理

        StringBuffer sb = new StringBuffer();
        int cycleLen = 2*numRows - 2;   //循环长度
        int n = s.length();

        for(int i=0; i<numRows; i++){   //以行数为单位进行遍历
            for(int j=0; j+i < n; j+= cycleLen){    //每行字符生成，每次增加一个循环长度
                sb.append(s.charAt(j+i));
                if(i != 0 && i != numRows-1 && cycleLen + j - i < n){//非首尾行，斜行字符位置是cycleLen + j - i
                    sb.append(s.charAt(cycleLen + j - i));
                }
            }
        }

        return sb.toString();
    }
}