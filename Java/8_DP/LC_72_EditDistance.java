/**
 * 72. 编辑距离(高->中)
 * 
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 
 * 你可以对一个单词进行如下三种操作：插入一个字符、删除一个字符、替换一个字符
*/

/**
 * 解题思路：
 * 动态规划，
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        //预处理，一个字符串为空，需操作次数为另一个字符串的长度
        if(n*m == 0) return n+m;

        //动态规划数组，初始化数组大小
        int[][] dp = new int[n+1][m+1];

        //边界值初始化
        for(int i=0; i<n+1; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<m+1; j++){
            dp[0][j] = j;
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                int left = dp[i-1][j] + 1;
                int down = dp[i][j-1] + 1;
                int left_down = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    left_down += 1;
                }

                //动态转移公式，
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        
        return dp[n][m];
    }
}