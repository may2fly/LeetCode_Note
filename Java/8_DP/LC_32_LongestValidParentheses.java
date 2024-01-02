/**
 * 32. 最长有效括号
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
*/

/**
 * 解题思路
 * 1. 动态规划
 * 2. 栈
*/
class Solution {
    /**
     * 动态规划：有效的子串一定以 ‘)’结尾，求其位置对应的值。每两个字符检查一次
     * 1、s[i]=‘)’ 且 s[i−1]=‘(’则是"...()", 转移公式dp[i] = dp[i−2] + 2;
     * 2、s[i]=‘)’ 且 s[i−1]=‘)’字符串形如“……))”，如果s[i−dp[i−1]−1]=‘(’则转移公式如下：
     * dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
    */
    public int longestValidParentheses(String s) {
        int maxAns = 0;

        int[] dp = new int[s.length()];

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == ')'){
                if(s.charAt(i-1) == '('){
                    dp[i] = (i>=2 ? dp[i-2] : 0) + 2;
                }else if(i-dp[i-1] > 0 && s.charAt(i-dp[i-1]-1) =='('){
                    dp[i] = dp[i-1] + ((i-dp[i-1])>=2 ? dp[i-dp[i-1]-2] : 0) + 2;
                }   
            }

            maxAns = Math.max(maxAns, dp[i]);
        }

        return maxAns;
    }

/**
 * 栈的解法：保留栈底元素，计算满足条件的max值
 * 始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」
*/
    public int longestValidParentheses(String s) {
        int max = 0;

        Stack<Integer> stack = new Stack<>();

        stack.push(-1); //保存初始栈底元素
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){//左括号
                stack.push(i);
            }else{
                stack.pop();    //右括号，推出

                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max, i-stack.peek());
                }
            }
        }

        return max;
    }
}
