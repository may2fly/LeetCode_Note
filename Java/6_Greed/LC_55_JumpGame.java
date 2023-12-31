/**
 * 55. 跳跃游戏
 * 
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
*/
class Solution {
    public boolean canJump(int[] nums) {
        int cover = 0;

        for(int i=0; i<=cover; i++){
            if(cover >= nums.length-1){
                return true;
            }

            cover = Math.max(cover, i + nums[i]);
        }
        return false;
    }
}