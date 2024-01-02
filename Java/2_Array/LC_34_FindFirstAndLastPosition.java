/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length < 2) return new int[]{-1, -1};

        int left = searchRange(nums, target, true);
        int right = searchRange(nums, target, false) - 1;
        if(left<=right && right<nums.length && nums[left] == target || nums[right] == target){
            return new int[]{left, right};
        }

        return new int[]{-1, -1};
    }

    /**
     * 二分查找,
    */
    private int searchRange(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length-1, ans = nums.length;

        while(left <= right){
            int mid = left + (right-left)/2;
            //1、条件左边界
            //2、查找第一个元素并且中间值大于等于target
            if(nums[mid] > target || (lower && nums[mid] >= target)){
                ans = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
}