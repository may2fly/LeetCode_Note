/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target，找出candidates中可以使数字和为目标数target的所有不同组合，
 * 并以列表形式返回。你可以按任意顺序返回这些组合。
 * 
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
*/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length == 0) return result;

        backTracking(candidates, target, 0);


        return result;
    } 
    /**
     * 回溯遍历所有元素，虽然可以重复使用，但是需要有开始位置避免重复结果
    */
    private void backTracking(int[] candidates, int target, int start){
        if(target < 0)   return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            path.add(candidates[i]);
            backTracking(candidates, target-candidates[i], i);
            path.remove(path.size()-1);
        }

    }
}