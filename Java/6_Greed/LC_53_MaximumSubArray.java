/**
 * 53. 最大子数组和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 子数组 是数组中的一个连续部分。
*/

/**
 * 1、贪心算法
 * 2、动态规划
*/
class Solution {
    /**
     * 贪心算法，
    */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        //初始值是第一个元素
        int ans = nums[0], pre = 0;
        for(int i=0; i<nums.length; i++){
            //判断子数组值与当前值对比
            pre = Math.max(pre + nums[i], nums[i]);
            ans = Math.max(pre, ans);
        }

        return ans;
    }

    /**
     * 动态规划：
     * 
    */
    public int maxSubArray2(int[] nums) {
        int len = nums.length;

        int[] dp = new int[len];
        dp[0] = nums[0];

        int ans = dp[0];

        for(int i=1; i<len; i++){
            //状态转移公式
            if(dp[i-1] > 0){
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }
}