/**
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */

/**
 * 中心扩展算法：
 * 枚举所有的「回文中心」并尝试「扩展」，直到无法扩展为止，此时的回文串长度即为此「回文中心」下的最长回文串长度。
 * 时间复杂度：O(n^2)
 )
*/
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";

        int start = 0, end = 0;
        for(int i=0; i<s.length(); i++){
            int len1 = expandCenter(s, i, i);
            int len2 = expandCenter(s, i, i+1);
            //获取最大的回文长度
            int len = Math.max(len1, len2);

            if(end - start < len){//与已记录的长度做对比
                end = i + len/2;    
                start = i - (len-1)/2;
            }
        }
        return s.substring(start, end+1);
    }

    public int expandCenter(String s, int left, int right){
        int L = left, R = right;

        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        return R - L - 1;   //注意，字符串相同才移动，单个字符的长度是-1，后续截断时做处理
    }
}