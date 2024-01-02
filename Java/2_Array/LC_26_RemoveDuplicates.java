/**
 * 26. 删除有序数组中的重复项
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
*/

/**
 * 解题思路：
 * 1. 遍历数组，如果当前元素与前一个元素不相等，则将其放入结果数组中，并将其后面的元素向后移动一位
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n < 2) return n;

        int fast = 1, slow = 1;

        while(fast<n){
            if(nums[fast] != nums[fast-1]){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }

        return slow;
    }
}