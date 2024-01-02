/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * 
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * 
 * 注意：解集不能包含重复的组合。
*/
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return result;

        Arrays.sort(candidates);

        backTracking(candidates, target, 0);

        return result;
    }

    private void backTracking(int[] candidates, int target, int start){
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }

        for(int i=start; i<candidates.length; i++){
            //重复元素处理，如果是重复元素，则跳过
            if(i>start && candidates[i] == candidates[i-1]) continue;
            
            path.add(candidates[i]);
            backTracking(candidates, target-candidates[i], i+1);
            path.remove(path.size()-1);
        }
    }
}