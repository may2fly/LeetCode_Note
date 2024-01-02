/**
 * 45. 跳跃游戏 II
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 1、0 <= j <= nums[i] 
 * 2、i + j < n
 * 
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
*/
class Solution {
    public int jump(int[] nums) {
        //预处理判断，nums长度为1时，跳跃次数为0
        if(nums == null || nums.length <= 1) return 0;
        
        int ans = 0;
         //curStep表示当前位置，nextStep表示下一步的最大位置
        int curStep = 0, nextStep = 0;
        //贪心算法，计算下一步最大的步数，
       
        for(int i=0; i<nums.length; i++){
            nextStep = Math.max(i+nums[i], nextStep);
            if(nextStep >= nums.length-1){//当到达最后一个位置时，返回最小跳跃次数
                ans += 1;
                return ans;
            }

            if(curStep == i){
                curStep = nextStep;
                ans++;
            }
        }

        return ans;
    }
}