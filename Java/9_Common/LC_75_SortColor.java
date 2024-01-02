/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
*/
class Solution {
    /**
     * 双指针法
    */
    public void sortColors(int[] nums) {
        int m = nums.length;
        //左右指针分别指向数组的左右边界，左边界与0交换，右边界与2交换，遍历变量保存1的值
        int left = 0, right = m-1;
        for(int i=0; i<=right; i++){
            //从0开始遍历有2与👉🏻界交换，左边界与0值进行交换
            while(i<=right && nums[i] == 2){
                int tmp = nums[i];
                nums[i] = nums[right];
                nums[right] = tmp;

                right--;
            }
            //元素为0，与左边界交换
            if(nums[i] == 0){
                int tmp = nums[i];
                nums[i] = nums[left];
                nums[left] = tmp;
                left++;
            }
        }
    }
}