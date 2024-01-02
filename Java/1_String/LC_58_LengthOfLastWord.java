/**
 * 58. 最后一个单词的长度
 * 
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
*/
class Solution {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length() == 0) return 0;

        int len = s.length()-1;
        //边界条件处理，避免越界
        while(len>=0 && s.charAt(len) == ' '){
            len--;
        }

        int end = len;
        //边界条件处理，避免越界
        while(len >= 0 && s.charAt(len) != ' '){
            len--;
        }

        return end - len;
    }
}