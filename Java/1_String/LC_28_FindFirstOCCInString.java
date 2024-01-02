/**
 * 28. 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
*/

/**
 * 解题思路：
 * 1. 暴力解法：枚举原串中的每个字符作为「发起点」，每次从原串的「发起点」和匹配串的「首位」开始尝试匹配。复杂度为O(m*n)
 * 2. KMP算法：前缀函数，复杂度为O(m+n)
*/

class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        
        //遍历字符串，然后比对子字符串是否匹配，
        for(int i=0; i<=n-m; i++){
            int a = i, b = 0;//重新定义子循环中的遍历坐标
            //子字符串长度为终止条件，检查字符串是否匹配
            while(b<m && haystack.charAt(a) == needle.charAt(b)){
                a++;
                b++;
            }

            if(b==m) return i;
        }

        return -1;
    }

/**
 * KMP解法:
 * 求解前缀函数:增量算法,一边读入字符串，一边求解当前读入位的前缀函数。
*/
    public int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if(m==0) return 0;

        //求needle部分的前缀函数，保存到数组中
        int[] pi = new int[m]; 
        for(int i=1, j=0; i<m; i++){
            while(j>0 && needle.charAt(i) != needle.charAt(j)){
                j = pi[j-1];
            }

            if(needle.charAt(i) == needle.charAt(j)){
                j++;
            }
            pi[i] = j;
        }

        //求haystack的前缀函数，无须保留。使用变量j做几路，然后与pi数组做对比
        //当某个位置的前缀函数值等于m时，说明我们就找到了一次字符串needle在字符串haystack中的出现
        for(int i=0, j=0; i<n; i++){
            while(j>0 && haystack.charAt(i) != needle.charAt(j)){
                j = pi[j-1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == m){
                return i-m+1;
            }
        }

        return -1;
    }

}