/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 
 * 如果不存在公共前缀，返回空字符串 ""。
*/

/**
 * 解题思路：
 * 1.以第一个字符串为基准，遍历后面的字符串，如果当前字符串的前缀与基准字符串的前缀相同，则继续比较下一个字符，直到不相同为止。
 * 2.KMP算法
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        int count = strs.length;
        int len = strs[0].length();

        //多数组会走以下逻辑
        for(int i=0; i<len; i++){
            Character ch = strs[0].charAt(i);

            for(int j=0; j<count; j++){
                //子字符串边界判断+字符对比
                if(strs[j].length() == i || strs[j].charAt(i) != ch){
                    return strs[0].substring(0, i);
                }
            }
        }
        
        //如果只有一个字符串元素，返回第一个字符
        return strs[0]; 
    }
}