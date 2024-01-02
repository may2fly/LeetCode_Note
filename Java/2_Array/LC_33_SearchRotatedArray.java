/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同
 * 
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
*/

/**
 * 解题思路：二分查找
 * 数组从中间分开成左右两部分的时候，一定有一部分的数组是有序的
 * 
*/
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(nums == null || n==0) return -1;
        if(n==1) return nums[0] == target ? 0 : -1;

        int left = 0, right = n-1;

        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            //判断mid是否在[l, mid]中
            if(nums[0] < nums[mid]){
                //判断target是否在[mid + 1, r] 中
                if(nums[0] <= target && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                //判断target是否在[mid + 1, r] 中
                if(nums[mid] < target && target <= nums[n-1]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}