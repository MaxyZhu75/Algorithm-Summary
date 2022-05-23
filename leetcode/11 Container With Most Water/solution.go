func maxArea(height []int) int { // 双指针；正确性证明见LeetCode官方解答！！！
    left, right := 0, len(height)-1
    result, current := 0, 0
    for left < right {
        current = min(height[left], height[right]) * (right - left)
        result = max(result, current)
        if height[left] <= height[right] { // 注意每次只移动较短边的指针！！！
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