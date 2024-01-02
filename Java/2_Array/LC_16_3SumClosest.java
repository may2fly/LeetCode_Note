/**
 * 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 
 * 返回这三个数的和。
 * 
 * 假定每组输入只存在恰好一个解。
*/

/**
 * 解题思路：
 * 1、定义一个变量best，初始化为一个很大的数，用于记录最接近的和。
 * 2、对数组排序，遍历，然后使用双指针法，分别指向数组的最左边和最右边。
 * 3、更新best的值，确保已遍历的三个数的和与target的差值最小。
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;

        int best = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            int left = i+1, right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == target){
                    return target;
                }else if(target < sum){
                    right--;
                }else{
                    left++;
                }

                if(Math.abs(sum - target) < Math.abs(target - best)){
                    best = sum;
                }
            }
        }

        return best;
    }
}