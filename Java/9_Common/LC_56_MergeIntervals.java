/**
 * 56. 合并区间
 * 
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        //二维数组排序，第二个参数为排序的规则
        Arrays.sort(intervals, (o1,o2)->Integer.compare(o1[0],o2[0]));

        List<int[]> res = new LinkedList<>();
        int start = intervals[0][0];

        //遍历区间，同时合并值
        for(int i=1; i<intervals.length; i++){
            if(intervals[i-1][1] < intervals[i][0]){
                res.add(new int[]{start, intervals[i-1][1]});
                start = intervals[i][0];
            }else{
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            }
        }

        res.add(new int[]{start, intervals[intervals.length-1][1]});

        return res.toArray(new int[res.size()][]);

    }
}