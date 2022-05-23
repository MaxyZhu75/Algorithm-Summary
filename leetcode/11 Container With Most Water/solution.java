class Solution {
    public int maxArea(int[] height) { // 双指针；正确性证明见LeetCode官方解答！！！
        int left = 0, right = height.length - 1;
        int result = 0;
		int current = 0;
        while (left < right) {
            current = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, current);
            if (height[left] <= height[right]) { // 注意每次只移动较短边的指针！！！
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}