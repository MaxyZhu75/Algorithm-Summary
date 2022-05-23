class Solution {
    public int maxArea(int[] height) { // ˫ָ�룻��ȷ��֤����LeetCode�ٷ���𣡣���
        int left = 0, right = height.length - 1;
        int result = 0;
		int current = 0;
        while (left < right) {
            current = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, current);
            if (height[left] <= height[right]) { // ע��ÿ��ֻ�ƶ��϶̱ߵ�ָ�룡����
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}