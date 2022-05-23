class Solution {
    public int trap(int[] height) { // ���ֽⷨ��˫ָ�����ţ��ܴﵽ����ʱ�䳣���ռ䣡����
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int result = 0;
        while (left < right) { // �����鿴��ɽ�壬���ջ���һ��ָ�뵽��ɽ�������ֵ��������
            if (height[left] < height[right]) { // case1������ɽ����ߣ�����
                if (height[left] >= leftMax) {
                    leftMax = height[left]; // �����µĸ߷壬����������ֵ������
                } else {
                    result += (leftMax - height[left]); // �����ˮ������
                }
                left++;
            } else { // case2������ɽ���ұߣ������ͬ������
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