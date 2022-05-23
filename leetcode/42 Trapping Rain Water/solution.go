func trap(height []int) int { // ���ֽⷨ��˫ָ�����ţ��ܴﵽ����ʱ�䳣���ռ䣡����
    left, right := 0, len(height)-1
    leftMax, rightMax := 0, 0
    result := 0
    for left < right { // �����鿴��ɽ�壬���ջ���һ��ָ�뵽��ɽ�������ֵ��������
        if height[left] < height[right] { // case1������ɽ����ߣ�����
            if height[left] >= leftMax {
                leftMax = height[left] // �����µĸ߷壬����������ֵ������
            } else {
                result += leftMax-height[left] // �����ˮ������
            }
            left++
        } else { // case2������ɽ���ұߣ������ͬ������
            if height[right] >= rightMax {
                rightMax = height[right]
            } else {
                result += rightMax-height[right]
            }
            right--
        }
    }
    return result
}