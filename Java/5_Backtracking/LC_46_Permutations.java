/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
*/

/**
 * 回溯算法
*/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();
    boolean[] used; //java中使用boolean类型，不是Boolean类型

    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return result;

        used = new boolean[nums.length];
        permuteHelp(nums);

        return result;
    }

    private void permuteHelp(int[] nums){
        if(path.size() == nums.length){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(used[i] == true) continue;
            used[i] = true;
            path.add(nums[i]);
            permuteHelp(nums);
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}