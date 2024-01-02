/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] 
 * （若两个四元组元素一一对应，则认为两个四元组重复）
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length < 4) return result;
        
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0; i<n-3; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            //边界条件判断，如果已排序开始4个数大于目标数，说明后面都不满足，跳出循环
            if((long)nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
            //边界条件判断，如果最后三个数与当前数小于目标数，说明此轮不满足，进行下一轮
            if((long)nums[i] + nums[n-3] + nums[n-2] + nums[n-1] < target) continue;

            for(int j=i+1; j<n; j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;

                int left = j+1, right = n-1;
                while(left<right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum < target){
                        left++;
                    }else if(sum > target){
                        right--;
                    }else{
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while(left<right && nums[left] == nums[left+1]) left++;
                        while(left<right && nums[right] == nums[right-1]) right--;

                        left++;
                        right--;
                    }
                }
            }
        }

        return result;
    }
}