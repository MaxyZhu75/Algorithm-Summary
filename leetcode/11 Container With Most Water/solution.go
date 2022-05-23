func maxArea(height []int) int { // ˫ָ�룻��ȷ��֤����LeetCode�ٷ���𣡣���
    left, right := 0, len(height)-1
    result, current := 0, 0
    for left < right {
        current = min(height[left], height[right]) * (right - left)
        result = max(result, current)
        if height[left] <= height[right] { // ע��ÿ��ֻ�ƶ��϶̱ߵ�ָ�룡����
            left++
        } else {
            right--
        }
    }
    return result
}

func min(a int, b int) int {
    if a <= b {
        return a
    } else {
        return b
    }
}

func max(a int, b int) int {
    if a >= b {
        return a
    } else {
        return b
    }
}