public class Solution {
    public boolean canJump(int[] nums) { // 贪心地找到当前能到达的最远位置！！！
        int n = nums.length;
        int farest = 0;
        for (int i=0; i<n; i++) {
            if (i <= farest) { // 在能跳到的范围内遍历，看能否更新最远位置！！！
                farest = Math.max(farest, i+nums[i]);
                if (farest >= n-1) {
                    return true;
                }
            }
        }
        return false;
    }
}