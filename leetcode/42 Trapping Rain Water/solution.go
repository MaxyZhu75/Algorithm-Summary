func trap(height []int) int { // 多种解法，双指针最优，能达到线性时间常数空间！！！
    left, right := 0, len(height)-1
    leftMax, rightMax := 0, 0
    result := 0
    for left < right { // 将数组看作山峰，最终会有一个指针到达山顶（最大值）！！！
        if height[left] < height[right] { // case1：处理山顶左边！！！
            if height[left] >= leftMax {
                leftMax = height[left] // 出现新的高峰，更新左侧最大值！！！
            } else {
                result += leftMax-height[left] // 否则积水！！！
            }
            left++
        } else { // case2：处理山顶右边，与左侧同理！！！
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