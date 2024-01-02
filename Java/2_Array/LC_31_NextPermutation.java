/**
 * 31. 下一个排列
 * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
 * 
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
*/

/**
 * 解题思路：
 * 
*/

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(nums == null || n <= 1) return;

        //从后往前遍历，找到第一个比后一个数小的数
        int i=n-2;
        //一直要遍历到第一个元素
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }

        if(i>=0){   //到第一个元素也需要找后面的
            int j=n-1;
            //从后往前遍历，找到第一个比后一个数大的数
            while(j>=0 && nums[j] <= nums[i]){
                j--;
            }
            //交换元素
            swap(nums, i, j);
        }

        reverse(nums, i+1, n-1);
    }
/**
 * 反转数组
*/
    private void reverse(int[] nums, int left, int right){
        int L = left, R = right;
        while(L <= R){
            swap(nums, L, R);

            L++;
            R--;
        }
    }
/**
 * 交换数组元素
*/
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}