class Solution {
    public int trap(int[] height) { // 多种解法，双指针最优，能达到线性时间常数空间！！！
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;
        while (left < right) { // 将数组看作山峰，最终会有一个指针到达山顶（最大值）！！！
            if (height[left] < height[right]) { // case1：处理山顶左边！！！
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // 出现新的高峰，更新左侧最大值！！！
                } else {
                    result += (leftMax - height[left]); // 否则积水！！！
                }
                left++;
            } else { // case2：处理山顶右边，与左侧同理！！！
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    result += (rightMax - height[right]);
                }
                right--;
            }
        }
        return result;
    }
}