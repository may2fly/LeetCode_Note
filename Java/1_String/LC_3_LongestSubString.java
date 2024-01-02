/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
*/

/*
解题思路：
1. 双指针法
2. 滑动窗口法
*/

class Solution {
    /*滑动窗口法:
    * 1、定义一个Set容器，保存滑动窗口的字符
    * 1、定义窗口左边界，边界变动时移除非滑动窗口的字符 
    * 2、不断移动滑动窗口右边界，当出现重复字符时结束
    * 3、不断移动窗口，获取滑动窗口的最大值
    */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        HashSet<Character> occ = new HashSet<>();
        int rk = 0, ans = 0;

        for(int i=0; i<n; i++){
            if(i>0) occ.remove(s.charAt(i-1));//左窗口边界挪动处理

            //右窗口边界处理
            while(rk < n && !occ.contains(s.charAt(rk))){
                occ.add(s.charAt(rk));
                rk++;
            }
            //保存窗口最大值
            ans = Math.max(rk-i, ans);
        }

        return ans;
    }
}