class Solution {
    public int jump(int[] nums) { // 接近贪心思想！！！
        int n = nums.length;
        int actualBoundary = 0; // 每一跳结束后的实际边界！！！
        int currentFurthest = 0;  // 计算当前能跳的最远距离，为下一跳准备！！！
        int hop = 0;
        for (int i=0; i<n-1; i++) { // 仅遍历需要跳的位置，n-1处已到达终点，不用遍历！！！
            currentFurthest = Math.max(currentFurthest, i+nums[i]); 
            if (i == actualBoundary) { // 要点：仅当遍历到实际边界时触发下一跳！！！
                actualBoundary = currentFurthest;
                hop++;
            }
        }
        return hop;
    }
}