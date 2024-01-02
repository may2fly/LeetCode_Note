/**
 * 回文数:
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
*/

class Solution {
    public boolean isPalindrome(int x) {
        //负数、末尾是0的肯定不是回文，预处理
        if(x<0 || (x!=0 && x%10 == 0)) return false;

        int palNum = 0;

        //回文，获取从回文中间截断后的数字，然后两个数字做比较
        while(x>palNum){
            palNum = palNum*10+x%10;
            x = x/10;
        }

        return palNum == x || palNum/10 == x;
    }
}