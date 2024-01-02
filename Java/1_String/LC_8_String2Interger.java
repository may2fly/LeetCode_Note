/**
 * 字符串转换整数 (atoi)
 * 函数 myAtoi(string s) 的算法如下：
 * 1.读入字符串并丢弃无用的前导空格
 * 
 * 2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 
 * 3.读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 
 * 4.将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 
 * 5.如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 
 * 6.返回整数作为最终结果。
*/

class Solution {
    public int myAtoi(String s) {
        if(s == null || s.length() == 0) return 0;//空字符处理

        int index = 0;
        int len = s.length();
        //1. 丢弃前导空格
        while(index < len && s.charAt(index) == ' '){
            index++;
        }

        if(index == len) return 0;  //空字符处理

        //2. 处理符号
        int sign = 1;
        if(s.charAt(index) == '+'){
            sign = 1;
            index++;
        }else if(s.charAt(index) == '-'){
            sign = -1;
            index++;
        }

        //3. 处理数字
        int res = 0;
        while(index < len){
            Character ch = s.charAt(index);

            if(ch > '9' || ch < '0')  break;    //非数字处理

            //下边界处理，注意最小值取余然后取正，-优先级大于%，所以需要添加()保证优先级
            if(res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && (ch-'0') > -(Integer.MIN_VALUE%10))){
                return Integer.MIN_VALUE;
            }
            //上边界处理
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && (ch-'0') > Integer.MAX_VALUE%10)){
                return Integer.MAX_VALUE;
            }

            res = res*10 + (ch-'0')*sign;
            index++;    //移位操作
        }

        return res;
    }
}