/**
 * 38. 外观数列
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
*/
class Solution {
    public String countAndSay(int n) {
        String str = "1";

        for(int i=2; i<=n; i++){
            StringBuffer sb = new StringBuffer();

            int start = 0, pos = 0, len = str.length();
            while(start < len){

                while(pos < len && str.charAt(start) == str.charAt(pos)){
                    pos++;
                }
                sb.append(Integer.toString(pos-start)).append(str.charAt(start));
                start = pos;    //更新起始位置
            }

            str = sb.toString();
        }

        return str;
    }
}