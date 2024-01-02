/**
 * 57. 插入区间
 * 
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠
*/

class Solution {
    /**
     * 对插入区间定义左右边界，然后对列表进行遍历，如果有重合则更新左右边界，如果没有重合则添加区间
    */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];

        boolean placed = false;       
        List<int[]> ansList = new ArrayList<>();

        for(int[] interval: intervals){
            if(interval[0]>right){
                if(!placed){
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            }else if(interval[1] < left){
                ansList.add(interval);
            }else{
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if(!placed){
            ansList.add(new int[]{left, right});
        }

        return ansList.toArray(new int[ansList.size()][]);
    }
}