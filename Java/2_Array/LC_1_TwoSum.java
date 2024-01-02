/*
* 1. 两数之和
* 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
* 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
* 你可以按任意顺序返回答案。
*/

/*
* 解题思路：
* 1. 遍历数组，将每个元素和其对应的下标存储到map中
* 2. 遍历数组，查找target - nums[i]是否存在于map中，若存在，则返回对应的下标
* 3. 若不存在，则将当前元素和其对应的下标存储到map中
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }else{
                map.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};//数组初始化
    }
}