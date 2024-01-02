/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
*/

/**
 * 解题思路：
 * 1、回溯法：包含重复数字，则需要对数组排序，然后遍历时跳过已单独排序的
*/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length <= 0) return result;

        used = new boolean[nums.length];
        Arrays.sort(nums);

        permuteUniqueHelp(nums);

        return result;
    }


    private void permuteUniqueHelp(int[] nums) {
        if(path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i] == true) continue;   //全排列中不能重复添加元素
            //对重复元素做排除处理
            if(i>0 && nums[i] == nums[i-1] && used[i-1] == false) continue;

            used[i] = true;
            path.add(nums[i]);
            permuteUniqueHelp(nums);
            used[i] = false;
            path.remove(path.size()-1);
        }
        
    }
}