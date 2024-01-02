/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 * 返回容器可以储存的最大水量。
*/

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;//定义左右边界

        int res = 0;
        while(left < right){
            //获取当前容器的面积
            int area = Math.min(height[left], height[right]) * (right-left);

            res = Math.max(res, area);  //更新结果

            if(height[left] < height[right]){   //更新边界
                left++;
            }else{
                right--;
            }
        }
        
        return res;
    }
}