/**
 * 15. 三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 
 * 你返回所有和为 0 且不重复的三元组。
 * 
 * */

/**
 * 解题思路：
 * 1. 双指针法：先排序数组，然后遍历数组，双指针，三数之和做比较，重复元素处理
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length < 3) return result;

        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0; i<nums.length; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;   //重复元素处理

            int left = i+1, right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum < 0){
                    left++;
                }else if(sum > 0){
                    right--;
                }else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //重复元素处理
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                }
            }
        }

        return result;
    }
}